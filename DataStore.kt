package com.example.firstapplication

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class DataStore(context : Context) {
    private val dataStore : DataStore<Preferences>  = context.createDataStore(name = "settings_pref")

    fun <T> getValueFlow(
        key: Preferences.Key<T>,
        defaultValue: T
    ): Flow<T> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }.map { preferences ->
                preferences[key] ?: defaultValue
            }
    }

    suspend fun <T> setValue(key: Preferences.Key<T>, value: T) {
        dataStore.edit { preferences ->
            preferences[key] = value
        }
    }

    companion object {
        val USERNAME = preferencesKey<String>("username")
        val ID = preferencesKey<Int>("id")
    }

    /* Call following methods  from view model scope / life cycle scope of fragment / activity to set/get stored value
     viewModelScope.launch {
    dataStore.getValueFlow(USERNAME, "")
        .collect { value ->
            // use the value
        }
    }
    viewModelScope.launch {
    dataStore.getValueFlow(USERNAME, "")
        .catch {
            // handle error
        }
        .collect { value ->
            // use the value
        }
    }
     */
}