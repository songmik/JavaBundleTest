package com.example.javabundletest;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class TwoFragment extends Fragment {

    private ViewGroup rootView;
    EditText edit_2;
    Button button_2;
    Fragment2Listener listener;

    public interface Fragment2Listener {
        void onInput2Sent(CharSequence input);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_two, container, false);

        edit_2 = rootView.findViewById(R.id.edit_2);
        button_2 = rootView.findViewById(R.id.button_2);
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = edit_2.getText().toString();
                listener.onInput2Sent(input);
            }
        });

        return rootView;
    }


    public void updateEditText(CharSequence newText) {
        edit_2.setText(newText);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Fragment2Listener) {
            listener = (Fragment2Listener) context;
        } else {
            throw new RuntimeException(context.toString() + "implement F");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}