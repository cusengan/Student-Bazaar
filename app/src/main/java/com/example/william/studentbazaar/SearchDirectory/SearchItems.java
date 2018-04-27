package com.example.william.studentbazaar.SearchDirectory;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.william.studentbazaar.R;

public class SearchItems {

    Button submitItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_items);

        submitItems = (Button)findviewById(R.id.submitItems);
        submitItems.setOnClickListener(new View.onClickListener() ) {
            // @Override
            public void onClick( View view) {
                EditText itemsEditText = (EditText) findViewById( R.id.itemsEditText );
                TextView resultTextView = (TextView) findViewById( R.id.msgSearchItemsTextView );
                String itemSearched = itemsEditText.getText().toString() ;
            }
        }

    }
}
