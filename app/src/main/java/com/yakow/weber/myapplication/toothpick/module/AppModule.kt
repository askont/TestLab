package com.yakow.weber.myapplication.toothpick.module

import android.content.Context
import com.yakow.weber.myapplication.model.data.storage.db.AppDatabase
import com.yakow.weber.myapplication.model.data.storage.db.dao.JokesDao
import com.yakow.weber.myapplication.model.data.storage.prefs.AppPrefs
import com.yakow.weber.myapplication.model.data.storage.prefs.PrefsProvider
import com.yakow.weber.myapplication.toothpick.provider.AppDatabaseProvider
import com.yakow.weber.myapplication.toothpick.provider.JokeDaoProvider
import com.yakow.weber.myapplication.toothpick.system.ResourceManager
import com.yakow.weber.myapplication.toothpick.system.executor.AppExecutors
import com.yakow.weber.myapplication.toothpick.system.executor.ExecutorsProvider
import com.yakow.weber.myapplication.toothpick.system.message.SystemMessageNotifier
import com.yakow.weber.myapplication.toothpick.system.schedulers.AppSchedulers
import com.yakow.weber.myapplication.toothpick.system.schedulers.SchedulersProvider
import timber.log.Timber
import toothpick.config.Module

/**
 * Created on 05.02.19
 * @author YWeber */

class AppModule (context: Context) : Module() {
    init {
        Timber.d("init app module")
        bind(Context::class.java).toInstance(context)
        bind(ResourceManager::class.java).toInstance(ResourceManager(context))
        bind(SchedulersProvider::class.java).toInstance(AppSchedulers())
        bind(ExecutorsProvider::class.java).toInstance(AppExecutors())
        bind(PrefsProvider::class.java).to(AppPrefs::class.java).singletonInScope()
        bind(SystemMessageNotifier::class.java).toInstance(SystemMessageNotifier())
        Timber.d("Creating Database...")
        bind(AppDatabase::class.java).toProvider(AppDatabaseProvider::class.java).providesSingletonInScope()
        bind(JokesDao::class.java).toProvider(JokeDaoProvider::class.java).providesSingletonInScope()
    }
}