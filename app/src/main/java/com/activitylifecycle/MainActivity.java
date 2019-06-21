package com.activitylifecycle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.DragStartHelper;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    AlertDialog.Builder builder;
    Button nextscreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lifecycle", "oncreate invoked");


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
        button = (Button) findViewById(R.id.bNext);
        nextscreen = findViewById(R.id.bNextscreen);
        nextscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this ,CustomDialogActivity.class);
                startActivity(intent);
            }
        });
         builder = new AlertDialog.Builder(this);
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 final ProgressDialog obj1=new ProgressDialog(MainActivity.this);
                 obj1.setMessage("Loading....");
                 obj1.show();
                 new Handler().postDelayed(new Runnable() {
                                               @Override
                                               public void run() {
                                                   obj1.dismiss();
                                               }
                                           }, 5000);

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

                         });
                 AlertDialog aaa =builder.create();
                 aaa.setTitle("Your activity ");
                 aaa.show();


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
