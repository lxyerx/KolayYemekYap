package com.example.bosproje;
import static android.widget.CompoundButton.*;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class yemeksorgu extends AppCompatActivity {

    CheckBox yumurtaedit, yagedit, domatesedit, soganedit, biberedit, tuzedit;

    public void butonanasayfa(View view){
        Intent anasayfaa = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(anasayfaa);
    }

    //oncreate yani ilk açıldığında gerçekleşecek olayları barındırıyor
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yemeksorgu);

        CheckBox checkBox = findViewById(R.id.yumurta);
        CheckBox checkBox2 = findViewById(R.id.tuz);
        CheckBox checkBox3 = findViewById(R.id.domates);
        CheckBox checkBox4 = findViewById(R.id.sogan);
        CheckBox checkBox5 = findViewById(R.id.biber);
        CheckBox checkBox6 = findViewById(R.id.yag);


        checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox.isChecked() && checkBox2.isChecked() && checkBox6.isChecked()) {
                    Intent yumurtayayolluyor = new Intent(getApplicationContext(), yumurtahazir.class);
                    startActivity(yumurtayayolluyor);
                }
                if (checkBox.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked() && checkBox5.isChecked() && checkBox6.isChecked()) {
                    Intent menemenhazir = new Intent(getApplicationContext(), menemenhazir.class);
                    startActivity(menemenhazir);
                } else
                    Toast.makeText(yemeksorgu.this, "Uygun Yemek Bulunamadi", Toast.LENGTH_SHORT).show();
            }
        });


    }
}