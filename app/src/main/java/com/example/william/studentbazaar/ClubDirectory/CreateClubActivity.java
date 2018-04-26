package com.example.william.studentbazaar.ClubDirectory;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.william.studentbazaar.R;

public class CreateClubActivity extends AppCompatActivity {

    private Button mCreateClubButton;
    private EditText mClubTitle;
    private EditText mClubDescription;
    private String clubTitle;
    private String clubDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_club);
        clubTitle = "";
        clubDescription = "";
        mCreateClubButton = findViewById(R.id.submit_club_button);

        mClubTitle = findViewById(R.id.create_club_edit_text);
        mClubTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                clubTitle = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mClubDescription = findViewById(R.id.club_description_edit_text);
        mClubDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                clubDescription = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mCreateClubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mClubTitle.getText().toString().equals("")) {
                    Toast.makeText(CreateClubActivity.this, "Please enter a valid club name" ,Toast.LENGTH_SHORT).show();
                    return;
                }

                Club club = new Club();
                club.setName(clubTitle);
                club.setDescription(clubDescription);
                ClubLab.get(CreateClubActivity.this).addClub(club);

                Toast.makeText(CreateClubActivity.this, "Club created", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CreateClubActivity.this, ClubListActivity.class));
            }
        });
    }
}
