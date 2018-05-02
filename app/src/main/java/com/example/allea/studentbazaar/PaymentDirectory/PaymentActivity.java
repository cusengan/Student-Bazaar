package com.example.allea.studentbazaar.PaymentDirectory;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.william.studentbazaar.Global;
import com.example.william.studentbazaar.LoginActivity;
import com.example.william.studentbazaar.R;
import com.example.william.studentbazaar.TradeDirectory.CreateItemActivity;
import com.example.william.studentbazaar.TradeDirectory.Item;
import com.example.william.studentbazaar.TradeDirectory.ItemLab;
import com.example.william.studentbazaar.User.User;
import com.example.william.studentbazaar.User.UserLab;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PaymentActivity extends AppCompatActivity {

    private EditText mCardName;
    private EditText mCardNumber;
    private EditText mExpiryDate;
    private EditText mSecurityCode;
    private String cardName;
    private String cardNumber;
    private String expiryDate;
    private String securityCode;
    private Item mItem;

    private Button mCancelButton;
    private Button mSubmitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_form);
        mCardName = findViewById(R.id.card_name_edit_text);
        String itemId = getIntent().getStringExtra("itemId");
        mItem = ItemLab.get(PaymentActivity.this).getItem(UUID.fromString(itemId));

        cardName = "";
        cardNumber = "";
        expiryDate = "";
        securityCode = "";

        mCardName = findViewById(R.id.card_name_edit_text);
        mCardName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cardName = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mCardNumber = findViewById(R.id.card_number_edit_text);
        mCardNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cardNumber = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mExpiryDate = findViewById(R.id.expiry_edit_text);
        mExpiryDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                expiryDate = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mSecurityCode = findViewById(R.id.security_code_edit_text);
        mSecurityCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                securityCode = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mCancelButton = findViewById(R.id.payment_cancel_button);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mSubmitButton = findViewById(R.id.payment_submit_button);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cardName.isEmpty() || cardNumber.isEmpty() || expiryDate.isEmpty() || securityCode.isEmpty()){
                    Toast.makeText(PaymentActivity.this, "Invalid information", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(cardNumber.length() < 16){
                    Toast.makeText(PaymentActivity.this, "Invalid card number", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(expiryDate.length() != 7 || expiryDate.charAt(2) != '/'){
                    Toast.makeText(PaymentActivity.this, "Invalid date format", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    DateFormat formatter;
                    Date date;
                    formatter = new SimpleDateFormat("MM/yyyy");
                    date = formatter.parse(expiryDate);
                    Date today = new Date();
                    if(today.after(date) || today.equals(date)){
                        Toast.makeText(PaymentActivity.this, "Invalid date", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } catch (ParseException e) {
                    Toast.makeText(PaymentActivity.this, "Invalid date", Toast.LENGTH_SHORT).show();
                }

                if(securityCode.length() != 3){
                    Toast.makeText(PaymentActivity.this, "Invalid security code", Toast.LENGTH_SHORT).show();
                    return;
                }


                Toast.makeText(PaymentActivity.this, "Payment Submitted", Toast.LENGTH_SHORT).show();
                User seller = UserLab.get(PaymentActivity.this).getUser(mItem.getOwnerId());
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(seller.getPhoneNumber(), null, Global.currentUser.getFullName() + " has bought the item " + mItem.getName() + " from the University Bazaar Market.", null, null);
                finish();
            }
        });


    }
}
