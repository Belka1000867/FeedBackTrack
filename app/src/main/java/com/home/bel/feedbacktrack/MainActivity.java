package com.home.bel.feedbacktrack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.home.bel.feedbacktrack.ui.MainFragment_;

import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .add(R.id.mainFrameLayout, new MainFragment_(), "FRAGMENT_START_TAG")
                .commit();

    }



}
