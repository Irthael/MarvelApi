package com.dani.apimarvel.ui.common

import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

abstract class BaseFragment: Fragment(), CoroutineScope {

    private lateinit var job: Job
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    open fun loadData() {

    }


    override fun onStart() {
        super.onStart()
        job = SupervisorJob()
        loadData()
    }

    override fun onStop() {
        job.cancel()
        super.onStop()
    }
}