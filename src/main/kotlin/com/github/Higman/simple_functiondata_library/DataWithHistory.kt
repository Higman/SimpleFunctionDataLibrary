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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DataWithHistory<*>

        if (_history != other._history) return false
        if (_data != other._data) return false

        return true
    }

    override fun hashCode(): Int {
        var result = _history.hashCode()
        result = 31 * result + (_data?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "DataWithHistory(data=$_data)"
    }
}

class NoExistHistoryElementException : RuntimeException()