package com.example.william.studentbazaar.ClubDirectory;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.william.studentbazaar.R;

import java.util.UUID;

public class ClubFragment extends Fragment {

    private static final String ARG_CLUB_ID = "club_id";
    private Club mClub;
    private TextView mClubName;
    private TextView mClubDescription;

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
        mClubName = v.findViewById(R.id.club_name_text_view);
        mClubName.setText(mClub.getName());
        mClubDescription = v.findViewById(R.id.club_description_text);
        mClubDescription.setText(mClub.getDescription());
        return v;
    }
}
