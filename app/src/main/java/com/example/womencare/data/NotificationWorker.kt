package com.example.womencare.data

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresPermission
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.womencare.R
import java.util.concurrent.TimeUnit

/*

class NotificationWorker(
    ctx: Context,
    params: WorkerParameters
) : Worker(ctx, params) {

    @RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
    override fun doWork(): Result {
        sendNotification("Screening Reminder", "You're due for a cervical screening. Stay healthy!")
        return Result.success()
    }

    @RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
    private fun sendNotification(title: String, message: String) {
        val channelId = "screening_channel"
        val notificationId = 1

        val manager = NotificationManagerCompat.from(applicationContext)

        // Create notification channel if needed
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Screening Reminders",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel.description = "Reminders for cervical screening"
            manager.createNotificationChannel(channel)
        }

        val builder = NotificationCompat.Builder(applicationContext, channelId)
            .setSmallIcon(R.drawable.ic_notification) // Your app's notification icon
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)

        manager.notify(notificationId, builder.build())
    }
}

fun scheduleScreeningReminder(context: Context, delayDays: Long) {
    val work = OneTimeWorkRequestBuilder<NotificationWorker>()
        .setInitialDelay(delayDays, TimeUnit.DAYS)
        .build()

    WorkManager.getInstance(context).enqueue(work)
}
*/
