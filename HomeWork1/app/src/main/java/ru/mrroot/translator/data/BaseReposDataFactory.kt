package ru.mrroot.translator.data

import ru.mrroot.translator.data.api.SkyEngApiFactory

object BaseReposDataFactory {
    fun create(): BaseReposData =
        BaseReposDataImpl(
            SkyEngApiFactory.create()
        )
}