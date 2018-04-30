package com.example.william.studentbazaar.ClubDirectory;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.william.studentbazaar.Global;
import com.example.william.studentbazaar.R;
import com.example.william.studentbazaar.User.UserLab;
import com.example.william.studentbazaar.database.StudentBazaarDbSchema;

import java.util.List;
import java.util.UUID;

public class ClubFragment extends Fragment {

    private static final String ARG_CLUB_ID = "club_id";
    private Club mClub;
    private TextView mClubName;
    private TextView mClubDescription;
    private TextView mUsers;
    private Button mJoinClubButton;
    private Button mLeaveClubButton;
    private Button mAnnouncementButton;
    private InClub inClub;

    public static ClubFragment newInstance(UUID crimeId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CLUB_ID, crimeId);

        ClubFragment fragment = new ClubFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID clubId = (UUID) getArguments().getSerializable(ARG_CLUB_ID);
        mClub = ClubLab.get(getActivity()).getClub(clubId);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_club_fragment, container, false);
        inClub = new InClub();
        inClub.setClubId(mClub.getId());
        inClub.setStudentId(Global.currentUser.getStudentId());

        mClubName = v.findViewById(R.id.club_name_text_view);
        mClubName.setText(mClub.getName());
        mClubDescription = v.findViewById(R.id.club_description_text);
        mClubDescription.setText(mClub.getDescription());
        mUsers = v.findViewById(R.id.club_users);
        mUsers.setText(getUsers());

        mJoinClubButton = v.findViewById(R.id.join_club_button);
        mJoinClubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InClubLab.get(getActivity()).addInClub(inClub);
                mUsers.setText(getUsers());
            }
        });

        mLeaveClubButton = v.findViewById(R.id.leave_club_button);
        mLeaveClubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InClubLab.get(getActivity()).deleteInClub(inClub);
                mUsers.setText(getUsers());
            }
        });

        mAnnouncementButton = v.findViewById(R.id.announcement_button);
        mAnnouncementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(InClubLab.get(getActivity()).getInClub(inClub) == null){
                    Toast.makeText(getActivity(), "You must join the club before you can make an announcement" ,Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(getActivity(), ClubAnnouncementActivity.class);
                intent.putExtra("clubId", mClub.getId().toString());
                startActivity(intent);
            }
        });


        return v;
    }

    public String getUsers() {
        StringBuilder sb = new StringBuilder();
        List<InClub> inClubs = InClubLab.get(getActivity()).getMembersInClub(mClub.getId());
        for(InClub inClub : inClubs) {
            String studentName = UserLab.get(getActivity()).getUser(inClub.getStudentId()).getFullName();
            sb.append(studentName);
            sb.append("\n");
        }

        return sb.toString();
    }
}
