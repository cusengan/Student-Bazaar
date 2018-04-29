package com.example.william.studentbazaar.TradeDirectory;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
//import android.view.View;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.william.studentbazaar.Global;
import com.example.william.studentbazaar.LoginActivity;
import com.example.william.studentbazaar.R;
import com.example.william.studentbazaar.User.User;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Michelle Dinh on 4/23/2018.
 */

public class CreateItemActivity extends AppCompatActivity {

    private static final int REQUEST_PHOTO = 2;

    private Button mSubmitButton;
    private Button mCancelButton;
    private EditText mItemName;
    private EditText mItemDescription;
    private String itemName;
    private String itemDescription;

    private File mPhotoFile;
    private ImageButton mImageButton;
    private ImageView mPhotoView;
    UUID uuid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade_sellitemform);
        File filesDir = CreateItemActivity.this.getFilesDir();
        uuid = UUID.randomUUID();
        mPhotoFile = new File(filesDir, "IMG_" + uuid.toString() + ".jpg");
        itemName = "";
        itemDescription = "";
        mSubmitButton = findViewById(R.id.item_submit_button);
        mCancelButton = findViewById(R.id.item_cancel_button);

        mItemName = findViewById(R.id.item_name_edit_text);
        mItemName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                itemName = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mItemDescription = findViewById(R.id.item_description_edit_text);
        mItemDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                itemDescription = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mImageButton = findViewById(R.id.item_camera);
        final Intent captureImage = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        boolean canTakePhoto = mPhotoFile != null && captureImage.resolveActivity(getPackageManager()) != null;

        mImageButton.setEnabled(canTakePhoto);

        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = FileProvider.getUriForFile(CreateItemActivity.this,
                        "com.example.william.studentbazaar.TradeDirectory.fileprovider",
                        mPhotoFile);
                captureImage.putExtra(MediaStore.EXTRA_OUTPUT, uri);

                List<ResolveInfo> cameraActivities = CreateItemActivity.this
                        .getPackageManager().queryIntentActivities(captureImage,
                                PackageManager.MATCH_DEFAULT_ONLY);

                for (ResolveInfo activity : cameraActivities) {
                    CreateItemActivity.this.grantUriPermission(activity.activityInfo.packageName,
                            uri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                }

                startActivityForResult(captureImage, REQUEST_PHOTO);
            }
        });

        mPhotoView = findViewById(R.id.item_photo);
        updatePhotoView();

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemName.isEmpty() || itemDescription.isEmpty()){
                    Toast.makeText(CreateItemActivity.this, "An input box is empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                Item item = new Item();
                User user = Global.currentUser;
                item.setId(uuid);
                item.setName(itemName);
                item.setDescription(itemDescription);
                item.setOwnerId(user.getStudentId());
                item.setOnSale(true);

                ItemLab.get(CreateItemActivity.this).addItem(item);
                finish();
            }
        });

        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void updatePhotoView() {
        if (mPhotoFile == null || !mPhotoFile.exists()) {
            mPhotoView.setImageDrawable(null);
        } else {
            Bitmap bitmap = PictureUtils.getScaledBitmap(
                    mPhotoFile.getPath(), CreateItemActivity.this);
            mPhotoView.setImageBitmap(bitmap);
            try{
                FileOutputStream fOut = new FileOutputStream(mPhotoFile);
                bitmap.compress(Bitmap.CompressFormat.PNG, 85, fOut);
                fOut.flush();
                fOut.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_PHOTO) {
            Uri uri = FileProvider.getUriForFile(CreateItemActivity.this,
                    "com.example.william.studentbazaar.TradeDirectory.fileprovider",
                    mPhotoFile);

            CreateItemActivity.this.revokeUriPermission(uri,
                    Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

            updatePhotoView();
        }
    }
}
