package com.example.android.parent;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("diksha://play"));
            intent.putExtra("result", "Hello from parent");
            try {
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, 101);
                }
            } catch (ActivityNotFoundException e) {
                Log.e("ERROR", e.toString());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("result", String.valueOf(requestCode));
        Log.d("result", String.valueOf(resultCode));
        if (data != null) {
            Log.d("result", String.valueOf(data));
            Log.d("result", data.getExtras().getString("result"));
        }


    }
}