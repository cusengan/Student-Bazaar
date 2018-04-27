package com.example.william.studentbazaar.SearchDirectory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.william.studentbazaar.R;

public class SearchItemActivity extends AppCompatActivity {

    Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_item);

//        mSubmitButton = findViewById(R.id.submitItems);

        mSubmitButton.setOnClickListener(new View.OnClickListener(){
            // @Override
            public void onClick( View view) {

            }
        });
    }
}
