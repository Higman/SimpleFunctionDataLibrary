package com.github.Higman.simple_function_data_library

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty

data class VecData(@JsonProperty var value: List<Double>) {
    @JsonIgnore
    val degree: Int = this.value.size

    fun copy() = VecData(this.value.toList())
}