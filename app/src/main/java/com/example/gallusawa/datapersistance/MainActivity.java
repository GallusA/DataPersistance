package com.example.gallusawa.datapersistance;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String MY_PREF_FILE = "mypref_file";
    EditText etVal1, etVal2;
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etVal1 = (EditText) findViewById(R.id.etVal1);
        etVal2 = (EditText) findViewById(R.id.etVal2);


    }

    public void saveData(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("value1", etVal1.getText().toString());
        editor.putString("value2", etVal2.getText().toString());
        editor.commit();

        Intent intent  = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    public void getData(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);

        sharedPreferences.getString("value1", "default in case this key returns nothing");
        sharedPreferences.getString("value2", "default in case this key returns nothing");

        Log.d(TAG, "getData: " + sharedPreferences.getString("value1", "default") + sharedPreferences.getString("value2", "default"));

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Log.d(TAG, "onConfigurationChanged: ");

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
            Toast.makeText(this, "Landscape", Toast.LENGTH_SHORT).show();

        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
            Toast.makeText(this, "Portrait", Toast.LENGTH_SHORT).show();
    }

    public void goToNextActivity(View view) {

        switch (view.getId()){

            case R.id.btnSaveData:
                SharedPreferences sharedPreferences = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
                Intent intent = new Intent(this, Main2Activity.class);
/*
                intent.putExtra("savedData",sharedPreferences.getString("value1", "default in case this key returns nothing") +
                        sharedPreferences.getString("value2", "default in case this key returns nothing"));
*/
                startActivity(intent);
                break;
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}

