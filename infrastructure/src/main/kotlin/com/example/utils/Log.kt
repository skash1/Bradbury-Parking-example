package com.example.utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory

object Log {

    fun Any.logger(): Logger = LoggerFactory.getLogger(javaClass)

}
