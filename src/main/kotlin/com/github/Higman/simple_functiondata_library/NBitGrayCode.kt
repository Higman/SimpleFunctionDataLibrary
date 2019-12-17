package com.github.Higman.simple_functiondata_library

import java.lang.RuntimeException
import kotlin.math.pow

open class NBitGrayCode(
    initVal: List<Int> = listOf(),
    bitSize: Int = initVal.size
) : Number(), Comparable<NBitGrayCode>, Cloneable {
    var bits: MutableList<Int> = initVal.toMutableList()
    val bitSize: Int
        get() = bits.size

    init {
        if (bitSize < bits.size) throw IllegalArgumentException("List 'initVal' size is over bitSize.")
        repeat(bitSize - bits.size) { bits.add(0) }
    }

    private fun decode(): Int = _decode(bits, bits.lastIndex)

    private fun _decode(grayCode: List<Int>, n: Int): Int {
        return if (n < 1) {
            grayCode[0]
        } else {
            if (grayCode[n] == 0) _decode(grayCode, n - 1) else ((2.0.pow(n + 1) - 1) - _decode(
                grayCode,
                n - 1
            )).toInt()
        }
    }

    override fun toByte(): Byte = decode().toByte()

    override fun toChar(): Char = decode().toChar()

    override fun toDouble(): Double = decode().toDouble()

    override fun toFloat(): Float = decode().toFloat()

    override fun toInt(): Int = decode()

    override fun toLong(): Long = decode().toLong()

    override fun toShort(): Short = decode().toShort()

    override fun compareTo(other: NBitGrayCode): Int = this.toInt() - other.toInt()

    public override fun clone(): NBitGrayCode {
        val c = kotlin.runCatching {
            super.clone() as NBitGrayCode
        }.fold(
            onSuccess = { it },
            onFailure = { throw RuntimeException("Failed to clone in ${this::class.qualifiedName}")}
        )
        c.bits = bits.toMutableList()
        return c
    }
}