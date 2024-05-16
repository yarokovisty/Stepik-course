package com.example.dagger.example1

import javax.inject.Inject

class Computer @Inject constructor(
    val monitor: Monitor,
    val computerTower: ComputerTower,
    val keyboard: Keyboard,
    val mouse: Mouse
)