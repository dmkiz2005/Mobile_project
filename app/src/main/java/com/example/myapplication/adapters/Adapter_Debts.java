package com.example.myapplication.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.new_types.Item_debts;

import java.util.ArrayList;

public class Adapter_Debts extends RecyclerView.Adapter<Adapter_Debts.ViewHolder> {
    private Context mContext;
    private ArrayList<Item_debts> mItems_Debts;

    public Adapter_Debts(Context context, ArrayList<Item_debts> item_debts) {
        mContext = context;
        mItems_Debts = item_debts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_debts, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item_debts currentDataModel = mItems_Debts.get(position);

        holder.checkBox.setChecked(currentDataModel.isCheckbox());
        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            currentDataModel.setCheckbox(isChecked);
        });

        holder.textView1.setText(currentDataModel.getName_company());
        holder.textView2.setText(currentDataModel.getAdress_company());
        holder.textView3.setText(currentDataModel.getPrice_debts());
        if (position % 2 != 0) {
            holder.itemView.setBackgroundColor(Color.GRAY);
        } else {
            holder.itemView.setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public int getItemCount() {
        return mItems_Debts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        TextView textView1;
        TextView textView2;
        TextView textView3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkBox);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
        }
    }
}


