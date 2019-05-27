package com.bignerdranch.roid.mrmapro1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bignerdranch.roid.mrmapro1.R;
import com.bignerdranch.roid.mrmapro1.models.ExpenseModel;
import com.bignerdranch.roid.mrmapro1.models.ExpensesViewModel;

public class DetailsActivity extends AppCompatActivity {

    public static String DETAILS_NAME_KEY = "namekey";
    public static String DETAILS_COST_KEY = "costkey";
    public static String DETAILS_DATE_KEY = "datekey";
    public static String DETAILS_CATEGORY_KEY = "categorykey";
    public static String DETAILS_POSITION_KEY = "positionkey";
    public static int REMOVE_CODE = 23;
    public static int BACK_CODE = 43;

    private Button mRemoveButton;
    private TextView mNameText;
    private TextView mCostText;
    private TextView mCategoryText;
    private TextView mDateText;
    private ExpenseModel mModel;
    private ExpensesViewModel mViewModel;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        init();
    }

    public void init(){
        Intent tempIntent = getIntent();



        mRemoveButton = findViewById(R.id.details_button_remove);
        mNameText = findViewById(R.id.details_name);
        mCostText = findViewById(R.id.details_cost);
        mCategoryText = findViewById(R.id.details_category);
        mDateText = findViewById(R.id.details_date);

        mNameText.setText(((Intent) tempIntent).getStringExtra(DETAILS_NAME_KEY));
        mCategoryText.setText(((Intent) tempIntent).getStringExtra(DETAILS_CATEGORY_KEY));
        //mDateText.setText(((Intent) tempIntent).getStringExtra(DETAILS_DATE_KEY));
        mCostText.setText(((Intent) tempIntent).getStringExtra(DETAILS_COST_KEY));

        mRemoveButton.setText("Remove");
        mRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tempIntent2 = new Intent();
                tempIntent2.putExtra(DETAILS_POSITION_KEY, getIntent().getIntExtra(DETAILS_POSITION_KEY,-1));
                setResult(REMOVE_CODE,tempIntent2);
                Log.e("KAD", tempIntent2.toString());
                finish();

            }
        });

    }


}
