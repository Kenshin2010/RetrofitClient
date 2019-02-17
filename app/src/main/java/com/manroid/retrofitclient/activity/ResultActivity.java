package com.manroid.retrofitclient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.manroid.retrofitclient.R;


public class ResultActivity extends AppCompatActivity {


    private TextView mTxtResponse;
    private Intent mIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_response);
        initViews();
    }

    private void initViews() {
        mTxtResponse=(TextView)findViewById(R.id.txt_response);
        mIntent=getIntent();
        if(mIntent.getStringExtra("response")!=null){
            mTxtResponse.setText(mIntent.getStringExtra("response"));
        }

    }
}
