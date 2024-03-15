package com.example.myapplication.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.fragments.TabFragment_Debts;
import com.example.myapplication.fragments.TabFragment_Head;
import com.example.myapplication.fragments.TabFragment_Info;
import com.example.myapplication.fragments.TabFragment_Lines;
import com.example.myapplication.fragments.TabFragment_Oborud;
import com.example.myapplication.fragments.TabFragment_Products;
import com.example.myapplication.fragments.TabFragment_Return;
import com.example.myapplication.fragments.TabFragment_Task;

public class Adapter_Fragment extends FragmentStateAdapter {

    public Adapter_Fragment(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new TabFragment_Head();
            case 1:
                return new TabFragment_Products();
            case 2:
                return new TabFragment_Debts();
            case 3:
                return new TabFragment_Return();
            case 4:
                return new TabFragment_Lines();
            case 5:
                return new TabFragment_Oborud();
            case 6:
                return new TabFragment_Task();
            case 7:
                return new TabFragment_Info();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 8; // Количество вкладок
    }
}
