package com.rasifara.notificationdemo.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.content.getSystemService

class NotificationUtil {

    fun createInboxStyleNotificationChannel(context: Context) : String {

        // NotificationChannels are required for Notifications on O (API 26) and above.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channelId : String = InboxStyleMockData.mChannelId
            val channelName: CharSequence = InboxStyleMockData.mChannelName
            val channelDescription: String = InboxStyleMockData.mChannelDescription
            val channelImportance: Int = InboxStyleMockData.mChannelImportance
            val channelEnableVibrate: Boolean = InboxStyleMockData.mChannelEnableVibrate
            val channelLockScreenVisibility: Int = InboxStyleMockData.mChannelLockscreenVisibility

            // Initialize Notification Channel
            val notificationChannel = NotificationChannel(channelId, channelName, channelImportance)
            notificationChannel.description = channelDescription
            notificationChannel.enableVibration(channelEnableVibrate)
            notificationChannel.lockscreenVisibility = channelLockScreenVisibility

            // Adds NotificationChannel to system. Attempting to create an existing notification
            // channel with its original values performs no operation, so it's safe to perform the
            // below sequence.
            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(notificationChannel)
            return channelId

        } else {
            return ""
        }
    }

    fun createBigPictureStyleNotificationChannel(context: Context) : String {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channelId : String = BigPictureStyleMockData.mChannelId
            val channelName : String = BigPictureStyleMockData.mChannelName
            // The user-visible description of the channel.
            val channelDescription: String = BigPictureStyleMockData.mChannelDescription
            val channelImportance: Int = BigPictureStyleMockData.mChannelImportance
            val channelEnableVibrate: Boolean = BigPictureStyleMockData.mChannelEnableVibrate
            val channelLockscreenVisibility: Int =
                BigPictureStyleMockData.mChannelLockscreenVisibility

            // Initializes NotificationChannel.
            val notificationChannel = NotificationChannel(channelId, channelName, channelImportance)
                notificationChannel.apply {
                    description = channelDescription
                    enableVibration(channelEnableVibrate)
                    lockscreenVisibility = channelLockscreenVisibility
                }

            // Adds NotificationChannel to system. Attempting to create an existing notification
            // channel with its original values performs no operation, so it's safe to perform the
            // below sequence.
            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(notificationChannel)
            return channelId

        } else {
            return ""
        }
    }

}