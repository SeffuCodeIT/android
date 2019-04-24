package com.seffu.morningsharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Button mBtnRed,mBtnYellow,mBtnGreen;
    Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnGreen = findViewById(R.id.btngreen);
        mBtnRed = findViewById(R.id.btnred);
        mBtnYellow = findViewById(R.id.btnyellow);
        mToolbar = findViewById(R.id.toolbar4);

        mBtnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mBtnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mBtnYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private void storeColor(int){
        SharedPreferences sharedPreferences = getSharedPreferences("Toolbarcolor",MODE_PRIVATE);

    }
}
