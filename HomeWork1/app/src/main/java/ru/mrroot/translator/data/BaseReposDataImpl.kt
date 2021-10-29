package ru.mrroot.translator.data

import io.reactivex.Single
import ru.mrroot.translator.data.api.SkyEngApi
import ru.mrroot.translator.data.word.Word

class BaseReposDataImpl(private val skyEngApi: SkyEngApi) : BaseReposData {
    override fun returnTranslation(searchWord: String): Single<List<Word>> =
        skyEngApi.getTranslationByWord(searchWord)
}