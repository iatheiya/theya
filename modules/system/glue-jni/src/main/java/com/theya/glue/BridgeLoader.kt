package com.theya.glue

import android.content.Context

class BridgeLoader(private val context: Context) {
    fun load() {
        try {
            NativeBridge.initEngine()
        } catch (e: UnsatisfiedLinkError) {
            e.printStackTrace()
        }
    }
}
