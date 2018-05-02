package com.example.william.studentbazaar.EventDirectory;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import com.example.william.studentbazaar.User.User;
import com.example.william.studentbazaar.User.UserLab;

import java.util.UUID;

public class EventFragment extends Fragment {

    private static final String ARG_EVENT_ID = "event_id";
    private Event mEvent;
    private TextView mEventName;
    private TextView mEventDescription;
    private TextView mEventCreator;
    private Button mEventDisplayButton;
    private Button mEventBackButton;

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

        mEventName = v.findViewById(R.id.event_name_text_view);
        mEventName.setText(mEvent.getName());
        mEventDescription = v.findViewById(R.id.event_description_text);
        mEventDescription.setText(mEvent.getDescription());

        mEventCreator = v.findViewById(R.id.event_creater_name);
        User creator = UserLab.get(getActivity()).getUser(mEvent.getOwnerId());
        mEventCreator.setText(creator.getFullName());

        mEventDisplayButton = v.findViewById(R.id.set_event_display_button);
        if(!Global.currentUser.getStudentId().equals(mEvent.getOwnerId())){
            mEventDisplayButton.setEnabled(false);
        }
        setDisplayButtonText();
        mEventDisplayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEvent.setDisplay(!mEvent.onDisplay());
                EventLab.get(getActivity()).updateEvent(mEvent);
                setDisplayButtonText();
            }
        });

        mEventBackButton = v.findViewById(R.id.event_back_button);
        mEventBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });



        return v;
    }

    private void setDisplayButtonText(){
        if(mEvent.onDisplay()){
            mEventDisplayButton.setText("Click to turn off displaying of this event");
            Toast.makeText(getActivity(), "Event is no longer being displayed", Toast.LENGTH_SHORT).show();
        }else{
            mEventDisplayButton.setText("Click to turn on displaying of this event");
            Toast.makeText(getActivity(), "Event is being displayed", Toast.LENGTH_SHORT).show();
        }
    }
}
