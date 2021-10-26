package ru.mrroot.translator.data.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.mrroot.translator.data.word.Word

interface SkyEngApi {
    @GET("/api/public/v1/words/search")
    fun getTranslationByWord(@Query("search") searchWord: String): Single<List<Word>>
}