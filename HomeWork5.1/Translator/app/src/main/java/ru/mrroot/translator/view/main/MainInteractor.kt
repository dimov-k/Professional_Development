package ru.mrroot.translator.view.main

import ru.mrroot.translator.core.viewmodel.Interactor
import ru.mrroot.translator.model.data.AppState
import ru.mrroot.translator.model.data.Word
import ru.mrroot.translator.repository.Repository
import ru.mrroot.translator.repository.RepositoryLocal

class MainInteractor(
    private val repositoryRemote: Repository<List<Word>>,
    private val repositoryLocal: RepositoryLocal<List<Word>>
) : Interactor<AppState> {
    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(repositoryRemote.getData(word))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(repositoryLocal.getData(word))
        }
        return appState
    }
}