package com.example.intencjedomniemane;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button wwwButon = findViewById(R.id.wwwButton);
        wwwButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.www);
                String adres = editText.getText().toString();

                Uri uri = Uri.parse("http://"+adres);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        Button miastoButon = findViewById(R.id.miastoButton);
        miastoButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.miasto);
                String miasto = editText.getText().toString();

                Uri uri = Uri.parse("geo:0,0?q="+miasto);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        Button lokButon = findViewById(R.id.lokButton);
        lokButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText szerokoscEdit = findViewById(R.id.szerokosc);
                String szerokosc = szerokoscEdit.getText().toString();
                EditText dlugoscEdit = findViewById(R.id.dlugosc);
                String dlugosc =dlugoscEdit.getText().toString();

                String s = String.format("geo:%s,%s", szerokosc, dlugosc);
                Uri uri = Uri.parse(s);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        Button alarmButton = findViewById(R.id.alarmButton);
        alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                        .putExtra(AlarmClock.EXTRA_HOUR, 19)
                        .putExtra(AlarmClock.EXTRA_MINUTES, 1);
                startActivity(intent);
            }
        });

        Button timerButton = findViewById(R.id.timerButton);
        timerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, "Odliczanie w dół")
                                .putExtra(AlarmClock.EXTRA_LENGTH, 10)
                                        .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
                startActivity(intent);
            }
        });

    }
}