package com.gleam

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties

@SpringBootApplication
@EnableConfigurationProperties
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
