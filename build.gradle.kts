import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.1"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.21"
	kotlin("plugin.spring") version "1.9.21"
	kotlin("plugin.jpa") version "1.9.21"
	`maven-publish`
}

group = "com.example"
version = "1.0.0"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

allprojects {
	apply(plugin = "org.jetbrains.kotlin.jvm")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")
	apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "maven-publish")
	repositories {
		mavenCentral()
	}

	tasks.withType<KotlinCompile>().configureEach {
		kotlinOptions.jvmTarget = "17"
	}

	dependencies {
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("io.arrow-kt:arrow-core:1.2.0")
		implementation("io.arrow-kt:arrow-fx-coroutines:1.2.0")
		implementation("io.arrow-kt:arrow-core:1.2.0")
		implementation("io.arrow-kt:arrow-fx-coroutines:1.2.0")
		implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
		implementation("org.springframework.boot:spring-boot-starter-data-jpa")
		implementation("org.springframework.boot:spring-boot-starter-web")
		implementation("org.springframework.kafka:spring-kafka")

		runtimeOnly("com.h2database:h2")

		testImplementation("org.springframework.boot:spring-boot-starter-test")
		testImplementation("org.springframework.kafka:spring-kafka-test")
	}

	publishing {
		repositories {
			mavenLocal()
		}
		publications {
			create<MavenPublication>("dev") {
				groupId = rootProject.group.toString()
				artifactId = rootProject.name + "-" + project.name
				version = rootProject.version.toString()

				from(components["java"])
			}
		}
	}

}

dependencies {
	implementation(project(":infrastructure"))
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
