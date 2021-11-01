package ru.mrroot.translator.data

import io.reactivex.Single
import ru.mrroot.translator.data.word.Word

interface BaseReposData {
    fun returnTranslation(searchWord: String): Single<List<Word>>
}