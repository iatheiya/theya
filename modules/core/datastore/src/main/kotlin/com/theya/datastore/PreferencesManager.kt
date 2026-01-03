package com.theya.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject
import androidx.datastore.core.Serializer

class PreferencesManager @Inject constructor(
    private val dataStore: DataStore<SettingsPreferences>
) : SettingsRepository {

    override val settings: Flow<SettingsPreferences> = dataStore.data

    override suspend fun updateRefreshRate(ms: Int) {
        dataStore.updateData { it.toBuilder().setRefreshRateMs(ms).build() }
    }

    override suspend fun setTopBarVisible(isVisible: Boolean) {
        dataStore.updateData { it.toBuilder().setIsTopBarVisible(isVisible).build() }
    }

    override suspend fun setBottomBarVisible(isVisible: Boolean) {
        dataStore.updateData { it.toBuilder().setIsBottomBarVisible(isVisible).build() }
    }

    override suspend fun setThemeMode(mode: String) {
        dataStore.updateData { it.toBuilder().setThemeMode(mode).build() }
    }

    override suspend fun setBlurMode(mode: String) {
        dataStore.updateData { it.toBuilder().setBlurMode(mode).build() }
    }
}

object SettingsSerializer : Serializer<SettingsPreferences> {
    override val defaultValue: SettingsPreferences = SettingsPreferences.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): SettingsPreferences {
        return SettingsPreferences.parseFrom(input)
    }

    override suspend fun writeTo(t: SettingsPreferences, output: OutputStream) {
        t.writeTo(output)
    }
}

val Context.settingsDataStore: DataStore<SettingsPreferences> by dataStore(
    fileName = "settings.pb",
    serializer = SettingsSerializer
)
