package com.kuluruvineeth.dependencyinjection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject lateinit var smartPhone: SmartPhone
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*DaggerSmartPhoneComponent.create()
            .inject(this)
        smartPhone.makeACallWithRecording()*/

        (application as SmartPhoneApplication).smartPhoneComponent
            .inject(this)
    }
}