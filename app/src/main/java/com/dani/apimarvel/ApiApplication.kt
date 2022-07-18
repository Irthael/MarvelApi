package com.dani.apimarvel

import android.app.Application
import com.dani.apimarvel.di.mycharacters.CharactersComponent
import com.dani.apimarvel.di.mycharacters.DaggerCharactersComponent

open class ApiApplication : Application() {

    lateinit var charactersComponent: CharactersComponent
        private set

    override fun onCreate() {
        super.onCreate()
        charactersComponent = DaggerCharactersComponent.factory().create(this)
    }
}
