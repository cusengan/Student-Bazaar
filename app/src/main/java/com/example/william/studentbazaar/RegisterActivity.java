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
import android.widget.Toast;

import com.example.william.studentbazaar.ClubDirectory.Club;
import com.example.william.studentbazaar.ClubDirectory.ClubLab;
import com.example.william.studentbazaar.ClubDirectory.ClubListActivity;
import com.example.william.studentbazaar.ClubDirectory.CreateClubActivity;
import com.example.william.studentbazaar.User.User;
import com.example.william.studentbazaar.User.UserLab;

public class RegisterActivity extends AppCompatActivity {


    private EditText mEmail;
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mStudentId;
    private EditText mPhoneNumber;
    private EditText mPassword;

    private String email;
    private String firstName;
    private String lastName;
    private String studentId;
    private String phoneNumber;
    private String password;

    private Button mSubmitButton;
    private Button mCancelButton;

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

        mPassword = findViewById(R.id.password);
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

        /////////////////// BUTTON METHODS /////////////////////////

        mSubmitButton = findViewById(R.id.submit_register);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.equals("") || firstName.equals("") || lastName.equals("") || studentId.equals("") || phoneNumber.equals("")
                        || password.equals("")) { //check error
                    Toast.makeText(RegisterActivity.this, "Invalid information" ,Toast.LENGTH_SHORT).show();
                    return;
                }

                if(studentId.length() < 10){
                    Toast.makeText(RegisterActivity.this, "Invalid student id" ,Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 8) {
                    Toast.makeText(RegisterActivity.this, "Password must be at least 8 characters" ,Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!isValidPassword(password)){
                    Toast.makeText(RegisterActivity.this, "Password must contain an uppercase letter, a lowercase letter, and a number" ,Toast.LENGTH_SHORT).show();
                    return;
                }

                if (phoneNumber.length() != 10) { //check error
                    Toast.makeText(RegisterActivity.this, "Invalid phone number" ,Toast.LENGTH_SHORT).show();
                    return;
                }


                User user = new User();
                user.setEmail(email);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setStudentId(studentId);
                user.setPhoneNumber(phoneNumber);
                user.setPassword(password);
                UserLab.get(RegisterActivity.this).addUser(user);

                Global.currentUser = user;

                Toast.makeText(RegisterActivity.this, "User created", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this, MainScreenActivity.class));
            }
        });

        mCancelButton = findViewById(R.id.cancel_register);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private boolean isValidPassword(String pass){
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;

        for(int i=0;i < pass.length();i++) {
            char c = pass.charAt(i);
            if( Character.isDigit(c)) {
                numberFlag = true;
            }
            else if (Character.isUpperCase(c)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(c)) {
                lowerCaseFlag = true;
            }
            if(numberFlag && capitalFlag && lowerCaseFlag)
                return true;
        }
        return false;
    }
}
