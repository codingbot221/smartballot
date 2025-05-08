package com.example.bootcamp1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class fpassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fpassword);
        // Declare UI elements
        ImageView imageView1, imageView2;
        TextView textView;
        EditText emailEditText;
        Button resetButton;

        // Initialize UI elements by finding them via their IDs
        imageView1 = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        textView = findViewById(R.id.textView);
        emailEditText = findViewById(R.id.editTextTextEmailAddress);
        resetButton = findViewById(R.id.button);


        // Set onClickListener for the reset button
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the email entered by the user
                String email = emailEditText.getText().toString().trim();

                // Check if the email field is empty
                if (email.isEmpty()) {
                    Toast.makeText(fpassword.this, "Please enter your registered email", Toast.LENGTH_SHORT).show();
                } else {
                    // Perform password reset action (this is just an example)
                    Toast.makeText(fpassword.this, "Password reset link sent to: " + email, Toast.LENGTH_SHORT).show();
                    // You can add actual functionality to send a password reset email here



                }
            }
        });





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}