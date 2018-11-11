package com.kydja.ignatius.activitiestest1;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NextActivity extends AppCompatActivity {
    int color;
    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        constraintLayout = findViewById(R.id.nextActivity);
        Intent intent = getIntent();
        color = Color.parseColor(intent.getStringExtra("color"));
        constraintLayout.setBackgroundColor(color);
    }
}
