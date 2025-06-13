package com.example.myselfapps.view

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name="user_preference")
class DataStoreManager(context: Context) {
    private val dataStore = context.dataStore

    private val IS_ONBOARDING_COMPLETED = booleanPreferencesKey("is_onboarding_completed")

    val isOnboardingCompleted: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[IS_ONBOARDING_COMPLETED] ?:false
    }

    suspend fun setOnBoardingCompleted(completed: Boolean){
        dataStore.edit { preferences ->
            preferences[IS_ONBOARDING_COMPLETED] = completed
        }
    }
}