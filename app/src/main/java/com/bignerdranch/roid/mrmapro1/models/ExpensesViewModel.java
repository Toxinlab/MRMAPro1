package com.bignerdranch.roid.mrmapro1.models;

import java.util.ArrayList;
import java.util.Date;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ExpensesViewModel extends ViewModel {

    private MutableLiveData<ArrayList<ExpenseModel>> mExpensesLiveData;
    private MutableLiveData<ArrayList<String>> mCategoriesLiveData;
    private ArrayList<ExpenseModel> mExpensesList;
    private ArrayList<String> mCategoriesList;

    public ExpensesViewModel() {
        mExpensesLiveData = new MutableLiveData<>();
        mCategoriesLiveData = new MutableLiveData<>();
        mExpensesList = new ArrayList<>();
        mCategoriesList = new ArrayList<>();
        initModels();
    }

    public MutableLiveData<ArrayList<ExpenseModel>> getExpensesLiveData() {
        return mExpensesLiveData;
    }


    public MutableLiveData<ArrayList<String>> getCategoriesLiveData() {
        return mCategoriesLiveData;
    }

    public void addCategory(String category){
        mCategoriesList.add(category);
        mCategoriesLiveData.setValue(mCategoriesList);
    }

    public void initModels(){
        mCategoriesList.add("State");
        mCategoriesList.add("Personal");
        mCategoriesList.add("Travel");
        mCategoriesLiveData.setValue(mCategoriesList);

        //Log.e("OCAJAN POKUSAJ", "MAIN");


        mExpensesList.add(new ExpenseModel("Poresko", 2000, new Date(), "State"));
        mExpensesList.add(new ExpenseModel("Pljeskavica", 400, new Date(), "Personal"));
        mExpensesList.add(new ExpenseModel("Kazna", 4500, new Date(), "State"));
        mExpensesList.add(new ExpenseModel("Hedonizam", 80000, new Date(), "Personal"));
        mExpensesList.add(new ExpenseModel("Bus", 300, new Date(), "Travel"));
        mExpensesLiveData.setValue(mExpensesList);

    }


}
