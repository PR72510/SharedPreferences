package com.example.login_module;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class targetActivity extends Activity {
    public static final String MY_PREFERENCES = "Shared_Prefs";
    Button btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        btnLogout = findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(MY_PREFERENCES, MODE_PRIVATE);
                sharedPreferences.edit().clear().apply();       // apply() is faster than commit(), it does not return any boolean,
                callFirstActivity();
            }
        });

        Bundle extras = getIntent().getExtras();
        String value1 = extras.getString("Value1");
        String value2 = extras.getString("Value2");

        Toast.makeText(getApplicationContext(),"Welcome\n Email: "+value1+
                "\n Password: "+value2, Toast.LENGTH_LONG).show();
    }
    public void callFirstActivity(){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
}
