package com.example.sqllight;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;

public class Grade_data extends AppCompatActivity {
    EditText ESubject,EQuarter,EGrade,ETaskT;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_data);
        ESubject = findViewById(R.id.editTextSubject);
        EGrade = findViewById(R.id.editTextGrade);
        EQuarter = findViewById(R.id.editTextQuarter);
        ETaskT = findViewById(R.id.editTextNameT);
    }
}