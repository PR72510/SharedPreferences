package com.example.login_module;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String MY_PREFERENCES = "Shared_Prefs";
    String str_email, str_pass;
    String email, pass;
     EditText editText1, editText2;
    Button b_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.email_ET);
        editText2 = findViewById(R.id.pass_ET);
        b_login = findViewById(R.id.login);

        b_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email, pass;
                email = editText1.getText().toString();
                pass = editText2.getText().toString();

                loginCheck(email, pass);
            }
        });
        loadData();
        updateViews();
    }

    public void loginCheck(String email, String pass){
        if(!(email.isEmpty() || pass.isEmpty())){
            saveData(email, pass);
            Intent intent = new Intent(MainActivity.this, targetActivity.class);
            intent.putExtra("Value1", email);
            intent.putExtra("value2", pass);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(), "Enter Credentials", Toast.LENGTH_LONG).show();
        }
    }

    private void saveData(String email, String pass) {
        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Email", email);
        editor.putString("Password", pass);
        editor.apply();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREFERENCES, MODE_PRIVATE);
        str_email = sharedPreferences.getString("Email", "");
        str_pass = sharedPreferences.getString("Password", "");
    }

    public void updateViews(){
        editText1.setText(str_email);
        editText2.setText(str_pass);
    }


}


