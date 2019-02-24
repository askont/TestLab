package com.yakow.weber.myapplication.toothpick.module

import android.content.Context
import com.yakow.weber.myapplication.model.data.storage.prefs.AppPrefs
import com.yakow.weber.myapplication.model.data.storage.prefs.PrefsProvider
import com.yakow.weber.myapplication.toothpick.system.ResourceManager
import com.yakow.weber.myapplication.toothpick.system.message.SystemMessageNotifier
import com.yakow.weber.myapplication.toothpick.system.schedulers.AppSchedulers
import com.yakow.weber.myapplication.toothpick.system.schedulers.SchedulersProvider
import timber.log.Timber
import toothpick.config.Module

/**
 * Created on 05.02.19
 * @author YWeber
 * project totdesigner */

class AppModule (context: Context) : Module() {
    init {
        Timber.d("init app module")
        bind(Context::class.java).toInstance(context)
        bind(ResourceManager::class.java).toInstance(ResourceManager(context))
        bind(SchedulersProvider::class.java).toInstance(AppSchedulers())
        bind(PrefsProvider::class.java).to(AppPrefs::class.java).singletonInScope()
        bind(SystemMessageNotifier::class.java).toInstance(SystemMessageNotifier())
    }
}