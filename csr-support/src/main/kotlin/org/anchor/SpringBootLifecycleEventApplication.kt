package org.anchor

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootLifecycleEventApplication

fun main(args: Array<String>) {
    runApplication<SpringBootLifecycleEventApplication>(*args)
}
