package com.example.a109590015_hw12_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private NotificationManager nManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, NReceiver.class);
        ToggleButton btn = findViewById(R.id.toggleButton);
        final boolean alarm = (PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_NO_CREATE) != null);
        btn.setChecked(alarm);

        final PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        final AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    if(alarmManager != null) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.HOUR, 11);
                        calendar.set(Calendar.MINUTE, 11);
                        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                        Toast.makeText(MainActivity.this, "on", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    if(alarmManager != null) {
                        alarmManager.cancel(pendingIntent);
                        nManager.cancelAll();
                    }
                }
            }
        });
        nManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        createNotificationChannel();
    }

    private void createNotificationChannel() {
        nManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel("channel", "notification", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.WHITE);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Notify at 11:11");
            nManager.createNotificationChannel(notificationChannel);
        }
    }
}