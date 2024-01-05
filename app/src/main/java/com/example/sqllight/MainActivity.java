package com.example.sqllight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText EName,EAddress,ECellS,ETPhoneH,ENameMom,ENameDad,EPhoneDad,EPhoneMom;
    ContentValues cv = new ContentValues();
    Switch S;
    HelperDB hlp;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        S=findViewById(R.id.switch1);
        EName= findViewById(R.id.editTextName);
        EAddress = findViewById(R.id.editTextAddress);
        ECellS = findViewById(R.id.editTextCellS);
        ETPhoneH = findViewById(R.id.editTextPhoneH);
        ENameMom = findViewById(R.id.editTextNameMom);
        ENameDad = findViewById(R.id.editTextNameDad);
        EPhoneDad = findViewById(R.id.editTextPhoneMom);
        EPhoneMom = findViewById(R.id.editTextPhoneDad);


    }

    public void Btn(View view) {
        hlp = new HelperDB(this);
        db = hlp.getWritableDatabase();
        db.close();
        if(S.isChecked())
        {
            cv.put(Student_info.IS_ACTIVE,1);
        }
        else
        {
            cv.put(Student_info.IS_ACTIVE,1);
        }
        cv.put(Student_info.NAME,EName.getText().toString());
        cv.put(Student_info.ADDRESS,EAddress.getText().toString());
        cv.put(Student_info.PHONE_STUDENT,ECellS.getText().toString());
        cv.put(Student_info.PHONE_HOME,ETPhoneH.getText().toString());
        cv.put(Student_info.PHONE_MOM,EPhoneMom.getText().toString());
        cv.put(Student_info.PHONE_DAD,EPhoneDad.getText().toString());
        cv.put(Student_info.NAME_DAD,ENameDad.getText().toString());
        cv.put(Student_info.NAME_MOM,ENameMom.getText().toString());
        db.insert(Student_info.TABLE_STUDENTS, null, cv);
        db.close();
        Toast.makeText(this, "it worked", Toast.LENGTH_SHORT).show();

    }
}