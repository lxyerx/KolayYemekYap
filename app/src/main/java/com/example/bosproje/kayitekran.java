package com.example.bosproje;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class kayitekran extends AppCompatActivity {

    private EditText adtext , sifretext, sehirtext, yastext;

    private String editAd, editSifre, editSehir, editYas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayitekran);
        //edittexlerr
        adtext = (EditText) findViewById(R.id.adtext);
        sifretext = (EditText) findViewById(R.id.soyadtext);
        sehirtext = (EditText) findViewById(R.id.sehirtext);
        yastext = (EditText) findViewById(R.id.yastext);

    }

    // firebase veritabanına bu butona tıklayınca hello world yazan bir mesaj gitmesi lazım fakat gitmedi
    // not: butonu sildim

    public void BozukButonDenemesi(View view){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
    }

    public void gonder2(View view){ // anasayfaya yolluyor
        // intent oluşturduk sonuna ise gideceğimiz yeri yazdık
        Intent anasayfa = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(anasayfa);
    }

    public void BtnKayitOl(View v){
        editAd = adtext.getText().toString();
        editSifre = sifretext.getText().toString();
        editSehir = sehirtext.getText().toString();
        editYas = yastext.getText().toString();
        //bos mu değil mi kontrol ediyoruz tek satırda sonra da bilgileri yaziyoruz // bilgileri logcatten kontrol edebilirsin
        if(!TextUtils.isEmpty(editAd) && !TextUtils.isEmpty(editSifre) && !TextUtils.isEmpty(editSehir) && !TextUtils.isEmpty(editYas)){
            System.out.println("---- Bilgileriniz ----");
            System.out.println("Adınız: " + editAd);
            System.out.println("Sifreniz: " + editSifre);
            System.out.println("Şehriniz: " + editSehir);
            System.out.println("Yasiniz: " + editYas);
            System.out.println();
            System.out.print("Kayit Basariyla Gerçekleşti. ");
        }
        else { // toast ekrana kücük bir uyarı veriyor
            Toast.makeText(this, "Sifre bos olamaz", Toast.LENGTH_SHORT).show();
        }
    }
}