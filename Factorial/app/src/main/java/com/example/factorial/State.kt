package com.example.factorial

sealed class State {

    data object Error: State()

    data object Progress: State()

    data class Result(val factorial: String): State()
}
