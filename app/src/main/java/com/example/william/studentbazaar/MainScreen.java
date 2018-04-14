package com.example.william.studentbazaar;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;


/**
 * Created by William Truong on 4/13/18.
 */

public class MainScreen extends AppCompatActivity  {

    private Button mLogin;
    private Button mRegister;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_screen);
        Bundle intent = getIntent().getExtras();



    }

}

