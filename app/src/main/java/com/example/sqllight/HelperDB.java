package com.example.sqllight;

import static com.example.sqllight.Grades.GRADE;
import static com.example.sqllight.Grades.QUARTER_NUMBER;
import static com.example.sqllight.Grades.SUBJECT;
import static com.example.sqllight.Grades.TABLE_GRADES;
import static com.example.sqllight.Grades.TASK_TYPE;
import static com.example.sqllight.Student_info.ADDRESS;
import static com.example.sqllight.Student_info.IS_ACTIVE;
import static com.example.sqllight.Student_info.NAME;
import static com.example.sqllight.Student_info.NAME_DAD;
import static com.example.sqllight.Student_info.NAME_MOM;
import static com.example.sqllight.Student_info.PHONE_DAD;
import static com.example.sqllight.Student_info.PHONE_HOME;
import static com.example.sqllight.Student_info.PHONE_MOM;
import static com.example.sqllight.Student_info.PHONE_STUDENT;
import static com.example.sqllight.Student_info.TABLE_STUDENTS;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HelperDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "student.db";
    private static final int DATABASE_VERSION = 1;
    String strCreate, strDelete;
    public HelperDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        strCreate="CREATE TABLE "+TABLE_STUDENTS;
        strCreate+=" "+IS_ACTIVE+" INTEGER,";
        strCreate+=" ("+ADDRESS+" TEXT,";
        strCreate+=" "+NAME+" TEXT,";
        strCreate+=" "+PHONE_STUDENT+" INTEGER,";
        strCreate+=" "+PHONE_HOME+" INTEGER,";
        strCreate+=" "+PHONE_MOM+" INTEGER,";
        strCreate+=" "+PHONE_DAD+" INTEGER,";
        strCreate+=" "+NAME_DAD+" TEXT,";
        strCreate+=" "+NAME_MOM+" TEXT,";
        strCreate+=");";
        db.execSQL(strCreate);

        strCreate="CREATE TABLE "+TABLE_GRADES;
        strCreate+=" "+SUBJECT+" TEXT,";
        strCreate+=" "+GRADE+" INTEGER";
        strCreate+=" "+TASK_TYPE+" TEXT,";
        strCreate+=" "+QUARTER_NUMBER+" INTEGER,";

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        strDelete="DROP TABLE IF EXISTS "+TABLE_STUDENTS;
        db.execSQL(strDelete);
        strDelete="DROP TABLE IF EXISTS "+TABLE_GRADES;
        db.execSQL(strDelete);
        onCreate(db);
    }
}
