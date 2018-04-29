package com.example.william.studentbazaar.TradeDirectory;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.william.studentbazaar.ClubDirectory.CreateClubActivity;
import com.example.william.studentbazaar.R;
import com.example.william.studentbazaar.TradeDirectory.Item;
import com.example.william.studentbazaar.TradeDirectory.ItemLab;
import com.example.william.studentbazaar.User.User;
import com.example.william.studentbazaar.User.UserLab;

import java.io.File;
import java.util.UUID;

public class ItemFragment extends Fragment {

    private static final String ARG_ITEM_ID = "item_id";
    private Item mItem;
    private User seller;
    private TextView mItemName;
    private TextView mItemDescription;
    private TextView mContactName;
    private TextView mContactNumber;
    private TextView mContactEmail;
    private File mPhotoFile;
    private ImageView mPhotoView;

    private Button mContactButton;
    private Button mBackButton;

    public static ItemFragment newInstance(UUID crimeId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_ITEM_ID, crimeId);

        ItemFragment fragment = new ItemFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID itemId = (UUID) getArguments().getSerializable(ARG_ITEM_ID);
        mItem = ItemLab.get(getActivity()).getItem(itemId);
        Log.d("file", mItem.getPhotoFilename());
        mPhotoFile = ItemLab.get(getActivity()).getPhotoFile(mItem);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_item_fragment, container, false);
        seller = UserLab.get(getActivity()).getUser(mItem.getOwnerId());
        mItemName = v.findViewById(R.id.item_name_text_view);
        mItemDescription = v.findViewById(R.id.item_description_text_view);
        mContactName = v.findViewById(R.id.contact_name);
        mContactNumber = v.findViewById(R.id.contact_number);
        mContactEmail = v.findViewById(R.id.contact_email);

        mItemName.setText(mItem.getName());
        mItemDescription.setText(mItem.getDescription());
        mContactName.setText(seller.getFullName());
        mContactNumber.setText(seller.getPhoneNumber());
        mContactEmail.setText(seller.getEmail());

        mPhotoView = v.findViewById(R.id.item_display_photo);
        updatePhotoView();

        mContactButton = v.findViewById(R.id.contact_seller_button);
        mContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(seller.getPhoneNumber(), null, "Hey! I'm interested in meeting up to trade for " + mItem.getName() + ". Message me back if you are interested.", null, null);
                Toast.makeText(getActivity(), "Seller has been texted" ,Toast.LENGTH_SHORT).show();
            }
        });

        mBackButton = v.findViewById(R.id.back_button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        return v;
    }

    private void updatePhotoView() {
        if (mPhotoFile == null || !mPhotoFile.exists()) {
            mPhotoView.setImageDrawable(null);
            Log.d("file", "does not exist");
        } else {
            Bitmap bitmap = PictureUtils.getScaledBitmap(
                    mPhotoFile.getPath(), getActivity());
            mPhotoView.setImageBitmap(bitmap);
        }
    }

}
