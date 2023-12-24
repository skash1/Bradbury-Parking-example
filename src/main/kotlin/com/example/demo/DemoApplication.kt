package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@ComponentScan(DEFAULT_PACKAGE)
@EnableJpaRepositories(DEFAULT_PACKAGE)
@EntityScan(DEFAULT_PACKAGE)
@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

const val DEFAULT_PACKAGE = "com.example"
