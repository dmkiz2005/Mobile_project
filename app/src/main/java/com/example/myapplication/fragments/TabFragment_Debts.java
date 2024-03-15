package com.example.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapters.Adapter_Order;
import com.example.myapplication.json.JsonReader;
import com.example.myapplication.new_types.Product_orders;
import com.example.myapplication.requests.OneC_Request;

import java.util.ArrayList;
import java.util.List;

public class TabFragment_Debts extends Fragment {

    private List<Product_orders> arrayList;
    private ArrayList<Product_orders> itemList;
    private RecyclerView recyclerView;
    private Adapter_Order adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_debts, container, false);
        recyclerView = view.findViewById(R.id.recyclerView2);
        JsonReader jsonReader = new JsonReader();
        fetchData(jsonReader);
        return view;
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

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));

        adapter = new Adapter_Order(requireActivity(), (ArrayList<Product_orders>) arrayList);
        recyclerView.setAdapter(adapter);
    }
}