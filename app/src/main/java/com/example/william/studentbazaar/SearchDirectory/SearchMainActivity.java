package com.example.william.studentbazaar.SearchDirectory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.william.studentbazaar.R;

public class SearchMainActivity extends AppCompatActivity {

    private Button mSearchUserButton;
    private Button mSearchClubsButton;
    private Button mSearchItemsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_main);


        mSearchUserButton = findViewById(R.id.search_user_button);
        mSearchUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchMainActivity.this, SearchUserActivity.class);
                startActivity(intent);
            }
        });



        mSearchClubsButton = findViewById(R.id.search_clubs_button);
        mSearchClubsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SearchMainActivity.this, SearchClubActivity.class);
                startActivity(intent);
            }
        });





        mSearchItemsButton = findViewById(R.id.search_items_button);
        mSearchItemsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SearchMainActivity.this, SearchItemActivity.class);
                startActivity(intent);
            }
        });


    }
}
