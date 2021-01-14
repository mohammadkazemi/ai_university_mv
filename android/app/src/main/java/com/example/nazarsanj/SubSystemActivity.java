package com.example.nazarsanj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.nazarsanj.MainActivity.subSystemUser;

public class SubSystemActivity extends AppCompatActivity {

    private Button forStudent;
    private Button forTeacher, forEmployee;
    private String userId;

//    don't try this at home
    public static String neededUserIdForApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_system);


        forStudent = findViewById(R.id.button4);
        forTeacher = findViewById(R.id.button5);
        forEmployee = findViewById(R.id.button6);

//        show right btn to user
        switch (subSystemUser){
            case STUDENT:
                forStudent.setVisibility(View.VISIBLE);
                forTeacher.setVisibility(View.GONE);
                forEmployee.setVisibility(View.GONE);
                break;
            case TEACHER:
                forStudent.setVisibility(View.GONE);
                forTeacher.setVisibility(View.VISIBLE);
                forEmployee.setVisibility(View.GONE);
                break;
            case EDUCATION_EMPLOYEE:
                forStudent.setVisibility(View.GONE);
                forTeacher.setVisibility(View.GONE);
                forEmployee.setVisibility(View.VISIBLE);
                break;
        }


        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                userId = null;
            } else {
                userId = extras.getString("neededUserId");
                neededUserIdForApi = userId;
            }
        } else {
            userId = (String) savedInstanceState.getSerializable("neededUserId");
        }


        forStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SubSystemActivity.this, VotingActivity.class).putExtra("neededUserId",userId));
            }
        });

        forTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SubSystemActivity.this, TeacherActivity.class).putExtra("neededUserId",userId));
            }
        });

        forEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SubSystemActivity.this, EmployeeActivity.class).putExtra("neededUserId",userId));
            }
        });

    }
}