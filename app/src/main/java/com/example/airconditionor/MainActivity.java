package com.example.airconditionor;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView temperatured;
    private int temperature = 24;
    private boolean isOn = true;
    private final int MAX_TEMPERATURE = 30;
    private final int MIN_TEMPERATURE = 16;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperatured = findViewById(R.id.temperatured);
        Button buttonIncrease = findViewById(R.id.buttonpluss);
        Button buttonminus = findViewById(R.id.buttonminus);
        Button buttonOnOff = findViewById(R.id.buttonOnOff);


        updateTemperatureDisplay();
        buttonOnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOn = !isOn;
                updateTemperatureDisplay();
            }
        });

        buttonIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOn && temperature < MAX_TEMPERATURE) {
                    temperature++;
                    updateTemperatureDisplay();
                }
            }
        });

        buttonminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOn && temperature > MIN_TEMPERATURE) {
                    temperature--;
                    updateTemperatureDisplay();
                }
            }
        });
    }

    private void updateTemperatureDisplay() {
        if (isOn) {
            temperatured.setText(String.valueOf(temperature));
        } else {
            temperatured.setText("OFF");
        }
    }
}
