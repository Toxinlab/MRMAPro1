package com.bignerdranch.roid.mrmapro1.activity;

import android.content.Context;

import com.bignerdranch.roid.mrmapro1.fragments.AddFragment;
import com.bignerdranch.roid.mrmapro1.fragments.CategoryFragment;
import com.bignerdranch.roid.mrmapro1.fragments.ExpenseListFragment;
import com.bignerdranch.roid.mrmapro1.fragments.PieFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ExpenseViewPagerAdapter extends FragmentPagerAdapter {

    private static int FRAGMENT_COUNT = 4;
    private static int FRAGMENT_ADD = 0;
    private static int FRAGMENT_LIST = 1;
    private static int FRAGMENT_PIE = 2;
    private static int FRAGMENT_CATEGORY = 3;

    private List<String> mTitles;

    public ExpenseViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        initTitles(context);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return AddFragment.newInstance(null,null);
            case 1: return ExpenseListFragment.newInstance(null,null);
            case 2: return PieFragment.newInstance(null,null);
            case 3: return CategoryFragment.newInstance(null, null);
        }
        return null;
    }

    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }

    public String getPageTitle(int position){
        return mTitles.get(position);
    }

    public void initTitles(Context context){
        mTitles = new ArrayList<>();
        mTitles.add("Add expense");
        mTitles.add("List expenses");
        mTitles.add("Expense summary");
        mTitles.add("Add category");


    }
}
