package com.home.bel.feedbacktrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.home.bel.feedbacktrack.ui.MainFragment;
import com.home.bel.feedbacktrack.ui.StartFragment;
import com.home.bel.feedbacktrack.ui.StartFragment_;

import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements StartFragment.LoginButtonHandler {

    private static final String TAG = "Debug_MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .add(R.id.mainFrameLayout, new StartFragment_(), "FRAGMENT_START_TAG")
                .commit();

    }


    @Override
    public void signIn() {

        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.mainFrameLayout, new MainFragment(), "FRAGMENT_MAIN_TAG")
                .commit();

    }

    @Override
    public void signUp() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "There is some result returned for an Activity!");

        Fragment fragment = getSupportFragmentManager().findFragmentByTag("FRAGMENT_MAIN_TAG");
        if (fragment != null) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }
}
