package com.project1_unitconversi;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import static com.project1_unitconversi.R.layout.activity_detail_luas;

public class DetailLuasActivity extends AppCompatActivity {

    private EditText etInputLuas;
    private Spinner spinnerKonversiLuas;
    private Button btnHitungLuas;
    private TextView tvHasilLuas;

    private String selectedConversion = "Meter Persegi ke Centimeter Persegi"; // Default pilihan pertama

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_detail_luas);

        // Inisialisasi komponen
        etInputLuas = findViewById(R.id.etInputLuas);
        spinnerKonversiLuas = findViewById(R.id.spinnerKonversiLuas);
        btnHitungLuas = findViewById(R.id.btnHitungLuas);
        tvHasilLuas = findViewById(R.id.tvHasilLuas);

        // Data Spinner dengan berbagai satuan luas
        ArrayList<String> listKonversiLuas = new ArrayList<>();
        listKonversiLuas.add("Meter Persegi ke Centimeter Persegi");
        listKonversiLuas.add("Centimeter Persegi ke Meter Persegi");
        listKonversiLuas.add("Meter Persegi ke Hektar");
        listKonversiLuas.add("Hektar ke Meter Persegi");
        listKonversiLuas.add("Meter Persegi ke Kilometer Persegi");
        listKonversiLuas.add("Kilometer Persegi ke Meter Persegi");

        // Set adapter untuk Spinner
        ArrayAdapter<String> adapterLuas = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listKonversiLuas);
        spinnerKonversiLuas.setAdapter(adapterLuas);

        // Listener untuk menangkap item yang dipilih
        spinnerKonversiLuas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK); /* if you want your item to be white */
                selectedConversion = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedConversion = "Meter Persegi ke Centimeter Persegi";
            }
        });

        // Tombol Hitung
        btnHitungLuas.setOnClickListener(v -> hitungKonversi());
    }

    private void hitungKonversi() {
        String inputText = etInputLuas.getText().toString();
        if (inputText.isEmpty()) {
            Toast.makeText(this, "Masukkan nilai terlebih dahulu", Toast.LENGTH_SHORT).show();
            return;
        }

        double inputValue = Double.parseDouble(inputText);
        double hasil = 0;

        switch (selectedConversion) {
            case "Meter Persegi ke Centimeter Persegi":
                hasil = inputValue * 10_000; // 1 m² = 10,000 cm²
                break;
            case "Centimeter Persegi ke Meter Persegi":
                hasil = inputValue / 10_000; // 1 cm² = 0.0001 m²
                break;
            case "Meter Persegi ke Hektar":
                hasil = inputValue / 10_000; // 1 m² = 0.0001 ha
                break;
            case "Hektar ke Meter Persegi":
                hasil = inputValue * 10_000; // 1 ha = 10,000 m²
                break;
            case "Meter Persegi ke Kilometer Persegi":
                hasil = inputValue / 1_000_000; // 1 m² = 0.000001 km²
                break;
            case "Kilometer Persegi ke Meter Persegi":
                hasil = inputValue * 1_000_000; // 1 km² = 1,000,000 m²
                break;
        }

        tvHasilLuas.setText(String.format("%.2f", hasil));
    }
}