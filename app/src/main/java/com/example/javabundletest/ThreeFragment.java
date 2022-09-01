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

public class ThreeFragment extends Fragment {

    private ViewGroup rootView;
    EditText edit_3;
    Button button_3;
    Fragment3Listener listener;

    public interface Fragment3Listener {
        void onInput3Sent(CharSequence input);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_three, container, false);

        edit_3 = rootView.findViewById(R.id.edit_3);
        button_3 = rootView.findViewById(R.id.button_3);
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = edit_3.getText().toString();
                listener.onInput3Sent(input);
            }
        });

        return rootView;
    }

    public void updateEditText(CharSequence newText) {
        edit_3.setText(newText);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Fragment3Listener) {
            listener = (Fragment3Listener) context;
        } else {
            throw new RuntimeException(context.toString() + "must impl");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}