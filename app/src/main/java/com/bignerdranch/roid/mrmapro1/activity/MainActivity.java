package com.bignerdranch.roid.mrmapro1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.bignerdranch.roid.mrmapro1.R;
import com.bignerdranch.roid.mrmapro1.fragments.ExpenseListFragment;
import com.bignerdranch.roid.mrmapro1.models.ExpenseModel;
import com.bignerdranch.roid.mrmapro1.models.ExpensesViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpensesViewModel mExpensesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPager();
    }

    public void initPager(){
        ViewPager mainViewPager = findViewById(R.id.activity_view_pager);
        ExpenseViewPagerAdapter expenseViewPagerAdapter = new ExpenseViewPagerAdapter(getSupportFragmentManager(),this);
        mainViewPager.setAdapter(expenseViewPagerAdapter);
        TabLayout tabLayout = findViewById(R.id.activity_tab_layout);
        tabLayout.setupWithViewPager(mainViewPager);
    }


    public ExpensesViewModel getmExpensesViewModel() {
        return mExpensesViewModel;
    }
}