package com.dharani.notificationdemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //add ButterKnife
        ButterKnife.inject(MainActivity.this);
    }
    @OnClick(R.id.button)
    public void sendNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(android.R.drawable.ic_dialog_alert);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/guide/topics/ui/notifiers/notifications.html"));

        //PendingIntent used to specific time send a notification
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        builder.setContentIntent(pendingIntent);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
        builder.setContentTitle("Title");
        builder.setContentText("Notification message");
        builder.setSubText("Tap to view the website.");

        //Use with getSystemService(Class ) to retrieve a NotificationManager for informing the user of background events.
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1,builder.build());
    }

    @OnClick(R.id.button2)
    public void cancelNotification(){
        String str = Context.NOTIFICATION_SERVICE;
        NotificationManager manager = (NotificationManager) getApplicationContext().getSystemService(str);
        manager.cancel(1);
    }
}
