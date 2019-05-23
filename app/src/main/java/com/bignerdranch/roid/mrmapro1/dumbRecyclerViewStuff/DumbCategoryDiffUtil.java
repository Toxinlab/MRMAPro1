package com.bignerdranch.roid.mrmapro1.dumbRecyclerViewStuff;

import android.util.Log;

import java.util.ArrayList;

import androidx.recyclerview.widget.DiffUtil;

public class DumbCategoryDiffUtil extends DiffUtil.Callback {

    private ArrayList<String> mOldList;
    private ArrayList<String> mNewList;

    public DumbCategoryDiffUtil(ArrayList<String> oldList, ArrayList<String> newList) {
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
        Log.e("WTF", mOldList.get(oldItemPosition));
        return mOldList.get(oldItemPosition).equals(mNewList.get(newItemPosition));
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldList.get(oldItemPosition).equals(mNewList.get(newItemPosition));
    }
}
