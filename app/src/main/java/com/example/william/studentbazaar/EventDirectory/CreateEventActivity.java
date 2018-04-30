package com.example.william.studentbazaar.EventDirectory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.william.studentbazaar.R;

public class CreateEventActivity extends AppCompatActivity {

    private Button mSubmitButton;
    private Button mCancelButton;
    private EditText mEventName;
    private EditText mEventDescription;
    private String eventName;
    private String eventDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
    }
}
