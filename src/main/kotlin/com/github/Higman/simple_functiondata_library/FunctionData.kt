package com.github.Higman.simple_functiondata_library

import java.lang.IllegalArgumentException
import java.lang.RuntimeException

data class FunctionData<T : Double>(val degree: Int, private val func: (List<T>) -> T) {
    init {
        if (degree < 1) throw IllegalArgumentException("dimensiton >= 1 でなければなりません")
    }
    fun calc(xs: VecData<T>): T = degree.let {if (it == xs.degree) func(xs.value) else throw IllegalDegreeException() }
    override fun toString(): String {
        return "FunctionData(degree=$degree)"
    }
}

class IllegalDegreeException: RuntimeException()