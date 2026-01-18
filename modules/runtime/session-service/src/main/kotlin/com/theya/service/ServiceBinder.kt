package com.theya.service

import android.os.Binder
import javax.inject.Inject

class ServiceBinder @Inject constructor() : Binder() {
    private var serviceInstance: SessionService? = null

    fun setService(service: SessionService) {
        serviceInstance = service
    }

    fun getService(): SessionService? {
        return serviceInstance
    }
}
