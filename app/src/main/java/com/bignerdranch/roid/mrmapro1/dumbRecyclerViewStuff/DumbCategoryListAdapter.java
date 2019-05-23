package com.bignerdranch.roid.mrmapro1.dumbRecyclerViewStuff;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bignerdranch.roid.mrmapro1.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DumbCategoryListAdapter extends RecyclerView.Adapter<DumbCategoryListAdapter.DumbCategoryViewHolder> {

    ArrayList<String> mCategorySet;

    public DumbCategoryListAdapter(ArrayList<String> mCategorySet) {
        this.mCategorySet = mCategorySet;
    }


    @NonNull
    @Override
    public DumbCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView tempView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.textview_category_single,parent,false);

        DumbCategoryViewHolder tempDumb = new DumbCategoryViewHolder(tempView);
        return tempDumb;
    }

    @Override
    public void onBindViewHolder(@NonNull DumbCategoryViewHolder holder, int position) {
        holder.viewTextview.setText(mCategorySet.get(position));

    }

    @Override
    public int getItemCount() {
        return mCategorySet.size();
    }

    public static class DumbCategoryViewHolder extends RecyclerView.ViewHolder{
        public TextView viewTextview;

        public DumbCategoryViewHolder(TextView viewTextview) {
            super(viewTextview);
            this.viewTextview = viewTextview;
        }
    }
}
