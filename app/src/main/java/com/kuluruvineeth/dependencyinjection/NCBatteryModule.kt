package com.kuluruvineeth.dependencyinjection

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class NCBatteryModule {
    @Binds
    abstract fun bindsNCBattery(nickelCadmiumBattery: NickelCadmiumBattery):Battery
}