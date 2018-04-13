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
 * Created by Yenpham on 11/9/16.
 */

public class Introduction extends AppCompatActivity {

    public Button exist;
    public Button newUser;
//    public UBSdb db;
//    SharePref sharePref;
//    public void login(){
//        exist = (Button)findViewById(R.id.existing);
//        exist.setOnClickListener( new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent gglog= new Intent(welcom_class.this, login_gg.class);
//                gglog.putExtra("IS_First_Time",false);
//                startActivity(gglog);
//            }
//
//        });
//
//    }
//    public void registration (){
//        newUser = (Button)findViewById(R.id.newUser);
//        newUser.setOnClickListener( new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent reg= new Intent(welcom_class.this, firstTimeLogin.class);
//                startActivity(reg);
//
//            }
//
//        });
//    }

    @Override
    protected void onCreate (Bundle savedInstanceState ){
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.welcome);
//        login();
//        registration ();
    }


}
