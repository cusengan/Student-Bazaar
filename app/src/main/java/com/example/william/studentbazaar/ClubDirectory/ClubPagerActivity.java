package com.example.william.studentbazaar.ClubDirectory;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.william.studentbazaar.R;

import java.util.List;
import java.util.UUID;

public class ClubPagerActivity extends AppCompatActivity {

    private static final String EXTRA_CLUB_ID =
            "com.example.william.studentbazaar.club_id";

    private ViewPager mViewPager;
    private List<Club> mClubs;

    public static Intent newIntent(Context packageContext, UUID clubId) {
        Intent intent = new Intent(packageContext, ClubPagerActivity.class);
        intent.putExtra(EXTRA_CLUB_ID, clubId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_pager);

        UUID crimeId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_CLUB_ID);

        mViewPager = findViewById(R.id.club_view_pager);

        mClubs = ClubLab.get(this).getClubs();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {

            @Override
            public Fragment getItem(int position) {
                Club club = mClubs.get(position);
                return ClubFragment.newInstance(club.getId());
            }

            @Override
            public int getCount() {
                return mClubs.size();
            }
        });

        for (int i = 0; i < mClubs.size(); i++) {
            if (mClubs.get(i).getId().equals(crimeId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
