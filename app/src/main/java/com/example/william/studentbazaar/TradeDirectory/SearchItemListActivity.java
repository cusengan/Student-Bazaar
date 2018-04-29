package com.example.william.studentbazaar.TradeDirectory;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.william.studentbazaar.R;
import com.example.william.studentbazaar.SingleFragmentActivity;

public class SearchItemListActivity extends SingleFragmentActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search_item_list);
//    }

    @Override
    protected Fragment createFragment() {
        return new SearchItemListFragment();
    }
}
