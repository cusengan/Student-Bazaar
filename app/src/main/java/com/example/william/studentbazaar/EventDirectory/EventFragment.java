package com.example.william.studentbazaar.EventDirectory;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.william.studentbazaar.ClubDirectory.ClubAnnouncementActivity;
import com.example.william.studentbazaar.ClubDirectory.ClubLab;
import com.example.william.studentbazaar.ClubDirectory.InClub;
import com.example.william.studentbazaar.ClubDirectory.InClubLab;
import com.example.william.studentbazaar.EventDirectory.Event;
import com.example.william.studentbazaar.EventDirectory.EventFragment;
import com.example.william.studentbazaar.Global;
import com.example.william.studentbazaar.R;

import java.util.UUID;

public class EventFragment extends Fragment {

    private static final String ARG_EVENT_ID = "event_id";
    private Event mEvent;
    private TextView mEventName;
    private TextView mEventDescription;
    private TextView mUsers;
    private Button mJoinEventButton;
    private Button mLeaveEventButton;
    private Button mAnnouncementButton;

    public static EventFragment newInstance(UUID eventId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_EVENT_ID, eventId);

        EventFragment fragment = new EventFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID eventId = (UUID) getArguments().getSerializable(ARG_EVENT_ID);
        mEvent = EventLab.get(getActivity()).getEvent(eventId);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_event_fragment, container, false);
//        inClub = new InClub();
//        inClub.setClubId(mClub.getId());
//        inClub.setStudentId(Global.currentUser.getStudentId());
//
//        mClubName = v.findViewById(R.id.club_name_text_view);
//        mClubName.setText(mClub.getName());
//        mClubDescription = v.findViewById(R.id.club_description_text);
//        mClubDescription.setText(mClub.getDescription());
//        mUsers = v.findViewById(R.id.club_users);
//        mUsers.setText(getUsers());
//
//        mJoinClubButton = v.findViewById(R.id.join_club_button);
//        mJoinClubButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                InClubLab.get(getActivity()).addInClub(inClub);
//                mUsers.setText(getUsers());
//            }
//        });
//
//        mLeaveClubButton = v.findViewById(R.id.leave_club_button);
//        mLeaveClubButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                InClubLab.get(getActivity()).deleteInClub(inClub);
//                mUsers.setText(getUsers());
//            }
//        });
//
//        mAnnouncementButton = v.findViewById(R.id.announcement_button);
//        mAnnouncementButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(InClubLab.get(getActivity()).getInClub(inClub) == null){
//                    Toast.makeText(getActivity(), "You must join the club before you can make an announcement" ,Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                Intent intent = new Intent(getActivity(), ClubAnnouncementActivity.class);
//                intent.putExtra("clubId", mClub.getId().toString());
//                startActivity(intent);
//            }
//        });


        return v;
    }
}
