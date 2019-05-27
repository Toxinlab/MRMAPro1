package com.bignerdranch.roid.mrmapro1.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
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
        mExpensesViewModel = ViewModelProviders.of(this).get(ExpensesViewModel.class);

        initPager();
    }

    public void initPager(){
        ViewPager mainViewPager = findViewById(R.id.activity_view_pager);
        mainViewPager.setOffscreenPageLimit(3);
        ExpenseViewPagerAdapter expenseViewPagerAdapter = new ExpenseViewPagerAdapter(getSupportFragmentManager(),this);
        mainViewPager.setAdapter(expenseViewPagerAdapter);
        TabLayout tabLayout = findViewById(R.id.activity_tab_layout);
        tabLayout.setupWithViewPager(mainViewPager);
    }


    public ExpensesViewModel getmExpensesViewModel() {
        return mExpensesViewModel;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == DetailsActivity.BACK_CODE){
            return;
        }
        if(resultCode == DetailsActivity.REMOVE_CODE){
            mExpensesViewModel.removeExpense(data.getIntExtra(DetailsActivity.DETAILS_POSITION_KEY,-1));
        }


        return;


    }
}