package com.example.myapplication.functions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.adapters.Adapter_Debts;
import com.example.myapplication.adapters.Adapter_Fragment;
import com.example.myapplication.adapters.Adapter_Order;
import com.example.myapplication.json.JsonReader;
import com.example.myapplication.new_types.Item_debts;
import com.example.myapplication.new_types.Product_orders;
import com.example.myapplication.requests.OneC_Request;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Orders extends AppCompatActivity {

    private List<Product_orders> arrayList;
    private ArrayList<Product_orders> itemList;
    private RecyclerView recyclerView;
    private Adapter_Order adapter;
    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        Adapter_Fragment adapter = new Adapter_Fragment(this);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText("Tab " + (position + 1))
        ).attach();
        System.out.println("YES");
        //JsonReader jsonReader = new JsonReader();
        //fetchData(jsonReader);
    }

    private void fetchData(final JsonReader jsonReader) {
        OneC_Request.sendRequest(new OneC_Request.OnRequestListener() {
            @Override
            public void onRequestComplete(String result) {
                System.out.println(result);
                arrayList = jsonReader.getObject(result);
                if (arrayList != null) {
                    handleData(arrayList);
                } else {
                    System.out.println("Failed to parse JSON");
                }
            }
        });
    }

    private void handleData(List<Product_orders> arrayList) {

        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new Adapter_Order(this, (ArrayList<Product_orders>) arrayList);
        recyclerView.setAdapter(adapter);
    }

}
