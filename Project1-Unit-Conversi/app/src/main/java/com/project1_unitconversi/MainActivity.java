cpackage com.project1_unitconversi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    CardView cdTemp;
    CardView cdMasa;
    CardView cdLuas;
    CardView cdJarak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cdTemp = findViewById(R.id.cdTemp);
        cdTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DetailSuhuActivity.class));
            }
        });
        cdMasa = findViewById(R.id.cdMasa);
        cdMasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DetailMasaActivity.class));
            }
        });
        cdLuas = findViewById(R.id.cdLuas);
        cdLuas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DetailLuasActivity.class));
            }
        });
        cdJarak = findViewById(R.id.cdJarak);
        cdJarak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DetailJarakActivity.class));
            }
        });
    }
}