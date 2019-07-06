package com.example.realm_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {
    private EditText name,dept,roll,phone;
    private Switch gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name_et);
        dept=findViewById(R.id.dept_et);
        roll=findViewById(R.id.roll_et);
        phone=findViewById(R.id.phone_et);
        gender=findViewById(R.id.gender_switch);

    }
    private static final String TAG="abc";
    public void onSaveButtonPressed(View view)
    {
        Realm realm=Realm.getDefaultInstance();
        realm.beginTransaction();
        try{
                Student student=realm.createObject(Student.class,System.currentTimeMillis()/1000);
                student.setName(name.getText().toString());
                student.setDept(dept.getText().toString());
                student.setPhone(phone.getText().toString());
                student.setRoll(Integer.parseInt(roll.getText().toString()));
                if(gender.isChecked())
                    student.setGender("FEMALE");
                else
                    student.setGender("MALE");
                realm.commitTransaction();
        }
        catch (Exception ex)
        {
            realm.cancelTransaction();
            Toast.makeText(this, "Failure"+ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void onDisplayButtonPressed(View view)
    {
        Intent intent=new Intent(this,DisplayActivity.class);
        startActivity(intent);
    }
}
