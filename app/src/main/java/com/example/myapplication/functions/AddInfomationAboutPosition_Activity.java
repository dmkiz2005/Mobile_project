package com.example.myapplication.functions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapters.Adapter_Name_Company;

import java.util.ArrayList;

public class AddInfomationAboutPosition_Activity extends Activity {

    private ArrayList<String> itemList;
    private RecyclerView recyclerView;
    private Adapter_Name_Company adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_infomation_about_position);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<>();

        for(int i = 0;i<50;i++){
            itemList.add("Position of company "+(i+1));
        }

        adapter = new Adapter_Name_Company(itemList, new Adapter_Name_Company.OnItemClickListener() {
            @Override
            public void onItemClick(String item) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", item);
                resultIntent.putExtra("where", 2);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });
        recyclerView.setAdapter(adapter);
/*
        Button setResultButton = findViewById(R.id.set_result_button);
        setResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", "Результат");
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

 */
    }
}
