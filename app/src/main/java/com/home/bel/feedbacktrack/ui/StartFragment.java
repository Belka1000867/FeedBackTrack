package com.home.bel.feedbacktrack.ui;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.home.bel.feedbacktrack.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.fragment_start)
public class StartFragment extends Fragment {

    private static final String TAG = "Debug_StartFragment";

    private LoginButtonHandler loginButtonHandlerActivity;

    public interface LoginButtonHandler{

        void signIn();

        void signUp();

    }

    @Click(R.id.signin)
    void signIn(){

        Log.d(TAG, "signIn()");

        if(loginButtonHandlerActivity != null){
            loginButtonHandlerActivity.signIn();
        }

    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try {
            loginButtonHandlerActivity = (LoginButtonHandler) context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
