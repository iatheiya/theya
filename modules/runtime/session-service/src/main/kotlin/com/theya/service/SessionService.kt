package com.theya.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SessionService : Service() {

    @Inject
    lateinit var lifecycleController: LifecycleController

    @Inject
    lateinit var binder: ServiceBinder

    override fun onCreate() {
        super.onCreate()
        binder.setService(this)
        lifecycleController.startForeground(this)
    }

    override fun onBind(intent: Intent?): IBinder {
        return binder
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleController.stop()
    }
}
