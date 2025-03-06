package com.project1_unitconversi;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;

public class DetailSuhuActivity extends AppCompatActivity {

    Spinner spSuhu;
    EditText edInputSuhu;
    TextView txtHasilSuhu;
    Button btnHitung;
    float hasilConversi = 0;
    int posConversi = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_suhu);

        //Deklarasi component
        edInputSuhu = findViewById(R.id.edInputSuhu);
        txtHasilSuhu = findViewById(R.id.txtHasil);
        spSuhu = findViewById(R.id.spSuhu);
        btnHitung = findViewById(R.id.btnHitung);

        /*
        Data Array Suhu
        0 = Cel to Re, rumus 4/5 * Cel
        1 = Cel to Far, rumus (9/5 x °Cel) + 32
        2 = Re to Cel, rumus (5/4 x R)
        3 = Re to Far, rumus 9/4 x R + 32;
         */

        //Data Array Suhu
        String[] datasuhu = new String[] {"Celsius to Reamur", "Celsius to Fahrenheit", "Reamur to Celsius", "Reamur to Fahrenheit"};
        spSuhu = findViewById(R.id.spSuhu);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, datasuhu);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSuhu.setAdapter(adapter);
        spSuhu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK); /* if you want your item to be white */
                posConversi = spSuhu.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (posConversi==0){
                    hasilConversi = 0;
                    if (!"".equals(edInputSuhu.getText()))
                        hasilConversi = (float) (Integer.parseInt(edInputSuhu.getText().toString()) * 4)/5;
                    txtHasilSuhu.setText(""+hasilConversi);
                } else if (posConversi==1){
                    //Proses Cel to Far
                    if (!"".equals(edInputSuhu.getText()))
                        hasilConversi = (float) (Integer.parseInt(edInputSuhu.getText().toString()) * 9)/5 + 32;
                    txtHasilSuhu.setText(""+hasilConversi);
                } else if(posConversi==2){
                    //Proses Re to Cel
                    if (!"".equals(edInputSuhu.getText()))
                        hasilConversi = (float) (Integer.parseInt(edInputSuhu.getText().toString()) * 5)/4;
                    txtHasilSuhu.setText(""+hasilConversi);
                } else if (posConversi==3){
                    //Proses Re to Far
                    if (!"".equals(edInputSuhu.getText()))
                        hasilConversi = (float) (Integer.parseInt(edInputSuhu.getText().toString()) * 9)/4 + 32;
                    txtHasilSuhu.setText(""+hasilConversi);
                }
            }
        });
    }
}
