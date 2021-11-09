package ru.mrroot.translator.historyscreen.view.history

import ru.mrroot.translator.core.viewmodel.Interactor
import ru.mrroot.translator.model.data.AppState
import ru.mrroot.translator.model.data.Word
import ru.mrroot.translator.repository.Repository
import ru.mrroot.translator.repository.RepositoryLocal

class HistoryInteractor(
    private val repositoryRemote: Repository<List<Word>>,
    private val repositoryLocal: RepositoryLocal<List<Word>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }

    suspend fun getAllData(): AppState {
        return AppState.Success(repositoryLocal.getAllData())
    }
}
