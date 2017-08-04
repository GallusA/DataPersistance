package com.example.gallusawa.datapersistance;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String MY_PREF_FILE = "mypref_file";
    private static final String TAG = "Main";
    EditText editText, editText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.etVal1);
        editText2 = (EditText) findViewById(R.id.etVal2);


    }
    public void saveData(View view){
        SharedPreferences sharedPrefernces = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefernces.edit();

         editor.putString("value", editText.getText().toString());
        editor.putString("value2", editText2.getText().toString());
        editor.commit();

    }
    public void getData(View view){
        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
        Log.d(TAG, "getData" + sharedPreferences.getString("value", "defaut"));
        Log.d(TAG, "getData: ");
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

}
