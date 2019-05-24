package com.bignerdranch.roid.mrmapro1.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

public class ExpensesViewModel extends ViewModel {

    private MutableLiveData<ArrayList<ExpenseModel>> mExpensesList;
    private MutableLiveData<ArrayList<String>> mCategoriesList;

    public ExpensesViewModel() {
        mExpensesList = new MutableLiveData<>();
        mCategoriesList = new MutableLiveData<>();
        initModels();
    }

    public MutableLiveData<ArrayList<ExpenseModel>> getExpensesList() {
        return mExpensesList;
    }


    public MutableLiveData<ArrayList<String>> getCategoriesList() {
        return mCategoriesList;
    }

    public void initModels(){


        ArrayList<String> tempCatList = new ArrayList<>();
        tempCatList.add("State");
        tempCatList.add("Personal");
        tempCatList.add("Travel");

        mCategoriesList.setValue(tempCatList);

        //Log.e("OCAJAN POKUSAJ", "MAIN");

        ArrayList<ExpenseModel> tempList = new ArrayList<>();
        tempList.add(new ExpenseModel("Poresko", 2000, new Date(), "State"));
        tempList.add(new ExpenseModel("Pljeskavica", 400, new Date(), "Personal"));
        tempList.add(new ExpenseModel("Kazna", 4500, new Date(), "State"));
        tempList.add(new ExpenseModel("Hedonizam", 80000, new Date(), "Personal"));
        tempList.add(new ExpenseModel("Bus", 300, new Date(), "Travel"));

        mExpensesList.setValue(tempList);

    }


}
