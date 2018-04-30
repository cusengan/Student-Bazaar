package com.example.william.studentbazaar.EventDirectory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.william.studentbazaar.ClubDirectory.CreateClubActivity;
import com.example.william.studentbazaar.Global;
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

        mEventName = findViewById(R.id.create_event_edit_text);
        mEventName.setGravity(Gravity.CENTER);
        mEventName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                eventName = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mEventDescription = findViewById(R.id.event_description_edit_text);
        mEventDescription.setGravity(Gravity.CENTER);
        mEventDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                eventDescription = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mSubmitButton = findViewById(R.id.submit_event_button);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Event event = new Event();
                event.setName(eventName);
                event.setDescription(eventDescription);
                event.setDisplay(true);
                event.setOwnerId(Global.currentUser.getStudentId());
                EventLab.get(CreateEventActivity.this).addEvent(event);
                Toast.makeText(CreateEventActivity.this, "Event created", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }
}
