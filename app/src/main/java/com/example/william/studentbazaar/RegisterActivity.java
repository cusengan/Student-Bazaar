package com.example.william.studentbazaar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private Button mSubmitButton;
    private Button mCancelButton;

    private EditText mEmail;
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mStudentId;
    private EditText mPhoneNumber;

    private String email;
    private String firstName;
    private String lastName;
    private String studentId;
    private String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        /////////////////// EDIT TEXT LISTENERS /////////////////////////////////

        mEmail = findViewById(R.id.email);
        mEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                email = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mFirstName = findViewById(R.id.firstName);
        mFirstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                firstName = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mLastName = findViewById(R.id.lastName);
        mLastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                lastName = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mStudentId = findViewById(R.id.studentId);
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

        mPhoneNumber = findViewById(R.id.phoneNumber);
        mPhoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                phoneNumber = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        /////////////////// BUTTON METHODS /////////////////////////

        mSubmitButton = findViewById(R.id.submit_register);
        mCancelButton = findViewById(R.id.cancel_register);

    }
}
