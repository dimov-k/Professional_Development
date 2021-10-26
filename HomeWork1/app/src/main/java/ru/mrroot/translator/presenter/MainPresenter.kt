package ru.mrroot.translator.presenter

import android.app.Activity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import ru.mrroot.translator.data.BaseReposData
import ru.mrroot.translator.scheduler.Schedulers
import ru.mrroot.translator.view.BaseView
import ru.mrroot.translator.view.MainActivity
import ru.mrroot.translator.view.TranslationViewModel.Mapper

class MainPresenter(
    private val dataRepos: BaseReposData,
    private val schedulers: Schedulers
) : BasePresenter {
    private var mainActivity: BaseView? = null
    private var disposable = CompositeDisposable()

    override fun attachActivity(activity: Activity) {
        mainActivity = activity as MainActivity
    }

    override fun detachActivity() {
        mainActivity = null
    }

    override fun getTranslation(searchWord: String) {
        disposable += dataRepos
            .returnTranslation(searchWord)
            .observeOn(schedulers.background())
            .map {
                it[0].meanings.map(Mapper::map)
            }
            .observeOn(schedulers.main())
            .subscribeOn(schedulers.background())
            .subscribe(
                {
                    mainActivity?.setTranslationsForSearchWord(it)
                },
                {
                    mainActivity?.showError(it)
                }
            )
    }

}