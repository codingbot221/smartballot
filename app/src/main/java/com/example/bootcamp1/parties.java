package com.example.bootcamp1;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class parties extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton selectedRadioButton;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parties); // Ensure that this XML layout matches the file name.

        // Initialize RadioGroup and Button
        radioGroup = findViewById(R.id.radioGroup);
        submitButton = findViewById(R.id.button2);

        // Set onClickListener for submit button
        submitButton.setOnClickListener(view -> {
            // Get the selected RadioButton's ID
            int selectedId = radioGroup.getCheckedRadioButtonId();

            // Check if no option is selected
            if (selectedId == -1) {
                // Display negative alert dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(parties.this);
                builder.setTitle("Alert")
                        .setMessage("Please select one of the options before submitting.")
                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                        .show();
            } else {
                // Get the selected RadioButton
                selectedRadioButton = findViewById(selectedId);
                String selectedOption = selectedRadioButton.getText().toString();

                // Display confirmation dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(parties.this);
                builder.setTitle("Confirmation")
                        .setMessage("Are you sure you want to continue with the option: " + selectedOption + "?")
                        .setPositiveButton("Yes", (dialog, which) -> {
                            // Confirmation action
                            Toast.makeText(parties.this, "You selected: " + selectedOption, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(parties.this, closing.class);
                            startActivity(intent);
                        })
                        .setNegativeButton("No", (dialog, which) -> {
                            // Clear the selection in the RadioGroup
                            radioGroup.clearCheck();
                            dialog.dismiss();
                        })
                        .show();
            }
        });
    }
}