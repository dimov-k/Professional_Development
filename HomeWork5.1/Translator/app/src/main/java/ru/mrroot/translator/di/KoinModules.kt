package ru.mrroot.translator.di


import androidx.room.Room
import org.koin.dsl.module
import ru.mrroot.translator.historyscreen.view.history.HistoryInteractor
import ru.mrroot.translator.historyscreen.view.history.HistoryViewModel
import ru.mrroot.translator.model.data.Word
import ru.mrroot.translator.repository.*
import ru.mrroot.translator.repository.room.HistoryDataBase
import ru.mrroot.translator.view.main.MainInteractor
import ru.mrroot.translator.view.main.MainViewModel

val application = module {
    single {
        Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB")
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<Word>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<Word>>> {
        RepositoryImplementationLocal(
            RoomDataBaseImplementation(
                get()
            )
        )
    }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}
