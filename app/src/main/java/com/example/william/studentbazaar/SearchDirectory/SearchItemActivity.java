package com.example.william.studentbazaar.SearchDirectory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.william.studentbazaar.R;
import com.example.william.studentbazaar.TradeDirectory.SearchItemListActivity;

public class SearchItemActivity extends AppCompatActivity {

    private EditText mItemName;
    private Button mSubmitButton;

    private String itemName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_item);
        itemName = "";
        mItemName = findViewById(R.id.search_item_name_edit_text);
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

        mSubmitButton = findViewById(R.id.search_item_submit_button);

        mSubmitButton.setOnClickListener(new View.OnClickListener(){
            // @Override
            public void onClick( View view) {
                startActivity(SearchItemListActivity.newIntent(SearchItemActivity.this, itemName));
            }
        });
    }
}
