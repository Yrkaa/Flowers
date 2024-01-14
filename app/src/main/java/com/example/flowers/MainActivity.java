package com.example.flowers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    //Создание переменных для эл. разметки
    Spinner orderList;
    ListView flowerList;
    ImageView adIv, tgIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Инициализация переменных для эл. разметки
        orderList = findViewById(R.id.order_spinner);
        flowerList = findViewById(R.id.flowers_list);
        adIv = findViewById(R.id.ad_iv);
        tgIv = findViewById(R.id.tg_iv);

        //Переход в тг канал
        tgIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toTg = new Intent(Intent.ACTION_VIEW, Uri.parse(/*Это ссылка для открытия тг(в domain надо указать название канала)*/"tg://resolve?domain=cweti_dostavka"));
                startActivity(toTg);
            }
        });
    }
}