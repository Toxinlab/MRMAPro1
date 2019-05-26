package com.bignerdranch.roid.mrmapro1.dumbRecyclerViewStuff;

import android.util.Log;

import com.bignerdranch.roid.mrmapro1.models.ExpenseModel;

import java.util.ArrayList;

import androidx.recyclerview.widget.DiffUtil;

public class DumbExpenseListDiffUtil extends DiffUtil.Callback {

    private ArrayList<ExpenseModel> mOldList;
    private ArrayList<ExpenseModel> mNewList;

    public DumbExpenseListDiffUtil(ArrayList<ExpenseModel> oldList, ArrayList<ExpenseModel> newList) {
        mOldList = oldList;
        mNewList = newList;
    }

    @Override
    public int getOldListSize() {
        return mOldList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldList.get(oldItemPosition).equals(mNewList.get(newItemPosition));
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldList.get(oldItemPosition).getName().equals(mNewList.get(newItemPosition).getName());
    }
}
