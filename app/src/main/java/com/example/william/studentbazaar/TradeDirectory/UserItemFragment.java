package com.example.william.studentbazaar.TradeDirectory;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.william.studentbazaar.R;
import com.example.william.studentbazaar.TradeDirectory.Item;
import com.example.william.studentbazaar.TradeDirectory.ItemLab;
import com.example.william.studentbazaar.User.User;
import com.example.william.studentbazaar.User.UserLab;

import java.util.UUID;

public class UserItemFragment extends Fragment {

    private static final String ARG_ITEM_ID = "item_id";
    private Item mItem;
    private TextView mItemName;
    private TextView mItemDescription;
    private TextView mContactName;
    private TextView mContactNumber;
    private TextView mContactEmail;

    public static UserItemFragment newInstance(UUID crimeId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_ITEM_ID, crimeId);

        UserItemFragment fragment = new UserItemFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID itemId = (UUID) getArguments().getSerializable(ARG_ITEM_ID);
        mItem = ItemLab.get(getActivity()).getItem(itemId);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_user_item_fragment, container, false);
        User seller = UserLab.get(getActivity()).getUser(mItem.getOwnerId());
        mItemName = v.findViewById(R.id.user_item_name_text_view);
        mItemDescription = v.findViewById(R.id.user_item_description_text_view);
        mContactName = v.findViewById(R.id.user_contact_name);
        mContactNumber = v.findViewById(R.id.user_contact_number);
        mContactEmail = v.findViewById(R.id.user_contact_email);

        mItemName.setText(mItem.getName());
        mItemDescription.setText(mItem.getDescription());
        mContactName.setText(seller.getFullName());
        mContactNumber.setText(seller.getPhoneNumber());
        mContactEmail.setText(seller.getEmail());

        return v;
    }
}
