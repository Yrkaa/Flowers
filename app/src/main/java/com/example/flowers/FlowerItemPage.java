package com.example.flowers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;

public class FlowerItemPage extends AppCompatActivity {

    //Инициализация переменных для эл. разметки
    RoundedImageView flowerPhotoIv;
    TextView flowerNameTv;
    Button payBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower_item_page);

        //Инициализация переменных для эл. разметки
        flowerPhotoIv = findViewById(R.id.flower_photo_in_page);
        flowerNameTv = findViewById(R.id.flower_name_in_page);

        //Получение данных о букете
        String flowerName = getIntent().getStringExtra("name");
        int flowerPhotoId = getIntent().getIntExtra("photoId", -1);

        //Представление данных о букете
        if(flowerPhotoId != -1){
            flowerPhotoIv.setImageResource(flowerPhotoId);
            flowerNameTv.setText(flowerName);
        }
    }
}