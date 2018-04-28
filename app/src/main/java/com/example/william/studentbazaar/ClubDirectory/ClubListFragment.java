package com.example.william.studentbazaar.ClubDirectory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.william.studentbazaar.R;

import java.util.List;

public class ClubListFragment extends Fragment {

    private RecyclerView mClubRecyclerView;
    private ClubAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_club_list, container, false);

        mClubRecyclerView = view.findViewById(R.id.club_recycler_view);
        mClubRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        ClubLab clubLab = ClubLab.get(getActivity());
        List<Club> clubs = clubLab.getClubs();

        if (mAdapter == null) {
            mAdapter = new ClubAdapter(clubs);
            mClubRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setCrimes(clubs);
            mAdapter.notifyDataSetChanged();
        }

    }

    private class ClubHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private Club mClub;

        private TextView mNameTextView;
        private TextView mDescriptionTextView;

        public ClubHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_club, parent, false));
            itemView.setOnClickListener(this);

            mNameTextView = itemView.findViewById(R.id.club_name);
            mDescriptionTextView =  itemView.findViewById(R.id.club_description);
        }

        public void bind(Club club) {
            mClub = club;
            mNameTextView.setText(mClub.getName());
            mDescriptionTextView.setText(mClub.getDescription());
        }

        @Override
        public void onClick(View view) {
            Intent intent = ClubPagerActivity.newIntent(getActivity(), mClub.getId());
            startActivity(intent);
        }
    }

    private class ClubAdapter extends RecyclerView.Adapter<ClubHolder> {

        private List<Club> mClubs;

        public ClubAdapter(List<Club> clubs) {
            mClubs = clubs;
        }

        @Override
        public ClubHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new ClubHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ClubHolder holder, int position) {
            Club club = mClubs.get(position);
            holder.bind(club);
        }

        @Override
        public int getItemCount() {
            return mClubs.size();
        }

        public void setCrimes(List<Club> clubs) {
            mClubs = clubs;
        }
    }
}
