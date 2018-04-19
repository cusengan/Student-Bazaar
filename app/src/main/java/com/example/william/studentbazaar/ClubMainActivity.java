package com.example.william.studentbazaar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClubMainActivity extends AppCompatActivity {

    private Button mGetClubs;
    private Button mFormClubs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_main);

        mGetClubs = (Button)findViewById(R.id.list_clubs_button);

        mGetClubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ClubMainActivity.this, ClubListActivity.class);
                startActivity(intent);
            }
        });

        mFormClubs = (Button)findViewById(R.id.create_club_button);

        mFormClubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ClubMainActivity.this, ClubMainActivity.class);
                startActivity(intent);
            }
        });
    }
}
