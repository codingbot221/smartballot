package com.example.bootcamp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.Cursor;

public class Voter extends AppCompatActivity {
    // Declare UI elements
    EditText usernameEditText, passwordEditText;
    Button loginButton, registerButton;
    TextView forgotPasswordText;
    ImageView emblemImage, electionImage;
    DatabaseHelper databaseHelper;  // DatabaseHelper object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_voter);

        // Initialize UI elements
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);
        registerButton = findViewById(R.id.register_button);
        forgotPasswordText = findViewById(R.id.forgotPassword);
        emblemImage = findViewById(R.id.imageView1);
        electionImage = findViewById(R.id.imageView2);

        // Initialize DatabaseHelper
        databaseHelper = new DatabaseHelper(this); // Create the database helper object

        // Register Button Listener
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Voter.this, register.class);
                startActivity(intent);
            }
        });

        // Forgot Password Button Listener
        forgotPasswordText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Voter.this, fpassword.class);
                startActivity(intent);
            }
        });

        // Login Button Listener
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Check if fields are empty
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Voter.this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
                } else {
                    // Attempt to log in
                    if (loginUser(username, password)) {
                        Toast.makeText(Voter.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Voter.this, verification.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Voter.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    // Method to log in the user
    private boolean loginUser(String username, String password) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();  // Get readable database
        Cursor cursor = null;
        try {
            // Using parameterized query to avoid SQL injection
            cursor = db.rawQuery("SELECT * FROM users WHERE username = ? AND password = ?", new String[]{username, password});

            // Check if any records match the username and password
            return cursor.getCount() > 0; // Return true if user found
        } catch (SQLiteException e) {
            e.printStackTrace(); // Log the error for debugging
            return false; // Return false if an error occurs
        } finally {
            // Ensure cursor and database are closed to prevent memory leaks
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }
    }
}