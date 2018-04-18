package com.example.william.studentbazaar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by William on 4/13/18.
 */

public class IntroductionActivity extends AppCompatActivity {

    public Button login;
    public Button register;
//    public UBSdb db;
//    SharePref sharePref;
    @Override
    protected void onCreate (Bundle savedInstanceState ){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.introduction);
        login = (Button)findViewById(R.id.login_button);
        login.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(IntroductionActivity.this, MainScreenActivity.class);
//                intent.putExtra("IS_First_Time",false);
                startActivity(intent);
            }

        });

        register = (Button)findViewById(R.id.register_button);
        register.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(IntroductionActivity.this, MainScreenActivity.class);
                startActivity(intent);

            }

        });
    }


}
