package ru.mrroot.translator.repository

interface DataSource<T> {

    suspend fun getData(word: String): T
}
