package com.example.william.studentbazaar.SearchDirectory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.william.studentbazaar.R;

public class SearchClubs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_clubs);

        Button submitClubs = (Button)findviewById(R.id.submitClubs);
        submitClubs.setOnClickListener(new View.onClickListener() ) {
            // @Override
            public void onClick( View view) {
                EditText clubsEditText = (EditText) findViewById( R.id.clubsEditText );
                TextView resultTextView = (TextView) findViewById( R.id.msgSearchClubsTextView );
                String clubSearched = clubsEditText.getText().toString() ;
            }
            }

        }
}
