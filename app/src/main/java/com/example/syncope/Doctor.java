package com.example.syncope;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Doctor extends AppCompatActivity {
    private static final int REQUEST_CALL_PHONE = 1;
    private Button callButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        callButton = findViewById(R.id.button_call);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });
    }

    private void makePhoneCall() {
        String phoneNumber = "8420166887"; // Replace with the desired phone number

        // Check if CALL_PHONE permission is granted
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + phoneNumber));
            startActivity(intent);
        } else {
            // Request the CALL_PHONE permission
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PHONE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_CALL_PHONE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, make the phone call
                makePhoneCall();
            } else {
                // Permission denied
                // Handle this case, e.g., show a message or disable the call button
            }
        }
    }
}
