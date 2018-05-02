package com.example.william.studentbazaar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.william.studentbazaar.User.User;
import com.example.william.studentbazaar.User.UserLab;

public class LoginActivity extends AppCompatActivity {

    private EditText mStudentId;
    private EditText mPassword;

    private Button mSubmitButton;
    private Button mCancelButton;

    private String studentId;
    private String password;
    private TextView mAttemptsTextView;
    private int attemptsLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        attemptsLeft = 3;

        mStudentId = findViewById(R.id.studentId_login);
        mStudentId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                studentId = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mPassword = findViewById(R.id.password_login);
        mPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                password = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mSubmitButton = findViewById(R.id.submit_login);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStudentId.getText().toString().equals("") || mPassword.getText().toString().equals("")) { //check error
                    Toast.makeText(LoginActivity.this, "Please enter a valid ID and password" ,Toast.LENGTH_SHORT).show();
                    lowerAttempts();
                    return;
                }

                User user = UserLab.get(LoginActivity.this).getUser(studentId, password);
                if(user != null){
                    Global.currentUser = user;
                    Toast.makeText(LoginActivity.this, "Signed in", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainScreenActivity.class));
                }else{
                    Toast.makeText(LoginActivity.this, "Invalid ID/Password combination", Toast.LENGTH_SHORT).show();
                    lowerAttempts();
                }

            }
        });

        mCancelButton = findViewById(R.id.cancel_login);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mAttemptsTextView = findViewById(R.id.attempts_text_view);

        mAttemptsTextView.setText("Attempts left: " + attemptsLeft);

    }

    private void lowerAttempts(){
        if(attemptsLeft == 0){
            mSubmitButton.setEnabled(false);
            return;
        }
        mAttemptsTextView.setText("Attempts left: " + --attemptsLeft);


    }
}
