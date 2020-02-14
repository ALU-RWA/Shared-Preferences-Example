# Shared-Preferences-Example
This is an example of an app that uses Shared Preferences. When a user enters the login details, after closing the app and the user want to access the app again, the login details will have been saved.
package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button b1;
    TextView name, phone, email;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);

        b1=(Button)findViewById(R.id.button);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
         GetSavedData();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               saveData();
                Toast.makeText(MainActivity.this,"Content Saved",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void saveData(){
        String n  = ed1.getText().toString();
        String ph  = ed2.getText().toString();
        String e  = ed3.getText().toString();

        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putString(Name, n);
        editor.putString(Phone, ph);
        editor.putString(Email, e);
        editor.commit();
    }
    public void GetSavedData(){
        if(sharedpreferences.contains(Name)){
            String tvName = sharedpreferences.getString(Name,"");
            String tvEmail = sharedpreferences.getString(Email,"");
            String tvPhoneNo = sharedpreferences.getString(Phone,"");
            ed1.setText(tvName);
            ed2.setText(tvEmail);
            ed3.setText(tvPhoneNo);
        }
    }

}
