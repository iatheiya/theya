package com.theya.datastore

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    val settings: Flow<SettingsPreferences>
    suspend fun updateRefreshRate(ms: Int)
    suspend fun setTopBarVisible(isVisible: Boolean)
    suspend fun setBottomBarVisible(isVisible: Boolean)
    suspend fun setThemeMode(mode: String)
    suspend fun setBlurMode(mode: String)
}
