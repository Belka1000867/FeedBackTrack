package com.home.bel.feedbacktrack.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.zxing.Result;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.home.bel.feedbacktrack.R;

import org.androidannotations.annotations.EFragment;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

@EFragment(R.layout.fragment_main)
public class MainFragment extends Fragment{

    private static final String TAG = "Debug_MainFragment";
    
    IntentIntegrator intentIntegrator;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        intentIntegrator = new IntentIntegrator(getActivity());
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
//        intentIntegrator.setPrompt("Scan");
        intentIntegrator.setOrientationLocked(false);
        intentIntegrator.setCameraId(0);
        intentIntegrator.setBeepEnabled(true);
        intentIntegrator.setBarcodeImageEnabled(false);
        intentIntegrator.initiateScan();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "Result is ready in the activity! Let's show it!");

        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        String scanData = (scanningResult != null) ? scanningResult.getContents() : "";

        if (scanData == null || scanData.isEmpty()) {
            Toast.makeText(getActivity(), "Scan complete, no data", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getActivity(), scanData, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }



}
