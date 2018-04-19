package com.example.william.studentbazaar.ClubDirectory;

import android.support.v4.app.Fragment;
import android.os.Bundle;

import java.util.UUID;

public class ClubFragment extends Fragment {

    private static final String ARG_CLUB_ID = "club_id";

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
//        setContentView(R.layout.activity_club_fragment);
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//    }
}
