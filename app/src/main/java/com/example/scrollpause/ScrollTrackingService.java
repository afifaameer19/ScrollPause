package com.example.scrollpause;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;

import androidx.core.app.NotificationCompat;

public class ScrollTrackingService extends Service {

    private static final String CHANNEL_ID = "scroll_pause_channel";
    private static final int FOREGROUND_ID = 1;
    private static final int REMINDER_ID = 2;

    // 10 seconds demo delay
    private static final long DEMO_DELAY = 10_000;

    private Handler handler;

    @Override
    public void onCreate() {
        super.onCreate();

        handler = new Handler(Looper.getMainLooper());
        createNotificationChannel();

        // Start foreground service (required)

        // Schedule demo reminder after 10 seconds
        handler.postDelayed(this::showReminderNotification, DEMO_DELAY);
    }

    private void showReminderNotification() {

        // Intent when user taps notification → open game
        Intent intent = new Intent(this, TicTacToeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Time to pause ⏸")
                .setContentText("You’ve been scrolling for a while. Let’s play a quick game!")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_REMINDER)
                .setAutoCancel(true)
                .setContentIntent(
                        android.app.PendingIntent.getActivity(
                                this,
                                0,
                                intent,
                                Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
                                        ? android.app.PendingIntent.FLAG_UPDATE_CURRENT | android.app.PendingIntent.FLAG_MUTABLE
                                        : android.app.PendingIntent.FLAG_UPDATE_CURRENT
                        )
                )
                .build();

        NotificationManager manager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (manager != null) {
            manager.notify(REMINDER_ID, notification);
        }

        // Stop service after showing reminder
        stopSelf();
    }

    private Notification createForegroundNotification() {
        return new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("ScrollPause running")
                .setContentText("Helping you take mindful breaks")
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "ScrollPause Notifications",
                    NotificationManager.IMPORTANCE_HIGH
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager != null) {
                manager.createNotificationChannel(channel);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
