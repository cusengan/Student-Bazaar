package com.example.william.studentbazaar.ClubDirectory;

import android.support.v4.app.Fragment;

import com.example.william.studentbazaar.SingleFragmentActivity;

public class ClubListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ClubListFragment();
    }
}
