package org.anchor.integrationTest


import org.anchor.BaseService
import org.anchor.impl.TestEntity
import org.anchor.impl.TestRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@TestPropertySource(locations = ["classpath:application-test.anchor-common.yml"])
@Transactional
class BaseServiceIntegrationTest {

    @Autowired
    private lateinit var repository: TestRepository

    private lateinit var baseService: BaseService<Long, TestEntity>

    @BeforeEach
    fun setUp() {
        baseService = BaseService(repository)
    }

    @AfterEach
    fun tearDown() {
        repository.deleteAll() // Cleanup after each test
    }

    @Test
    fun `should save entity successfully`() {
        val entity = TestEntity("testValue")
        val savedEntity = baseService.upsert(entity)
        assertNotNull(savedEntity.id)
        assertEquals("testValue", savedEntity.value)
    }

//    @Test
//    fun `should save all entities successfully`() {
//        val entities = listOf(TestEntity("test1"), TestEntity("test2"))
//        val savedEntities = baseService.saveAll(entities)
//        assertEquals(2, savedEntities.size)
//    }
//
//    @Test
//    fun `should save and flush entity successfully`() {
//        val entity = TestEntity("testValue")
//        val savedEntity = baseService.saveAndFlush(entity)
//        assertNotNull(savedEntity.id)
//        assertEquals("testValue", savedEntity.value)
//    }
//
//    @Test
//    fun `should find one entity by ID`() {
//        val entity = baseService.upsert(TestEntity("testValue"))
//        val foundEntity = baseService.findOne(entity.id!!)
//        assertEquals(entity.id, foundEntity.id)
//    }
//
//    @Test
//    fun `should return all entities`() {
//        baseService.upsert(TestEntity("test1"))
//        baseService.upsert(TestEntity("test2"))
//        val result = baseService.findAll()
//        assertEquals(2, result.size)
//    }
//
//    @Test
//    fun `should return all entities with sorting`() {
//        baseService.upsert(TestEntity("B"))
//        baseService.upsert(TestEntity("A"))
//        val sortedEntities = baseService.findAll(Sort.by("value"))
//        assertEquals("A", sortedEntities[0].value)
//    }
//
//    @Test
//    fun `should return paginated entities`() {
//        baseService.saveAll(listOf(TestEntity("A"), TestEntity("B"), TestEntity("C")))
//        val pageable = PageRequest.of(0, 2)
//        val page = baseService.findAll(pageable)
//        assertEquals(2, page.size)
//    }
//
//    @Test
//    fun `should update entity successfully`() {
//        val e = TestEntity("testValue")
//     baseService.upsert(e)
//        e.value = "updatedValue"
//        val updatedEntity = baseService.upsert(e)
//        assertEquals("updatedValue", updatedEntity.value)
//    }
//
//    @Test
//    fun `should delete entity successfully`() {
//        val entity = baseService.upsert(TestEntity("testValue"))
//        baseService.delete(entity)
//        assertFalse(baseService.exists(entity.id!!))
//    }
//
//    @Test
//    fun `should delete all entities in batch successfully`() {
//        val entities = listOf(TestEntity("test1"), TestEntity("test2"))
//        baseService.saveAll(entities)
//        baseService.deleteAllInBatch(entities)
//        assertEquals(0, baseService.count())
//    }
//
//    @Test
//    fun `should delete entity by ID`() {
//        val entity = baseService.upsert(TestEntity("testValue"))
//        baseService.deleteById(entity.id!!)
//        assertFalse(baseService.exists(entity.id!!))
//    }
//
//    @Test
//    fun `should count entities`() {
//        baseService.upsert(TestEntity("test1"))
//        baseService.upsert(TestEntity("test2"))
//        assertEquals(2, baseService.count())
//    }
//
//    @Test
//    fun `should check if entity exists`() {
//        val entity = baseService.upsert(TestEntity("testValue"))
//        assertTrue(baseService.exists(entity.id!!))
//    }
}
