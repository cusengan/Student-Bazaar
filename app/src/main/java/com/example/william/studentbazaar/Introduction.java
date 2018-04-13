package com.example.william.studentbazaar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.william.studentbazaar.R;

/**
 * Created by William on 4/13/18.
 */

public class Introduction extends AppCompatActivity {

    public Button login;
    public Button register;
//    public UBSdb db;
//    SharePref sharePref;
    @Override
    protected void onCreate (Bundle savedInstanceState ){
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.welcome);
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Introduction.this, MainScreen.class);
//                intent.putExtra("IS_First_Time",false);
                startActivity(intent);
            }

        });

        register = (Button)findViewById(R.id.register);
        register.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Introduction.this, MainScreen.class);
                startActivity(intent);

            }

        });
    }


}
