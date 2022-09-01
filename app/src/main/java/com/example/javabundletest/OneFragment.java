package com.example.javabundletest;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class OneFragment extends Fragment {

    private ViewGroup rootView;
    TextView text;
    String getName;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_one, container, false);

        getDataFromActivity();

        return rootView;
    }


    @SuppressLint("SetTextI18n")
    private void getDataFromActivity() {
        text = rootView.findViewById(R.id.text_1);
        getName = this.getArguments().getString("name");

        text.setText(getName + "님의 정보를 입력하세요");
    }

    private void sendDataToNextF(){

    }
}