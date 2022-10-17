package com.example.vibration;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationAttributes;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import android.view.View;
import android.widget.Toast;

import com.example.vibration.databinding.ActivityMainBinding;

public
class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);;
    @Override
    protected
    void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.VibrationOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public
            void onClick(View view)
                {
                    try {
                        vibrator.vibrate(5000);
                    }catch (Exception e){
                        Toast.makeText(MainActivity.this, "On Failure", Toast.LENGTH_SHORT).show();

                    }
                 }


        });
        binding.VibrationOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public
            void onClick(View view)
                {
                    try {
                        vibrator.cancel();
                        Toast.makeText(MainActivity.this, "Vibration OFF", Toast.LENGTH_SHORT).show();
                    }catch (Exception exception){
                        Toast.makeText(MainActivity.this, "On Failure: Vibration OFF", Toast.LENGTH_SHORT).show();
                    }
                }
        });

        }
}