package com.example.william.studentbazaar.TradeDirectory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
//import android.view.View;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.william.studentbazaar.Global;
import com.example.william.studentbazaar.LoginActivity;
import com.example.william.studentbazaar.R;
import com.example.william.studentbazaar.User.User;

/**
 * Created by Michelle Dinh on 4/23/2018.
 */

public class CreateItemActivity extends AppCompatActivity {

    private Button mSubmitButton;
    private Button mCancelButton;
    private EditText mItemName;
    private EditText mItemDescription;
    private EditText mItemPrice;
    private String itemName;
    private String itemDescription;
    private Float itemPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade_sellitemform);
        itemName = "";
        itemDescription = "";
        mSubmitButton = findViewById(R.id.item_submit_button);
        mCancelButton = findViewById(R.id.item_cancel_button);

        mItemName = findViewById(R.id.item_name_edit_text);
        mItemName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                itemName = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mItemDescription = findViewById(R.id.item_description_edit_text);
        mItemDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                itemDescription = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

//        mItemPrice = findViewById(R.id.price_edit_text);
//        itemPrice = Float.parseFloat(mItemPrice.getText().toString());

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemName.isEmpty() || itemDescription.isEmpty()){
                    Toast.makeText(CreateItemActivity.this, "An input box is empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                Item item = new Item();
                User user = Global.currentUser;
                item.setName(itemName);
                item.setDescription(itemDescription);
                item.setOwnerId(user.getStudentId());
                item.setOnSale(true);

                ItemLab.get(CreateItemActivity.this).addItem(item);
                finish();
            }
        });

        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}
