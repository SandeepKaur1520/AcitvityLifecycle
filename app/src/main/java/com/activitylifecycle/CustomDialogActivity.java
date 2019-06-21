package com.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomDialogActivity extends AppCompatActivity {
    Button button;
    Button button1;
    Button bclose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityalert);
        Log.d("Lifecycle", "oncreate invoked");
        bclose =findViewById(R.id.bclose);
        final ProgressDialog obj1=new ProgressDialog(CustomDialogActivity.this);
        obj1.setCancelable(false);
        obj1.setMessage("Loading....");
        obj1.show();
        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          obj1.dismiss();
                                      }
                                  },5000);


       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CustomDialogActivity.this ,MainActivity.class);
                startActivity(intent);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CustomDialogActivity.this ,MainActivity.class);
                startActivity(intent);
            }
        });*/

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Start","Start done");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("Restart","Restart done");

    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Resume", "Resume done");
       /* button = (Button) findViewById(R.id.btn_yes);
        button1 = (Button) findViewById(R.id.btn_no);*/
        bclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(CustomDialogActivity.this);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.activity_custom_dialog);
                dialog.setTitle("Exit ?");
                Button dialogButton = (Button) dialog.findViewById(R.id.btn_yes);
                Button dialogButton1 = (Button) dialog.findViewById(R.id.btn_no);
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        finish();
                    }
                });
                dialogButton1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Pause", "Pause done");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Stop", "Stop done");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Destroy", "Destroy done");
    }
}



 /*button = (Button) findViewById(R.id.bNext);
         builder = new AlertDialog.Builder(this);
         button.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        builder.setMessage("Do you want to close this application ?")
        .setCancelable(false)
        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int id) {
        finish();
        Toast.makeText(getApplicationContext(), "you choose yes action for alertbox",
        Toast.LENGTH_SHORT).show();
        }
        })
        .setNegativeButton("No", new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int id) {
        //  Action for 'NO' Button
        dialog.cancel();
        Toast.makeText(getApplicationContext(), "you choose no action for alertbox",
        Toast.LENGTH_SHORT).show();
        }

        });*/