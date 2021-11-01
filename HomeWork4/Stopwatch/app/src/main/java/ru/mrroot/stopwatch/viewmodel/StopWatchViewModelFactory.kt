package ru.mrroot.stopwatch.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.mrroot.stopwatch.domain.StopwatchStateHolder
import kotlinx.coroutines.CoroutineScope

class StopWatchViewModelFactory(
    private val stopwatchStateHolder: StopwatchStateHolder,
    private val scope: CoroutineScope
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        StopWatchViewModel(stopwatchStateHolder, scope) as T
}