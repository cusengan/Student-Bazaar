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
//                if (mClubTitle.getText().toString().equals("")) { //check error
//                    Toast.makeText(CreateClubActivity.this, "Please enter a valid club name" ,Toast.LENGTH_SHORT).show();
//                    return;
//                }

                User user = new User();
                user.setEmail(email);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setStudentId(studentId);
                user.setPhoneNumber(phoneNumber);
                user.setPassword(password);
                UserLab.get(RegisterActivity.this).addUser(user);
//                User queryUser = UserLab.get(RegisterActivity.this).getUser(studentId, password);
//                if(queryUser == null){
//                    Log.d("testing" ,"null user");
//                }else{
//                    Log.d("testing", "works");
//                }
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
}
