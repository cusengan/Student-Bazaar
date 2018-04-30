package com.example.william.studentbazaar.TradeDirectory;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.william.studentbazaar.ClubDirectory.ClubListFragment;
import com.example.william.studentbazaar.SingleFragmentActivity;

public class ItemListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ItemListFragment();
    }
}
