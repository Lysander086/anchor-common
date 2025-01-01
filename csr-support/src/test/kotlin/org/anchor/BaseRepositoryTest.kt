package org.anchor

import org.anchor.impl.TestEntity
import org.anchor.impl.TestRepository
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.Transactional

@DataJpaTest(
    properties = [
        "spring.datasource.url=jdbc:h2:mem:testdb",
        "spring.jpa.hibernate.ddl-auto=create-drop"
    ], showSql = true
)
@Import(TestRepository::class)
class BaseRepositoryTest {
//    @Autowired
//    private lateinit var repository: BaseRepository
//
//
//    private lateinit var entity: TestEntity
//
//    @BeforeEach
//    fun setUp() {
//        entity = TestEntity(id = 1L, version = 1, createdBy = 123L)
//    }
//
//    @AfterEach
//    fun tearDown() {
//        repository.deleteAll()
//    }
//

    @Test
    fun `should save and retrieve entity`() {
        println("test")

//        // Act
//        val savedEntity = repository.save(entity)
//        val retrievedEntity = repository.findById(savedEntity.id).orElse(null)
//
//        // Assert
//        assertNotNull(retrievedEntity, "Retrieved entity should not be null")
//        assertEquals(savedEntity.id, retrievedEntity.id, "IDs should match")
//        assertEquals(savedEntity.version, retrievedEntity.version, "Versions should match")
//        assertEquals(savedEntity.createdBy, retrievedEntity.createdBy, "CreatedBy fields should match")
    }
}
