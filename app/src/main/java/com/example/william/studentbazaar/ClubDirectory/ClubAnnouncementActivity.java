package com.example.william.studentbazaar.ClubDirectory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.william.studentbazaar.R;
import com.example.william.studentbazaar.User.UserLab;

import java.util.List;
import java.util.UUID;

public class ClubAnnouncementActivity extends AppCompatActivity {

    private EditText mAnnouncement;
    private Button mCancelButton;
    private Button mSubmitButton;
    private String announcement;

    public ClubAnnouncementActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_annoucement);

        mAnnouncement = findViewById(R.id.announcement_edit_text);
        mAnnouncement.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                announcement = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mCancelButton = findViewById(R.id.announcement_cancel_button);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mSubmitButton = findViewById(R.id.announcement_submit_button);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager = SmsManager.getDefault();
                List<InClub> inClubs = InClubLab.get(ClubAnnouncementActivity.this).getMembersInClub(UUID.fromString(getIntent().getStringExtra("clubId")));
                for(InClub inClub : inClubs){
                    String phoneNumber = UserLab.get(ClubAnnouncementActivity.this).getUser(inClub.getStudentId()).getPhoneNumber();
                    smsManager.sendTextMessage(phoneNumber, null, announcement, null, null);
                }
                Toast.makeText(ClubAnnouncementActivity.this, "Members has been texted" ,Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }
}
