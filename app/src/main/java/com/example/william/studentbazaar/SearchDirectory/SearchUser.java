package com.example.william.studentbazaar.SearchDirectory;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.william.studentbazaar.R;

public class SearchUser {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);

        Button submitUser = (Button)findviewById(R.id.submitUser);
        submitUser.setOnClickListener(new View.onClickListener() ) {
            // @Override
            public void onClick( View view) {
                EditText userEditText = (EditText) findViewById( R.id.userEditText );
                TextView resultTextView = (TextView) findViewById( R.id.msgSearchUserTextView );
                String userSearched = userEditText.getText().toString() ;
            }
        }

    }
}
