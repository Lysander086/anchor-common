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
