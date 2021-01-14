package com.example.nazarsanj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.models.CreateUserResponseModel;
import com.example.models.LoginResponseModel;
import com.example.web.WebConsumer;
import com.example.web.WebService;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button loginBtn, submitBtn, signupBtn;
    private EditText emailTxt, passwordTxt, nameTxt;
    private TextView nameTextView;
    private boolean isLogin = true;
    private String userId;
    private RadioGroup radioGroup;

    public enum userType {
        STUDENT,
        TEACHER,
        EDUCATION_EMPLOYEE

    }

    private userType signUpUser = userType.STUDENT;
    //    this is not right way to pass variables but here i do for sake of time
    public static userType subSystemUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loginBtn = findViewById(R.id.button);
        submitBtn = findViewById(R.id.button3);
        signupBtn = findViewById(R.id.button2);

        radioGroup = findViewById(R.id.radio_btn_group);
        nameTextView = findViewById(R.id.textView3);

        emailTxt = findViewById(R.id.editTextTextPersonName);
        passwordTxt = findViewById(R.id.editTextTextPersonName2);
        nameTxt = findViewById(R.id.editTextTextPersonName3);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isLogin = true;
                nameTxt.setVisibility(View.GONE);
                nameTextView.setVisibility(View.GONE);
                radioGroup.setVisibility(View.GONE);

            }
        });
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isLogin = false;
                nameTxt.setVisibility(View.VISIBLE);
                nameTextView.setVisibility(View.VISIBLE);
                radioGroup.setVisibility(View.VISIBLE);
            }
        });


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail = String.valueOf(emailTxt.getText());
                String userPass = String.valueOf(passwordTxt.getText());
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("email", userEmail);
                map.put("password", userPass);
                if (!isLogin) {
                    String userName = String.valueOf(nameTxt.getText());
                    map.put("name", userName);
                    switch (signUpUser) {
                        case STUDENT:
                            map.put("is_student", "true");
                            map.put("is_teacher", "false");
                            map.put("is_education_employee", "false");
                            break;
                        case TEACHER:
                            map.put("is_student", "false");
                            map.put("is_teacher", "true");
                            map.put("is_education_employee", "false");
                            break;
                        case EDUCATION_EMPLOYEE:
                            map.put("is_student", "false");
                            map.put("is_teacher", "false");
                            map.put("is_education_employee", "true");
                            break;
                    }
                }

                if (!isLogin) {

                    WebService.getInstance().postSignUpData(map, getApplicationContext(), new WebConsumer<CreateUserResponseModel>() {
                        @Override
                        public void success(CreateUserResponseModel createUserResponseModel) {
                            userId = String.valueOf(createUserResponseModel.getId());

                            if (createUserResponseModel.isIs_student()) {
                                subSystemUser = userType.STUDENT;
                            } else if (createUserResponseModel.isTeacher()) {
                                subSystemUser = userType.TEACHER;
                            } else {
                                subSystemUser = userType.EDUCATION_EMPLOYEE;
                            }


                            startActivity(new Intent(MainActivity.this, SubSystemActivity.class).putExtra("neededUserId", userId));
                            finish();
                        }

                        @Override
                        public void error(VolleyError error) {
                            Toast.makeText(getApplicationContext(), "create user failed", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    WebService.getInstance().postLoginData(map, getApplicationContext(), new WebConsumer<LoginResponseModel>() {
                        @Override
                        public void success(LoginResponseModel loginResponseModel) {
                            userId = String.valueOf(loginResponseModel.getId());

                            if (loginResponseModel.isIs_student()) {
                                subSystemUser = userType.STUDENT;
                            } else if (loginResponseModel.isTeacher()) {
                                subSystemUser = userType.TEACHER;
                            } else {
                                subSystemUser = userType.EDUCATION_EMPLOYEE;
                            }
                            startActivity(new Intent(MainActivity.this, SubSystemActivity.class).putExtra("neededUserId", userId));
                            finish();
                        }

                        @Override
                        public void error(VolleyError error) {
                            Toast.makeText(getApplicationContext(), "login user failed", Toast.LENGTH_SHORT).show();
                        }
                    });
                }


            }
        });


    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_student:
                if (checked)
                    signUpUser = userType.STUDENT;
                // Pirates are the best
                break;
            case R.id.radio_teacher:
                if (checked)
                    signUpUser = userType.TEACHER;
                break;
            case R.id.radio_employee:
                if (checked)
                    signUpUser = userType.EDUCATION_EMPLOYEE;
                break;
        }
    }
}