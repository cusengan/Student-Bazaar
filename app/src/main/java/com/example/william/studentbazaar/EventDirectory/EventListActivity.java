package com.example.william.studentbazaar.EventDirectory;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.william.studentbazaar.ClubDirectory.ClubListFragment;
import com.example.william.studentbazaar.R;
import com.example.william.studentbazaar.SingleFragmentActivity;

public class EventListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ClubListFragment();
    }
}
