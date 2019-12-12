package com.github.Higman.simple_functiondata_library

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty

data class VecData<T: Number>(@JsonProperty var value: List<T>) {
    @JsonIgnore
    val degree: Int = this.value.size

    fun copy() = VecData(this.value.toList())
}