package com.example.flowers;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FlowersListItem#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FlowersListItem extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FlowersListItem() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FlowersListItem.
     */
    // TODO: Rename and change types and number of parameters
    public static FlowersListItem newInstance(String param1, String param2) {
        FlowersListItem fragment = new FlowersListItem();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_flowers_list_item, container, false);
    }

    //Переменные для хранения нужной инфы
    int photoId;
    String flowerName;

    //Переменные для эл. разметки
    ImageView photoIv;
    TextView flowerNameTv;
    ConstraintLayout layout;

    //Конструктор для получения новой информации
    public FlowersListItem(int photoId, String flowerName){
        this.photoId = photoId;
        this.flowerName = flowerName;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Инициализация переменных для эл. разметки
        photoIv = view.findViewById(R.id.flower_photo);
        flowerNameTv = view.findViewById(R.id.flower_name);
        layout = view.findViewById(R.id.fragment_flowers_list_item_layout);

        //Задаем карточку согласно параметрам
        photoIv.setImageResource(photoId);
        flowerNameTv.setText(flowerName);

        //Переходим на страничку букета
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toFlowerPage = new Intent(FlowersListItem.this.getActivity(), FlowerItemPage.class);
                toFlowerPage.putExtra("name", flowerName);
                toFlowerPage.putExtra("photoId", photoId);
                startActivity(toFlowerPage);
            }
        });

    }

}