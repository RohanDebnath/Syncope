package com.example.syncope;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {

    private Button logoutButton;
    private FirebaseAuth mAuth;
    private CardView cardView, card2;
    private LinearLayout expansionLayout,expansion2;
    private boolean Expanded2 = false;
    private TextView titleTextView, title2;
    private TextView descriptionTextView, description2;
    private Button openActivityButton, opendoctorBtn;
    private boolean isExpanded = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        logoutButton=findViewById(R.id.logoutBtn);
        cardView = findViewById(R.id.cardView);
        expansionLayout = findViewById(R.id.expansionLayout);
        titleTextView = findViewById(R.id.titleTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);
        openActivityButton = findViewById(R.id.openActivityButton);
        card2 = findViewById(R.id.cardView2);
        expansion2 = findViewById(R.id.expansionLayout2);
        title2 = findViewById(R.id.titleTextView2);
        description2 = findViewById(R.id.descriptionTextView2);
        opendoctorBtn = findViewById(R.id.openActivityButton2);

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleExpansion2();

            }
        });
        opendoctorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Dashboard.this,Doctor.class);
                startActivity(intent);

            }
        });

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleExpansion();
            }
        });

        openActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dashboard.this,SynTimer.class);
                startActivity(intent);
            }
        });
    }
    private void toggleExpansion() {
        if (isExpanded) {
            expansionLayout.setVisibility(View.GONE);
            titleTextView.setText("Emergency Alert");
            isExpanded = false;
        } else {
            expansionLayout.setVisibility(View.VISIBLE);
            titleTextView.setText("Emergency Alert (expanded)");
            isExpanded = true;
        }

        mAuth = FirebaseAuth.getInstance();
        logoutButton = findViewById(R.id.logoutBtn);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the logout function
                Intent intent=new Intent(Dashboard.this,Login.class);
                startActivity(intent);
                finish(); // Close the Dashboard activity
            }
        });
    }
    private void toggleExpansion2() {
        if (Expanded2) {
            expansion2.setVisibility(View.GONE);
            title2.setText("Consult Doctor");
            Expanded2 = false;
        } else {
            expansion2.setVisibility(View.VISIBLE);
            title2.setText("Consult Doctor (expanded)");
            Expanded2 = true;
        }
    }

}
