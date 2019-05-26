package com.bignerdranch.roid.mrmapro1.models;

import java.util.Date;

public class ExpenseModel {

    private String mName;
    private String mCost;
    private Date mDate;
    private String mCategory;

    public ExpenseModel(String name, String cost, Date date, String category) {
        mName = name;
        mCost = cost;
        mDate = date;
        mCategory = category;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getCost() {
        return mCost;
    }

    public void setCost(String cost) {
        mCost = cost;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        mCategory = category;
    }
}
