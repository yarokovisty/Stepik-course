package com.example.factorial

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.math.BigInteger

class MainViewModel : ViewModel() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main + CoroutineName("My coroutine scope"))

    private val _state = MutableLiveData<State>()
    val state: LiveData<State>
        get() = _state


    fun calculate(value: String?) {
        _state.value = State.Progress
        if (value.isNullOrBlank()) {
            _state.value = State.Error
            return
        }

        coroutineScope.launch {
            val number = value.toLong()
            // calculate
            delay(1000)
            _state.value = State.Result(factorial(number))
            Log.d("MyLog", coroutineContext.toString())
        }

    }

    private suspend fun factorial(number: Long): String {
        return withContext(Dispatchers.Default) {
            var result = BigInteger.ONE
            for (i in 1..number) {
                result = result.multiply(BigInteger.valueOf(i))
            }
            result.toString()
        }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}