package com.example.william.studentbazaar;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/**
 * Created by William Truong on 4/13/18.
 */

public class MainScreen extends AppCompatActivity  {

    Button login;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_screen);
        Bundle intent = getIntent().getExtras();

        setContentView(R.layout.welcome);


    }

}

