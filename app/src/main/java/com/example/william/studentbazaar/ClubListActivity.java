package com.example.william.studentbazaar;

import android.support.v4.app.Fragment;
public class ClubListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ClubListFragment();
    }
}
