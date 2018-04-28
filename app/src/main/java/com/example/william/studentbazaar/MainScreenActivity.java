package com.example.william.studentbazaar;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.william.studentbazaar.ClubDirectory.ClubMainActivity;
import com.example.william.studentbazaar.SearchDirectory.SearchMainActivity;
import com.example.william.studentbazaar.TradeDirectory.TradeMainActivity;

/**
 * Created by William Truong on 4/13/18.
 */

public class MainScreenActivity extends AppCompatActivity  {

//    private TextView UserTextView;
    private Button mFormClub;
    private Button mSearchItemsButton;
    private Button mSearchItems;
    private Button mBuySellTrade;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_screen);
        Bundle intent = getIntent().getExtras();

        //testing 
//        UserTextView = findViewById(R.id.displayUserInfo);
//        UserTextView.setText(Global.currentUser.getPhoneNumber());
        mFormClub = findViewById(R.id.form_club_button);

        mFormClub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreenActivity.this, ClubMainActivity.class);
//                intent.putExtra("IS_First_Time",false);
                startActivity(intent);
            }
        });

        mSearchItemsButton = findViewById(R.id.search);

        mSearchItemsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreenActivity.this, SearchMainActivity.class);
                startActivity(intent);
            }
        });

        mBuySellTrade = findViewById(R.id.item_button);

        mBuySellTrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainScreenActivity.this, TradeMainActivity.class);
                startActivity(intent);
            }
        });

    }

}

