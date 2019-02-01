package com.example.xdd.urdress_v1.ApiDressWeb.modelo.ApiWebSoap;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import com.sinch.verification.CodeInterceptionException;
import com.sinch.verification.InitiationResult;
import com.sinch.verification.InvalidInputException;
import com.sinch.verification.ServiceErrorException;
import com.sinch.verification.VerificationListener;

public class MyVerificationListener implements VerificationListener {
    private Context context;

    public MyVerificationListener(Context context){
        this.context=context;
    }

    @Override
    public void onInitiated(InitiationResult initiationResult) {    }

    @Override
    public void onInitiationFailed(Exception e) {
        if (e instanceof InvalidInputException) {
            Toast.makeText(context,"Incorrect number provided",Toast.LENGTH_LONG).show();
        } else if (e instanceof ServiceErrorException) {
            Toast.makeText(context,"Sinch service error",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context,"Other system error, check your network state", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onVerified() {
        new AlertDialog.Builder(context)
                .setMessage("Verificacion Correcta")
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.cancel();
                    }
                })
                .show();
    }

    @Override
    public void onVerificationFailed(Exception e) {
        if (e instanceof CodeInterceptionException) {
            Toast.makeText(context,"Intercepting the verification call automatically failed",Toast.LENGTH_LONG).show();
        } else if (e instanceof ServiceErrorException) {
            Toast.makeText(context, "Sinch service error",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context,"Other system error, check your network state", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onVerificationFallback() {

    }

}
