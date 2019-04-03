package com.rishabh.focusd.Phone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rishabh.focusd.R;
import com.rishabh.focusd.Util.Theme;

public class Phone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(Theme.getTheme());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
    }
}
