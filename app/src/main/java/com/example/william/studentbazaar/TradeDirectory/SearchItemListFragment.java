package com.example.william.studentbazaar.TradeDirectory;

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

public class SearchItemListFragment extends Fragment {

    private RecyclerView mItemRecyclerView;
    private ItemAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        mItemRecyclerView = view.findViewById(R.id.item_recycler_view);
        mItemRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        ItemLab itemLab = ItemLab.get(getActivity());
        List<Item> items = itemLab.getItemsOnSale("PC");

        if (mAdapter == null) {
            mAdapter = new SearchItemListFragment.ItemAdapter(items);
            mItemRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setCrimes(items);
            mAdapter.notifyDataSetChanged();
        }

    }

    private class ItemHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private Item mItem;

        private TextView mNameTextView;
        private TextView mDescriptionTextView;

        public ItemHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_item, parent, false));
            itemView.setOnClickListener(this);

            mNameTextView = itemView.findViewById(R.id.item_name);
            mDescriptionTextView =  itemView.findViewById(R.id.item_description);
        }

        public void bind(Item Item) {
            mItem = Item;
            mNameTextView.setText(mItem.getName());
            mDescriptionTextView.setText(mItem.getDescription());
        }

        @Override
        public void onClick(View view) {
            Intent intent = ItemPagerActivity.newIntent(getActivity(), mItem.getId());
            startActivity(intent);
        }
    }

    private class ItemAdapter extends RecyclerView.Adapter<SearchItemListFragment.ItemHolder> {

        private List<Item> mItems;

        public ItemAdapter(List<Item> Items) {
            mItems = Items;
        }

        @Override
        public SearchItemListFragment.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new SearchItemListFragment.ItemHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(SearchItemListFragment.ItemHolder holder, int position) {
            Item Item = mItems.get(position);
            holder.bind(Item);
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }

        public void setCrimes(List<Item> items) {
            mItems = items;
        }
    }
}
