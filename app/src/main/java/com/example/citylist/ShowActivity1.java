package com.example.citylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show1);
        Button mButton =findViewById(R.id.button);
        TextView mTextView =findViewById(R.id.city);
        Intent mIntent=getIntent();
        String s=mIntent.getStringExtra("cityname");
        mTextView.setText(s);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowActivity1.this, MainActivity.class);
                startActivity(intent);


            }
        });
    }
}