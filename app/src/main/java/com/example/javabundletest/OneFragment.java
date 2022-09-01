package com.example.javabundletest;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("key", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
                String result = bundle.getString("bundleKey");
            }
        });
    }
}