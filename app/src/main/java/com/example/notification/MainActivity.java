package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1;
    NotificationManager nm;
    public final String NOTIFICATION_ID="1";
    public final String NOTIFICATION_NAME="Example";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.notify);
        nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            createNotificationChannel();
        }


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                PendingIntent i=PendingIntent.getActivity(getApplicationContext(),0,intent,0);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), NOTIFICATION_ID)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle("Android Practical")
                        .setContentText("You have successfully got a Notification...........")
                        .setDefaults(Notification.DEFAULT_ALL)
//                        .setTicker("Hello")
                        .setColor(1234)
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .setContentIntent(i);
                nm.notify(1,builder.build());
            }
        });

    }

    private void createNotificationChannel() {
        NotificationChannel nc=new NotificationChannel(NOTIFICATION_ID,NOTIFICATION_NAME,NotificationManager.IMPORTANCE_HIGH);
        nc.enableVibration(true);
        nm.createNotificationChannel(nc);

    }
}