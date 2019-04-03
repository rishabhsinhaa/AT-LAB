package com.rishabh.focusd.Music;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rharshit.focusd.R;
import com.rishabh.focusd.Util.Theme;

public class Music extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(Theme.getTheme());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
    }
}
