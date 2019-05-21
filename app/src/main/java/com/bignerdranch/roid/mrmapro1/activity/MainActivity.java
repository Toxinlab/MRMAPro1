package com.bignerdranch.roid.mrmapro1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.bignerdranch.roid.mrmapro1.R;
import com.bignerdranch.roid.mrmapro1.fragments.ExpenseListFragment;
import com.bignerdranch.roid.mrmapro1.models.ExpenseModel;
import com.bignerdranch.roid.mrmapro1.models.ExpensesViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ExpensesViewModel mExpensesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initModels();
        initPager();
    }

    public void initPager(){
        ViewPager mainViewPager = findViewById(R.id.activity_view_pager);
        ExpenseViewPagerAdapter expenseViewPagerAdapter = new ExpenseViewPagerAdapter(getSupportFragmentManager(),this);
        mainViewPager.setAdapter(expenseViewPagerAdapter);
        TabLayout tabLayout = findViewById(R.id.activity_tab_layout);
        tabLayout.setupWithViewPager(mainViewPager);
    }

    public void initModels(){
        mExpensesViewModel = ViewModelProviders.of(this).get(ExpensesViewModel.class);

        ArrayList<String> tempCatList = new ArrayList<>();
        tempCatList.add("State");
        tempCatList.add("Personal");
        tempCatList.add("Travel");

        mExpensesViewModel.getCategoriesList().setValue(tempCatList);

        ArrayList<ExpenseModel> tempList = new ArrayList<>();
        tempList.add(new ExpenseModel("Poresko", 2000, new Date(), "State"));
        tempList.add(new ExpenseModel("Pljeskavica", 400, new Date(), "Personal"));
        tempList.add(new ExpenseModel("Kazna", 4500, new Date(), "State"));
        tempList.add(new ExpenseModel("Hedonizam", 80000, new Date(), "Personal"));
        tempList.add(new ExpenseModel("Bus", 300, new Date(), "Travel"));

        mExpensesViewModel.getExpensesList().setValue(tempList);

    }
}
