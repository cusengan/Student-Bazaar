package com.example.william.studentbazaar.TradeDirectory;

import android.support.v4.app.Fragment;

import com.example.william.studentbazaar.SingleFragmentActivity;

public class UserItemListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new UserItemListFragment();
    }
}
