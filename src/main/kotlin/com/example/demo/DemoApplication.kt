package com.example.demo

import com.example.repository.ParkPlaceRepository
import com.example.rpcs.ParkPlaceService
import io.grpc.Server
import io.grpc.ServerBuilder
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@ComponentScan(DEFAULT_PACKAGE)
@EnableJpaRepositories(DEFAULT_PACKAGE)
@EntityScan(DEFAULT_PACKAGE)
@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	val applicationContext = runApplication<DemoApplication>(*args)
	val parkPlaceServer = ParkPlaceServer(8980, applicationContext)
	parkPlaceServer.start()
	parkPlaceServer.awaitTermination()
}

class ParkPlaceServer(port: Int, applicationContext: ConfigurableApplicationContext) {
	private var server: Server

	init {
		server = ServerBuilder.forPort(port)
			.addService(ParkPlaceService(applicationContext.getBean(ParkPlaceRepository::class.java))).build()
	}

	fun start() {
		server.start()
		println("Server started, listening on ${server.port}")
	}

	fun awaitTermination() {
		server.awaitTermination()
	}
}

const val DEFAULT_PACKAGE = "com.example"
