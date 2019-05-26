package com.bignerdranch.roid.mrmapro1.dumbRecyclerViewStuff;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bignerdranch.roid.mrmapro1.R;
import com.bignerdranch.roid.mrmapro1.models.ExpenseModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class DumbExpenseListAdapter extends RecyclerView.Adapter<DumbExpenseListAdapter.DumbExpenseViewHolder> {

    private ArrayList<ExpenseModel> mExpenseList;
    private OnDetailsClickCallback mOnDetailsClickCallback;
    private OnItemRemoveCallback mOnItemRemoveCallback;

    public DumbExpenseListAdapter() {
        mExpenseList = new ArrayList<>();
    }

    public void setOnDetailsClickCallback(OnDetailsClickCallback onDetailsClickCallback) {
        mOnDetailsClickCallback = onDetailsClickCallback;
    }

    public void setOnItemRemoveCallback(OnItemRemoveCallback onItemRemoveCallback) {
        mOnItemRemoveCallback = onItemRemoveCallback;
    }

    @NonNull
    @Override
    public DumbExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View tempView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_expense_layout,parent,false);

        DumbExpenseViewHolder tempDumb = new DumbExpenseViewHolder(tempView);


        return tempDumb;
    }

    @Override
    public void onBindViewHolder(@NonNull DumbExpenseViewHolder holder, int position) {
        holder.mNameText.setText(mExpenseList.get(position).getName());
        holder.mCostText.setText(mExpenseList.get(position).getCost());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");


        holder.mDataText.setText(formatter.format(mExpenseList.get(position).getDate()).toString());
        holder.mCategoryText.setText(mExpenseList.get(position).getCategory());
    }

    @Override
    public int getItemCount() {
        return mExpenseList.size();
    }

    public void setData(ArrayList<ExpenseModel> data){
        DumbExpenseListDiffUtil callback = new DumbExpenseListDiffUtil(mExpenseList,data);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(callback);
        mExpenseList.clear();
        mExpenseList.addAll(data);
        result.dispatchUpdatesTo(this);
    }

    public class DumbExpenseViewHolder extends RecyclerView.ViewHolder {
        Button mRemoveButton;
        Button mDetailButton;
        TextView mNameText;
        TextView mCategoryText;
        TextView mDataText;
        TextView mCostText;


        public DumbExpenseViewHolder(@NonNull View itemView) {
            super(itemView);
            mRemoveButton = itemView.findViewById(R.id.single_button_remove);
            mDetailButton = itemView.findViewById(R.id.single_button_details);
            mNameText = itemView.findViewById(R.id.single_name);
            mCategoryText = itemView.findViewById(R.id.single_category);
            mDataText = itemView.findViewById(R.id.single_date);
            mCostText = itemView.findViewById(R.id.single_cost);

            mRemoveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        if(mOnItemRemoveCallback != null){
                            mOnItemRemoveCallback.onItemRemove(position);
                        }
                    }
                }
            });

        }
    }

    public interface OnItemRemoveCallback{
        void onItemRemove(int position);
    }

    public interface OnDetailsClickCallback{
        void onDetailsClick();
    }

}
