package com.example.bootcamp1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "users.db";
    private static final int DATABASE_VERSION = 1;

    // Table Name
    public static final String TABLE_USERS = "users";

    // Column Names
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "username"; // Username or Full Name
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_PHONE = "phone_number";
    public static final String COLUMN_AADHAR = "aadhar_number";

    // SQL query to create the user table
    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_USERS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_USERNAME + " TEXT UNIQUE, " +
                    COLUMN_PASSWORD + " TEXT, " +
                    COLUMN_PHONE + " TEXT, " +
                    COLUMN_AADHAR + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    // Method for user registration
    public String registerUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Check if username already exists
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + " = ?", new String[]{username});
        if (cursor.getCount() > 0) {
            cursor.close();
            return "Username already taken"; // Return error message if username exists
        }
        cursor.close();

        // Proceed to insert if username is unique
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_PASSWORD, password);
        //values.put(COLUMN_PHONE, phoneNumber);
        //values.put(COLUMN_AADHAR, aadharNumber);

        long result = db.insert(TABLE_USERS, null, values);
        return result != -1 ? "Registration successful" : "Registration failed"; // Return appropriate message
    }

    // Method for verifying user login
    public String verifyUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("SELECT * FROM " + TABLE_USERS + " WHERE " +
                    COLUMN_USERNAME + " = ? AND " +
                    COLUMN_PASSWORD + " = ?", new String[]{username, password});
            return cursor.getCount() > 0 ? "verifying" : "not a verified user"; // returns true if user found
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }
    }
}