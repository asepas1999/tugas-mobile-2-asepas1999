package com.example.konversimasa;

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

import com.project1_unitconversi.R;

import java.util.ArrayList;

public class DetailMasaActivity extends AppCompatActivity {

    private EditText etInputMasa;
    private Spinner spinnerKonversiMasa;
    private Button btnHitungMasa;
    private TextView tvHasilMasa;

    private String selectedConversion = "Kilogram ke Gram"; // Default pilihan pertama

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_masa);

        // Inisialisasi komponen
        etInputMasa = findViewById(R.id.etInputMasa);
        spinnerKonversiMasa = findViewById(R.id.spinnerKonversiMasa);
        btnHitungMasa = findViewById(R.id.btnHitungMasa);
        tvHasilMasa = findViewById(R.id.tvHasilMasa);

        // Data Spinner dengan satuan baru (Ons dan Ton)
        ArrayList<String> listKonversiMasa = new ArrayList<>();
        listKonversiMasa.add("Kilogram ke Gram");
        listKonversiMasa.add("Gram ke Kilogram");
        listKonversiMasa.add("Kilogram ke Ons");
        listKonversiMasa.add("Ons ke Kilogram");
        listKonversiMasa.add("Kilogram ke Ton");
        listKonversiMasa.add("Ton ke Kilogram");

        // Set adapter untuk Spinner
        ArrayAdapter<String> adapterMasa = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listKonversiMasa);
        spinnerKonversiMasa.setAdapter(adapterMasa);

        // Listener untuk menangkap item yang dipilih
        spinnerKonversiMasa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedConversion = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedConversion = "Kilogram ke Gram";
            }
        });

        // Tombol Hitung
        btnHitungMasa.setOnClickListener(v -> hitungKonversi());
    }

    private void hitungKonversi() {
        String inputText = etInputMasa.getText().toString();
        if (inputText.isEmpty()) {
            Toast.makeText(this, "Masukkan nilai terlebih dahulu", Toast.LENGTH_SHORT).show();
            return;
        }

        double inputValue = Double.parseDouble(inputText);
        double hasil = 0;

        switch (selectedConversion) {
            case "Kilogram ke Gram":
                hasil = inputValue * 1000;
                break;
            case "Gram ke Kilogram":
                hasil = inputValue / 1000;
                break;
            case "Kilogram ke Ons":
                hasil = inputValue * 10; // 1 kg = 10 ons
                break;
            case "Ons ke Kilogram":
                hasil = inputValue / 10; // 1 ons = 0.1 kg
                break;
            case "Kilogram ke Ton":
                hasil = inputValue / 1000; // 1 kg = 0.001 ton
                break;
            case "Ton ke Kilogram":
                hasil = inputValue * 1000; // 1 ton = 1000 kg
                break;
        }

        tvHasilMasa.setText(String.format("%.2f", hasil));
    }
}