package org.anchor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
// delz internalを意味を確認する　
// このファイルはテストのディレクトリに移行する必要があります
internal class SpringBootLifecycleEventApplication

fun main(args: Array<String>) {
    runApplication<SpringBootLifecycleEventApplication>(*args)
}
