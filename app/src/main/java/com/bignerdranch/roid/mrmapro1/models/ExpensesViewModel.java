package com.bignerdranch.roid.mrmapro1.models;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ExpensesViewModel extends ViewModel {

    private MutableLiveData<ArrayList<ExpenseModel>> mExpensesList;
    private MutableLiveData<ArrayList<String>> mCategoriesList;

    public ExpensesViewModel() {
        mExpensesList = new MutableLiveData<>();
        mCategoriesList = new MutableLiveData<>();
    }

    public MutableLiveData<ArrayList<ExpenseModel>> getExpensesList() {
        return mExpensesList;
    }

    public void setExpensesList(MutableLiveData<ArrayList<ExpenseModel>> expensesList) {
        mExpensesList = expensesList;
    }

    public MutableLiveData<ArrayList<String>> getCategoriesList() {
        return mCategoriesList;
    }

    public void setCategoriesList(MutableLiveData<ArrayList<String>> categoriesList) {
        mCategoriesList = categoriesList;
    }
}
