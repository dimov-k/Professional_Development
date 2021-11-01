package ru.mrroot.stopwatch.domain

interface ITimestampProvider {
    fun getMilliseconds(): Long
}