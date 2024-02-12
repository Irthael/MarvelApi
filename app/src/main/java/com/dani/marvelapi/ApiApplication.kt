package com.dani.marvelapi

import android.app.Application
import com.dani.marvelapi.di.mycharacters.CharactersComponent
import com.dani.marvelapi.di.mycharacters.DaggerCharactersComponent

open class ApiApplication : Application() {

    lateinit var charactersComponent: CharactersComponent
        private set

    override fun onCreate() {
        super.onCreate()
        //charactersComponent = DaggerCharactersComponent.factory().create(this)
        charactersComponent = DaggerCharactersComponent.factory().create(this)
    }
}
