package com.example.dagger.example2.data.network

import android.content.Context
import android.util.Log
import com.example.dagger.R
import com.example.dagger.example2.di.scopes.AppScope
import javax.inject.Inject
import javax.inject.Singleton


class ExampleApiService @Inject constructor(
    private val context: Context,
    private val timeMillis: Long
) {

    fun method() {
        Log.d(LOG_TAG, "ExampleApiService ${context.getString(R.string.app_name)} $timeMillis")
    }

    companion object {

        private const val LOG_TAG = "EXAMPLE_TEST"
    }
}