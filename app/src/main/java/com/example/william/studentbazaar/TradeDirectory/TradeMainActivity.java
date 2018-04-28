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

    private Button mSellButton;
    private Button mTradeButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade_main);

        mSellButton = findViewById(R.id.sell_button);

        mSellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(TradeMainActivity.this, SellItemFormActivity.class);
                startActivity(intent);
            }
        });

        mTradeButton1 = findViewById(R.id.trade_button);

        mTradeButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(TradeMainActivity.this, TradeItemForm.class);
                startActivity(intent);
            }
        });
    }
}
