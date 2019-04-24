package com.seffu.morningprojectfivetriala;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton aButton,bButton,cButton,dButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aButton = findViewById(R.id.img1);
        aButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vita = new Intent(MainActivity.this,VitaminaActivity.class);
                startActivity(vita);
            }
        });
        bButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vitb = new Intent(MainActivity.this,VitaminbActivity.class);
                startActivity(vitb);
            }
        });
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vitc = new Intent(MainActivity.this,VitamincActivity.class);
                startActivity(vitc);
            }
        });
        dButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vitd = new Intent(MainActivity.this,VitamindActivity.class);
                startActivity(vitd);
            }
        });

    }
}
