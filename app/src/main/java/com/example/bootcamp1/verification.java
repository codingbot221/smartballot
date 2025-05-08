package com.example.bootcamp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class verification extends AppCompatActivity {

    EditText fullNameEditText, phoneNumberEditText, aadharEditText, passwordEditText;
    Button verifyButton;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_verification);

        // Initialize the UI elements
        fullNameEditText = findViewById(R.id.editTextText3);
        phoneNumberEditText = findViewById(R.id.editTextText5);
        aadharEditText = findViewById(R.id.editTextText6);
        passwordEditText = findViewById(R.id.editTextTextPassword);
        verifyButton = findViewById(R.id.button);

        // Initialize the DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // Set an onClickListener for the verify button
        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get input data from EditText fields
                String fullName = fullNameEditText.getText().toString().trim();
                String phoneNumber = phoneNumberEditText.getText().toString().trim();
                String aadharNumber = aadharEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Check if any field is empty
                if (fullName.isEmpty() || phoneNumber.isEmpty() || aadharNumber.isEmpty() || password.isEmpty()) {
                    // Display a toast message if any field is empty
                    Toast.makeText(verification.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Register the user
                    String registrationMessage = databaseHelper.registerUser(fullName, password);
                    //Toast.makeText(verification.this, registrationMessage, Toast.LENGTH_SHORT).show();

                    // Check if registration was successful
                    //if (registrationMessage.equals("Registration successful")) {
                    // Proceed to verification
                    String isVerified = databaseHelper.verifyUser(fullName, password);
                    if (isVerified.equals("verifying")) {
                        // Verification successful, move to the next page
                        Toast.makeText(verification.this, "Verification Successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(verification.this, parties.class);
                        startActivity(intent);
                    } else {
                        // Verification failed
                        Toast.makeText(verification.this, "Verification Failed! Please check your details.", Toast.LENGTH_SHORT).show();
                    }
                //}
                }
            }
        });

        // Adjust window insets for system bars (optional)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}