package com.kuluruvineeth.dependencyinjection

import dagger.Component

@Component
interface SmartPhoneComponent {

    fun getSmartPhone() : SmartPhone
}