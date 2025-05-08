package com.example.bootcamp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {

    EditText usernameEditText, passwordEditText, phoneNumberEditText, aadharEditText;
    Button registerButton;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize the UI elements
        usernameEditText = findViewById(R.id.name);
        passwordEditText = findViewById(R.id.password);
        phoneNumberEditText = findViewById(R.id.mobile);
        aadharEditText = findViewById(R.id.aadhar);
        registerButton = findViewById(R.id.submitButton);

        // Initialize the DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // Set an onClickListener for the register button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get input data from EditText fields
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String phoneNumber = phoneNumberEditText.getText().toString().trim();
                String aadharNumber = aadharEditText.getText().toString().trim();

                // Check if any field is empty
                if (username.isEmpty() || password.isEmpty() || phoneNumber.isEmpty() || aadharNumber.isEmpty()) {
                    Toast.makeText(register.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Register user in the database
                    String isRegistered = databaseHelper.registerUser(username, password);

                    if(isRegistered.equals("Registration successful")) {
                        Toast.makeText(register.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                        // Redirect to the verification or login activity
                        Intent intent = new Intent(register.this, Voter.class);
                        startActivity(intent);
                    }
                    else {
                        if(isRegistered.equals("Username already taken")){
                            Toast.makeText(register.this, "Username already taken", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(register.this, "Registration Failed! Username might be taken.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}