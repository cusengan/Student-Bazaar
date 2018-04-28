package com.example.william.studentbazaar.TradeDirectory;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.william.studentbazaar.R;

/**
 * Created by Michelle Dinh on 4/23/2018.
 */

public class TradeMainActivity extends AppCompatActivity {

    private Button mRegisterButton;
    private Button mListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade_main);

        mRegisterButton = findViewById(R.id.item_register_button);
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TradeMainActivity.this, CreateItemActivity.class);
                startActivity(intent);
            }
        });

        mListButton = findViewById(R.id.item_trade_button);
        mListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TradeMainActivity.this, ItemListActivity.class);
                startActivity(intent);
            }
        });


    }
}
