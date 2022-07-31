package com.kuluruvineeth.dependencyinjection

import dagger.Component

@Component(modules = [MemoryCardModule::class])
interface SmartPhoneComponent {

    fun getSmartPhone() : SmartPhone
}