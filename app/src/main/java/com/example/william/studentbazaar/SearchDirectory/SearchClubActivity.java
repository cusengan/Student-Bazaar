package com.example.william.studentbazaar.SearchDirectory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.william.studentbazaar.R;

public class SearchClubActivity extends AppCompatActivity {

    Button mSubmitClubs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_clubs);

        mSubmitClubs = findViewById(R.id.find_item_button);
        mSubmitClubs.setOnClickListener(new View.OnClickListener(){
             @Override
            public void onClick(View view) {
//                
            }
        });

    }
}
