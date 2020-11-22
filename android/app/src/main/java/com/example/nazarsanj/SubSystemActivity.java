package com.example.nazarsanj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubSystemActivity extends AppCompatActivity {

    private Button subSystemBtn;
    private String userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_system);

        subSystemBtn = findViewById(R.id.button4);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                userId = null;
            } else {
                userId = extras.getString("neededUserId");
            }
        } else {
            userId = (String) savedInstanceState.getSerializable("neededUserId");
        }



        subSystemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SubSystemActivity.this, VotingActivity.class).putExtra("neededUserId",userId));
            }
        });

    }
}