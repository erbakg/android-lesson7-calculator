package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;

public class Second_screen extends AppCompatActivity {

    private TextView resultTextView;
    private MaterialButton heartBtn;

    private AppCompatButton blueBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.second_screen);
        resultTextView = findViewById(R.id.result_text_view);
        heartBtn = findViewById(R.id.heart_btn);
        blueBtn = findViewById(R.id.blue_btn);
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String str = intent.getStringExtra("result");
        resultTextView.setText(str);

        heartBtn.setOnClickListener(view -> {
            heartBtn.setBackgroundColor(getResources().getColor(R.color.white));
            heartBtn.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_blue_heart));
            heartBtn.setIconTintResource(R.color.blue);
        });

        blueBtn.setOnClickListener(view-> {
            finishAffinity();
        });
    }
}
