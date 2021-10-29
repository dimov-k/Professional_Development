package ru.mrroot.translator

import android.app.Application
import ru.mrroot.translator.data.BaseReposData
import ru.mrroot.translator.data.BaseReposDataFactory
import ru.mrroot.translator.presenter.BasePresenter
import ru.mrroot.translator.presenter.MainPresenter
import ru.mrroot.translator.scheduler.SchedulersFactory

class App : Application() {
    lateinit var dataRepos: BaseReposData
    lateinit var mainPresenter: BasePresenter

    override fun onCreate() {
        super.onCreate()
        instance = this
        dataRepos = BaseReposDataFactory.create()
        mainPresenter = MainPresenter(dataRepos, SchedulersFactory.create())
    }

    companion object {
        lateinit var instance: App
            private set
    }
}