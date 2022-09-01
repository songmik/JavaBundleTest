package com.example.javabundletest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/*

Activity에서 입력한 데이터를 Fragment로 보내주는 코드 -> 전송 성공
fragment -> fragment 데이터 전송 (참고 : https://aries574.tistory.com/112)
MainActivity -> OneFragment //    TwoFragment -> ThreeFragment 를 SubActivity에 보여주는것
1. Activity -> Fragment이동
2. Fragment -> Fragment이동 (하는 화면을 SubActivity에 표현)

 */


public class MainActivity extends AppCompatActivity {

    Button sendB;
    EditText editT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendDataToBlankF();

    }


    private void sendDataToBlankF() {
        sendB = findViewById(R.id.button_A);
        editT = findViewById(R.id.edit_A);
        sendB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                Bundle bundle = new Bundle();

                String name = editT.getText().toString();
                bundle.putString("name", name);
                OneFragment oneFragment = new OneFragment();
                oneFragment.setArguments(bundle);

                transaction.replace(R.id.frameL, oneFragment).commit();
            }
        });
    }
}