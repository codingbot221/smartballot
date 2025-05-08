package com.example.bootcamp1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class closing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Enable edge-to-edge if needed
        setContentView(R.layout.activity_closing); // Make sure this layout exists

        // Initialize views
        TextView thankYouText = findViewById(R.id.thank_you_text);
        ImageView voteImage = findViewById(R.id.vote_image);

        // Set the text for thank you message (optional)
        thankYouText.setText("Thanks for Voting!!");

    }
    @Override
    public void onBackPressed(){
        // Navigate back to the Voter activity
        //Intent intent = new Intent(closing.this, Voter.class);
        //startActivity(intent);
       // finish(); // Finish closing activity to remove it from the back stack
        finishAffinity();
    }
}
