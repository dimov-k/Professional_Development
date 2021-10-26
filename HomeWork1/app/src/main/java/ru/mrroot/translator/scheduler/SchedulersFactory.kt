package ru.mrroot.translator.scheduler

object SchedulersFactory {
    fun create(): Schedulers = DefaultSchedulers()
}