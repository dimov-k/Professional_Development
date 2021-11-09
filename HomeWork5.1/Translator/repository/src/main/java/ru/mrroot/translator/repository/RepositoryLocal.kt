package ru.mrroot.translator.repository

import ru.mrroot.translator.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {
    suspend fun saveToDB(appState: AppState)
    suspend fun getAllData(): T
}