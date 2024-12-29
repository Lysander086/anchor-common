package org.anchor.dao

import jakarta.persistence.Entity
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

// Test-specific concrete entity
@Entity
class TestEntity(
    id: Long,
    version: Int,
    createdBy: Long
) : BaseEntity<Long>(id, version, createdBy)

// Repository for TestEntity
interface TestEntityRepository : BaseRepository<TestEntity, Long>

// Test class
@SpringBootTest
@Transactional
class BaseRepositoryTest {

    @Autowired
    private lateinit var repository: TestEntityRepository

    @Test
    fun `should save and retrieve entity`() {
        // Arrange
        val entity = TestEntity(id = 1L, version = 1, createdBy = 123L)

        // Act
        val savedEntity = repository.save(entity)
        val retrievedEntity = repository.findById(savedEntity.id).orElse(null)

        // Assert
        assertNotNull(retrievedEntity, "Retrieved entity should not be null")
        assertEquals(savedEntity.id, retrievedEntity.id, "IDs should match")
        assertEquals(savedEntity.version, retrievedEntity.version, "Versions should match")
        assertEquals(savedEntity.createdBy, retrievedEntity.createdBy, "CreatedBy fields should match")
    }
}
