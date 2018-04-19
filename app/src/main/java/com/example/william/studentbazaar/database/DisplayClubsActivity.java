package com.example.william.studentbazaar.database;

import android.support.v4.app.Fragment;

import com.example.william.studentbazaar.ClubDirectory.ClubListFragment;
import com.example.william.studentbazaar.SingleFragmentActivity;

public class DisplayClubsActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ClubListFragment();
    }
}
