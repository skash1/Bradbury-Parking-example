package com.example.dto.mapper

fun interface Mapper<IN, OUT> {

    fun map(input: IN): OUT

}
