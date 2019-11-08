package com.github.Higman.simple_functiondata_library

import java.lang.RuntimeException

class DataWithHistory<T>(currentData : T? = null) {
    private val _history: MutableList<T> = mutableListOf()
    private var _data : T? = null
        set(value) {
            field = value
            field?.let {
                _history.add(it)
            }
        }

    init {
        _data = currentData
    }

    var data: T
        set(value) {
            _data = value
        }
        /**
         * throw NoExistHistoryElementException データが存在しないとき、発生
         */
        get() = _history.runCatching { last() }.getOrNull() ?: throw NoExistHistoryElementException()
    fun history(): List<T> = _history.toList()
}

class NoExistHistoryElementException : RuntimeException()