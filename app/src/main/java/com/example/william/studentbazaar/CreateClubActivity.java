package com.example.william.studentbazaar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateClubActivity extends AppCompatActivity {

        Button mCreateClubButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_club);
        mCreateClubButton = (Button) findViewById(R.id.create_club_button);
        final EditText createClubInput = (EditText)findViewById(R.id.create_club_edit_text);

        mCreateClubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (createClubInput.getText().toString().equals(""))
                    Toast.makeText(CreateClubActivity.this, "Please enter a valid club name" ,Toast.LENGTH_SHORT).show();

                    // handle database if JoinAClubActivity already exist


                else {
                    Toast.makeText(CreateClubActivity.this, createClubInput.getText().toString(), Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(CreateClubActivity.this, joinedClubActivity.class));
                }
            }
        });
    }
}
