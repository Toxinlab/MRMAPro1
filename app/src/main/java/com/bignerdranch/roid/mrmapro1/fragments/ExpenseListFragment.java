package com.bignerdranch.roid.mrmapro1.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.bignerdranch.roid.mrmapro1.R;
import com.bignerdranch.roid.mrmapro1.activity.DetailsActivity;
import com.bignerdranch.roid.mrmapro1.dumbRecyclerViewStuff.DumbCategoryListAdapter;
import com.bignerdranch.roid.mrmapro1.dumbRecyclerViewStuff.DumbExpenseListAdapter;
import com.bignerdranch.roid.mrmapro1.models.ExpenseModel;
import com.bignerdranch.roid.mrmapro1.models.ExpensesViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ExpenseListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ExpenseListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExpenseListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static int DETAILS_REQUEST = 13;
    public static int DETAILS_RESULT = 12;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ExpensesViewModel mViewModel;

    private EditText mFilterName;
    private Spinner mCategorySpinner;
    private Button mApplyButton;
    private RecyclerView mRecyclerView;

    private OnFragmentInteractionListener mListener;

    public ExpenseListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExpenseListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExpenseListFragment newInstance(String param1, String param2) {
        ExpenseListFragment fragment = new ExpenseListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_expense_list, container, false);
        mApplyButton = view.findViewById(R.id.expense_list_apply_button);
        mCategorySpinner = view.findViewById(R.id.expense_list_category_spinner);
        mRecyclerView = view.findViewById(R.id.expense_list_recyclerview);
        mFilterName = view.findViewById(R.id.expense_list_filter_edittext);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//s

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this.getActivity()).get(ExpensesViewModel.class);

        init();

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void init(){
        ArrayAdapter<String> adapter =
                new  ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_item,new ArrayList<>());

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCategorySpinner.setAdapter(adapter);

        mViewModel.getCategoriesLiveData().observe(this, new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> strings) {
                adapter.clear();
                adapter.addAll(strings);
                adapter.notifyDataSetChanged();
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        DumbExpenseListAdapter dumbAdapter = new DumbExpenseListAdapter();
        mRecyclerView.setAdapter(dumbAdapter);

        mViewModel.getExpensesLiveData().observe(this, new Observer<ArrayList<ExpenseModel>>() {
            @Override
            public void onChanged(ArrayList<ExpenseModel> expenses) {
                dumbAdapter.setData(expenses);
            }
        });

        mFilterName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mViewModel.filterExpenses(mFilterName.getText().toString(),mCategorySpinner.getSelectedItem().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mApplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.filterCategories(mCategorySpinner.getSelectedItem().toString());
            }
        });

        dumbAdapter.setOnItemRemoveCallback(new DumbExpenseListAdapter.OnItemRemoveCallback() {
            @Override
            public void onItemRemove(int position) {
                mViewModel.removeExpense(position);
            }
        });

        dumbAdapter.setOnDetailsClickCallback(new DumbExpenseListAdapter.OnDetailsClickCallback() {
            @Override
            public void onDetailsClick(int position) {
                ExpenseModel tempModel = mViewModel.getExpense(position);
                Intent tempIntent = new Intent(getActivity(), DetailsActivity.class);

                tempIntent.putExtra(DetailsActivity.DETAILS_NAME_KEY,tempModel.getName());
                tempIntent.putExtra(DetailsActivity.DETAILS_COST_KEY,tempModel.getCost());
                tempIntent.putExtra(DetailsActivity.DETAILS_CATEGORY_KEY,tempModel.getCategory());
                tempIntent.putExtra(DetailsActivity.DETAILS_DATE_KEY,tempModel.getDate());
                tempIntent.putExtra(DetailsActivity.DETAILS_POSITION_KEY,position);

                startActivityForResult(tempIntent,DETAILS_REQUEST);

            }
        });







    }
}
