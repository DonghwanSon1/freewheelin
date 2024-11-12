plugins {
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "2.7.18"
	id("io.spring.dependency-management") version "1.1.5"
	kotlin("plugin.jpa") version "1.9.25"
	kotlin("kapt") version "1.8.0"
	id ("org.flywaydb.flyway") version "8.5.13"
}

group = "com.project"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	// QueryDSL
	implementation("com.querydsl:querydsl-jpa:5.0.0")
	kapt("com.querydsl:querydsl-apt:5.0.0:jpa")

	// Swagger
	implementation("org.springdoc:springdoc-openapi-ui:1.6.11")

	runtimeOnly("com.h2database:h2:2.1.210")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

allOpen {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

