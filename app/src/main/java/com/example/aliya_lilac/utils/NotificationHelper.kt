package com.example.aliya_lilac.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

object NotificationHelper {

    private const val CHANNEL_ID = "default_channel"

    fun showNotification(
        context: Context,
        title: String,
        message: String,
        intent: Intent
    ) {
        val manager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "General",
                NotificationManager.IMPORTANCE_HIGH
            )
            manager.createNotificationChannel(channel)
        }

        val pending = PendingIntent.getActivity(
            context,
            System.currentTimeMillis().toInt(), // Gunakan ID unik agar intent tidak tertimpa
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            // Menggunakan icon bawaan sistem android agar tidak merah/eror
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle(title)
            .setContentText(message)
            .setAutoCancel(true)
            .setContentIntent(pending)
            .build()

        manager.notify(System.currentTimeMillis().toInt(), notification)
    }

    // Tambahkan fungsi baru ini di bawah fungsi showNotification yang lama
    fun showNotificationWithPendingIntent(
        context: Context,
        title: String,
        message: String,
        pendingIntent: android.app.PendingIntent
    ) {
        val manager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "General",
                NotificationManager.IMPORTANCE_HIGH
            )
            manager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle(title)
            .setContentText(message)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent) // Langsung pakai pendingIntent yang aman dari Receiver
            .build()

        manager.notify(System.currentTimeMillis().toInt(), notification)
    }
}