package com.bignerdranch.roid.mrmapro1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.bignerdranch.roid.mrmapro1.R;
import com.bignerdranch.roid.mrmapro1.fragments.ExpenseListFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

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
}
