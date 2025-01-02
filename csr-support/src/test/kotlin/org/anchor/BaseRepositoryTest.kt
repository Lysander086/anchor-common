package org.anchor

import org.anchor.impl.TestEntity
import org.anchor.impl.TestRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class BaseRepositoryTest {
    @Autowired
    private lateinit var repository: TestRepository

    private lateinit var entity: TestEntity

    // ingz: すべてのテストにパスします。
    @BeforeEach
    fun setUp() {
        entity = TestEntity("test")
    }

    @AfterEach
    fun tearDown() {
        repository.deleteAll()
    }


    @Test
    fun `should save and retrieve entity`() {

        // Act
        val savedEntity = repository.save(entity)
        val retrievedEntity = savedEntity.id?.let { repository.findById(it).orElse(null) }

        // Assert
        assertNotNull(retrievedEntity, "Retrieved entity should not be null")
    }
}

// ingz  エラーを修正する 　C:/Users/Lysander/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlinx/kotlinx-serialization-core-jvm/1.5.1/e26cf5dfbcfe3e82ca196694dfd305753b1a49b9/kotlinx-serialization-core-jvm-1.5.1.jar!/META-INF/kotlinx-serialization-core.kotlin_module: Module was compiled with an incompatible version of Kotlin. The binary version of its metadata is 1.8.0, expected version is 1.6.0.