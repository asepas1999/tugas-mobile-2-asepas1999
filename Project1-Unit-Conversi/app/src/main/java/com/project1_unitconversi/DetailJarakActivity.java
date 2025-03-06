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

public class DetailJarakActivity extends AppCompatActivity {

    private EditText etInputJarak;
    private Spinner spinnerKonversiJarak;
    private Button btnHitungJarak;
    private TextView tvHasilJarak;

    private String selectedConversion = "Kilometer ke Meter"; // Default pilihan pertama

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_jarak);

        // Inisialisasi komponen
        etInputJarak = findViewById(R.id.etInputJarak);
        spinnerKonversiJarak = findViewById(R.id.spinnerKonversiJarak);
        btnHitungJarak = findViewById(R.id.btnHitungJarak);
        tvHasilJarak = findViewById(R.id.tvHasilJarak);

        // Data Spinner dengan berbagai satuan jarak
        ArrayList<String> listKonversiJarak = new ArrayList<>();
        listKonversiJarak.add("Kilometer ke Meter");
        listKonversiJarak.add("Meter ke Kilometer");
        listKonversiJarak.add("Meter ke Centimeter");
        listKonversiJarak.add("Centimeter ke Meter");
        listKonversiJarak.add("Kilometer ke Mil");
        listKonversiJarak.add("Mil ke Kilometer");

        // Set adapter untuk Spinner
        ArrayAdapter<String> adapterJarak = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listKonversiJarak);
        spinnerKonversiJarak.setAdapter(adapterJarak);

        // Listener untuk menangkap item yang dipilih
        spinnerKonversiJarak.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK); /* if you want your item to be white */
                selectedConversion = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedConversion = "Kilometer ke Meter";
            }
        });

        // Tombol Hitung
        btnHitungJarak.setOnClickListener(v -> hitungKonversi());
    }

    private void hitungKonversi() {
        String inputText = etInputJarak.getText().toString();
        if (inputText.isEmpty()) {
            Toast.makeText(this, "Masukkan nilai terlebih dahulu", Toast.LENGTH_SHORT).show();
            return;
        }

        double inputValue = Double.parseDouble(inputText);
        double hasil = 0;

        switch (selectedConversion) {
            case "Kilometer ke Meter":
                hasil = inputValue * 1000; // 1 km = 1000 m
                break;
            case "Meter ke Kilometer":
                hasil = inputValue / 1000; // 1 m = 0.001 km
                break;
            case "Meter ke Centimeter":
                hasil = inputValue * 100; // 1 m = 100 cm
                break;
            case "Centimeter ke Meter":
                hasil = inputValue / 100; // 1 cm = 0.01 m
                break;
            case "Kilometer ke Mil":
                hasil = inputValue * 0.621371; // 1 km = 0.621371 mil
                break;
            case "Mil ke Kilometer":
                hasil = inputValue / 0.621371; // 1 mil = 1.60934 km
                break;
        }

        tvHasilJarak.setText(String.format("%.2f", hasil));
    }
}