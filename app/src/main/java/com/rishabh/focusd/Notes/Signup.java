package com.rishabh.focusd.Notes;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rishabh.focusd.Notes.db.DBHandler;
import com.rishabh.focusd.R;
import com.rishabh.focusd.Util.Theme;

public class Signup extends AppCompatActivity {

    private Context mContext;
    private EditText etUser;
    private EditText etPass;
    private EditText etConf;
    private Button signup;
    private TextView tvExisting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(Theme.getTheme());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mContext = this;

        etUser = findViewById(R.id.notes_signup_et_username);
        etPass = findViewById(R.id.notes_signup_et_password);
        etConf = findViewById(R.id.notes_signup_et_confrm);
        signup = findViewById(R.id.notes_b_signup);
        tvExisting = findViewById(R.id.notes_signup_tv_login);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = etUser.getText().toString();
                String p = etPass.getText().toString();
                createUser(u, p);
            }
        });

        tvExisting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                setResult(0, i);
                finish();
            }
        });

        getUsers();
    }

    private void createUser(String u, String p) {
        boolean res = DBHandler.insertUser(u, p);
        if(res){
            Toast.makeText(mContext,
                    "Created new user", Toast.LENGTH_SHORT).show();
            Intent i = new Intent();
            i.putExtra("username", u);
            setResult(1, i);
            finish();
        } else {
            Toast.makeText(mContext,
                    "Username already exists", Toast.LENGTH_SHORT).show();
        }
    }

    private void getUsers(){
        Cursor users = DBHandler.getAllUsers();
        while(users.moveToNext()){
            Log.d("Notes", "getUsers: " + users.getString(0));
        }
    }
}
