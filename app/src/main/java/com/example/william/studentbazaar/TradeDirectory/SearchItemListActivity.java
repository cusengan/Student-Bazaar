package com.example.william.studentbazaar.TradeDirectory;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.william.studentbazaar.R;
import com.example.william.studentbazaar.SingleFragmentActivity;

import java.util.UUID;

public class SearchItemListActivity extends SingleFragmentActivity {

    private static final String EXTRA_QUERY_ID = "com.example.william.studentbazaar.TradeDirectory.query";

    public static Intent newIntent(Context packageContext, String query) {
        Intent intent = new Intent(packageContext, SearchItemListActivity.class);
        intent.putExtra(EXTRA_QUERY_ID, query);
        return intent;
    }

    public String getQuery(){
        return getIntent().getStringExtra(EXTRA_QUERY_ID);
    }

    @Override
    protected Fragment createFragment() {
        return new SearchItemListFragment();
    }
}
