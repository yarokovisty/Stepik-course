package com.example.dagger.example1

import javax.inject.Inject

class Activity {

    @Inject
    lateinit var computer: Computer

    init {
        DaggerNewComponent.create().inject(this)
    }
}