package ru.mrroot.translator.presenter

import android.app.Activity

interface BasePresenter {
    fun attachActivity(activity: Activity)
    fun detachActivity()
    fun getTranslation(searchWord: String)
}