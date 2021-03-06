package com.example.shridharmali.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("onCreate()", "onCreate Involved");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart()", "onStart Involved");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume", "onResume Involved");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause()", "onPause Involved");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("onStop", "onStop Involved");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("onStop", "onStop Involved");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy", "onDestroy Involved");
    }
}
