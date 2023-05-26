package com.example.mobdev9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mobdev9.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(this.getLayoutInflater());

        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = binding.editTxt.getText().toString();
                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                sendIntent.putExtra(Intent.EXTRA_TEXT,str);
                startActivity(sendIntent);
            }
        });

        setContentView(binding.getRoot());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        String data = intent.getStringExtra(Intent.EXTRA_TEXT);
        Log.i("gg",String.valueOf(data));
        binding.txt.setText(String.valueOf(data));
    }
}