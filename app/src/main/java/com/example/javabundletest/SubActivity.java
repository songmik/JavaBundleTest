package com.example.javabundletest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SubActivity extends AppCompatActivity implements TwoFragment.Fragment2Listener , ThreeFragment.Fragment3Listener {

    TwoFragment fragment_2;
    ThreeFragment fragment_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        fragment_2 = new TwoFragment();
        fragment_3 = new ThreeFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.f_2, fragment_2)
                .replace(R.id.f_3, fragment_3)
                .commit();
    }

    @Override
    public void onInput2Sent(CharSequence input) {
        fragment_3.updateEditText(input);
    }

    @Override
    public void onInput3Sent(CharSequence input) {
        fragment_2.updateEditText(input);

    }

}