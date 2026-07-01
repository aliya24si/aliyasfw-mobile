package com.example.aliya_lilac.utils

import android.app.TaskStackBuilder
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.aliya_lilac.DaftarPengaduanActivity

class ReminderReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val title   = intent.getStringExtra("title") ?: "Pengingat Bina Desa"
        val message = intent.getStringExtra("message") ?: "Waktunya melakukan pengecekan"

        // 1. Buat intent biasa menuju target Activity
        val targetIntent = Intent(context, DaftarPengaduanActivity::class.java)

        // 2. Bungkus dengan TaskStackBuilder agar Android mengenali alur halaman dengan aman
        val pendingIntent = TaskStackBuilder.create(context).run {
            addNextIntentWithParentStack(targetIntent)
            getPendingIntent(
                System.currentTimeMillis().toInt(),
                android.app.PendingIntent.FLAG_UPDATE_CURRENT or android.app.PendingIntent.FLAG_IMMUTABLE
            )
        }

        // 3. Kita kirim langsung pendingIntent yang sudah aman ke helper baru kita
        NotificationHelper.showNotificationWithPendingIntent(
            context = context,
            title = title,
            message = message,
            pendingIntent = pendingIntent
        )
    }
}