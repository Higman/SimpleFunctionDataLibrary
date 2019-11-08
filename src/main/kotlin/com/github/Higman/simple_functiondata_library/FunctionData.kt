package com.github.Higman.simple_functiondata_library

import java.lang.IllegalArgumentException
import java.lang.RuntimeException

data class FunctionData(val degree: Int, private val func: (List<Double>) -> Double) {
    init {
        if (degree < 1) throw IllegalArgumentException("dimensiton >= 1 でなければなりません")
    }
    fun calc(xs: VecData): Double = degree.let {if (it == xs.degree) func(xs.value) else throw IllegalDegreeException() }
}

class IllegalDegreeException: RuntimeException()