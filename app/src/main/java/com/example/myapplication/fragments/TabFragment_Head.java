package com.example.myapplication.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.functions.AddInfomationAboutName_Activity;
import com.example.myapplication.functions.AddInfomationAboutPosition_Activity;
import com.example.myapplication.new_types.CustomEditText;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.functions.AddInfomationAboutName_Activity;
import com.example.myapplication.functions.AddInfomationAboutPosition_Activity;
import com.example.myapplication.new_types.CustomEditText;

public class TabFragment_Head extends Fragment {

    private static final int REQUEST_CODE = 123;
    private CustomEditText customEditText;
    private CustomEditText customEditText2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_head, container, false);
        customEditText = view.findViewById(R.id.spinner);
        customEditText2 = view.findViewById(R.id.spinner2);
        customEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddInfomationAboutName_Activity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        customEditText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddInfomationAboutPosition_Activity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            String result = data.getStringExtra("result");
            int where = data.getIntExtra("where", 0);
            if(where==1){
                customEditText.setText(result);
            }
            else {
                customEditText2.setText(result);
            }
        }
    }
}