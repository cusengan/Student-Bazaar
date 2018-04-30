package com.example.william.studentbazaar.EventDirectory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.william.studentbazaar.ClubDirectory.ClubListActivity;
import com.example.william.studentbazaar.ClubDirectory.ClubMainActivity;
import com.example.william.studentbazaar.ClubDirectory.CreateClubActivity;
import com.example.william.studentbazaar.R;

public class EventMainActivity extends AppCompatActivity {

    private Button mGetEvents;
    private Button mCreateEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_main);

        mGetEvents = findViewById(R.id.list_event_button);

        mGetEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(EventMainActivity.this, ClubListActivity.class);
                startActivity(intent);
            }
        });

        mCreateEvents = findViewById(R.id.create_event_button);

        mCreateEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(EventMainActivity.this, CreateEventActivity.class);
                startActivity(intent);
            }
        });
    }
}
