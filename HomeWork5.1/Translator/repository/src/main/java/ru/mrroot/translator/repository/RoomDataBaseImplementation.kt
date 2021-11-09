package ru.mrroot.translator.repository

import ru.mrroot.translator.model.data.AppState
import ru.mrroot.translator.model.data.Word
import ru.mrroot.translator.repository.room.HistoryDao

class RoomDataBaseImplementation(private val historyDao: HistoryDao) : DataSourceLocal<List<Word>> {

    override suspend fun getData(word: String): List<Word> {
        return mapHistoryEntityToSearchResult(historyDao.getDataByWord(word))
    }

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntities(appState)?.let {
            historyDao.insertAll(it)
        }
    }

    override suspend fun getAllData(): List<Word> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }
}