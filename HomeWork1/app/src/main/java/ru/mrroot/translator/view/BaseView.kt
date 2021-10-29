package ru.mrroot.translator.view

interface BaseView {
    fun setTranslationsForSearchWord(translations: List<TranslationViewModel>)
    fun showError(error: Throwable)
}