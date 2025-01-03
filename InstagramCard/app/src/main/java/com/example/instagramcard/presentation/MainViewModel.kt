package com.example.instagramcard.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _isFollowing: MutableLiveData<Boolean> = MutableLiveData()
    val isFollowing: LiveData<Boolean> = _isFollowing

    fun changeFollowingStatus() {
        val wasFollowing = _isFollowing.value ?: false
        _isFollowing.value = !wasFollowing
    }
}