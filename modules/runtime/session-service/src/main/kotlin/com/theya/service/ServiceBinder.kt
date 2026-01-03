package com.theya.service

import android.os.Binder
import javax.inject.Inject

class ServiceBinder @Inject constructor() : Binder() {
    fun getService(): SessionService {
        // Return service instance or interface
        return SessionService() 
    }
}
