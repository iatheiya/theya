package com.theya.service

import android.app.Service
import android.content.pm.ServiceInfo
import android.os.Build
import javax.inject.Inject

class LifecycleController @Inject constructor() {
    fun startForeground(service: Service) {
        val notification = SessionNotification.createNotification(service)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            service.startForeground(
                SessionNotification.NOTIFICATION_ID,
                notification,
                ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC
            )
        } else {
            service.startForeground(SessionNotification.NOTIFICATION_ID, notification)
        }
    }

    fun stop() {
    }
}
