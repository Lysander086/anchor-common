package org.anchor.integrationTest

import org.anchor.BaseService
import org.anchor.impl.TestEntity
import org.anchor.impl.TestRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.test.context.TestPropertySource

@TestPropertySource(locations = ["classpath:application-test.anchor-common.yml"])
@DataJpaTest
class BaseServiceTest {
    @Autowired
    private lateinit var repository: TestRepository

    private lateinit var baseService: BaseService<Long, TestEntity>

    @BeforeEach
    fun setUpAll() {
        baseService = BaseService(repository)
    }

    @Test
    fun `should save entity successfully`() {
        val entity = TestEntity("testValue")
        val savedEntity = baseService.upsert(entity)
        assertNotNull(savedEntity.id)
        assertEquals("testValue", savedEntity.text)
    }

    @Test
    fun `should delete all entities successfully`() {
        baseService.upsert(TestEntity("test1"))
        baseService.upsert(TestEntity("test2"))
        assertEquals(2, baseService.count()) // 確認用

        baseService.deleteAll()
        assertEquals(0, baseService.count()) // すべて削除されたことを確認
    }

    @Test
    fun `should delete entity by ID successfully`() {
        val entity = baseService.upsert(TestEntity("testValue"))
        assertTrue(baseService.exists(entity.id!!)) // 確認用

        baseService.delete(entity.id!!)
        assertFalse(baseService.exists(entity.id!!)) // ID で削除されたことを確認
    }

    @Test
    fun `should delete multiple entities by IDs successfully`() {
        val entity1 = baseService.upsert(TestEntity("test1"))
        val entity2 = baseService.upsert(TestEntity("test2"))
        assertEquals(2, baseService.count()) // 確認用

        baseService.delete(listOf(entity1.id!!, entity2.id!!))
        assertEquals(0, baseService.count()) // すべて削除されたことを確認
    }

    @Test
    fun `should flush changes successfully`() {
        val entity = TestEntity("testValue")
        baseService.upsert(entity)
        entity.text = "updatedValue"

        baseService.flush() // フラッシュで変更を適用

        val foundEntity = baseService.findOne(entity.id!!)
        assertEquals("updatedValue", foundEntity.text) // 変更がDBに反映されたことを確認
    }


    @Test
    fun `should save all entities successfully`() {
        val entities = listOf(TestEntity("test1"), TestEntity("test2"))
        val savedEntities = baseService.saveAll(entities)
        assertEquals(2, savedEntities.size)
    }

    @Test
    fun `should save and flush entity successfully`() {
        val entity = TestEntity("testValue")
        val savedEntity = baseService.saveAndFlush(entity)
        assertNotNull(savedEntity.id)
        assertEquals("testValue", savedEntity.text)
    }

    @Test
    fun `should find one entity by ID`() {
        val entity = baseService.upsert(TestEntity("testValue"))
        val foundEntity = baseService.findOne(entity.id!!)
        assertEquals(entity.id, foundEntity.id)
    }

    @Test
    fun `should return all entities`() {
        baseService.upsert(TestEntity("test1"))
        baseService.upsert(TestEntity("test2"))
        val result = baseService.findAll()
        assertEquals(2, result.size)
    }

    @Test
    fun `should return all entities with sorting`() {
        baseService.upsert(TestEntity("B"))
        baseService.upsert(TestEntity("A"))
        val sortedEntities = baseService.findAll(Sort.by("text"))
        assertEquals("A", sortedEntities[0].text)
    }

    @Test
    fun `should return paginated entities`() {
        baseService.saveAll(listOf(TestEntity("A"), TestEntity("B"), TestEntity("C")))
        val pageable = PageRequest.of(0, 2)
        val page = baseService.findAll(pageable)
        assertEquals(2, page.size)
    }

    @Test
    fun `should update entity successfully`() {
        val e = TestEntity("testValue")
        baseService.upsert(e)
        e.text = "updatedValue"
        val updatedEntity = baseService.upsert(e)
        assertEquals("updatedValue", updatedEntity.text)
    }

    @Test
    fun `should delete entity successfully`() {
        val entity = baseService.upsert(TestEntity("testValue"))
        baseService.delete(entity)
        assertFalse(baseService.exists(entity.id!!))
    }

    @Test
    fun `should delete all entities in batch successfully`() {
        val entities = listOf(TestEntity("test1"), TestEntity("test2"))
        baseService.saveAll(entities)
        baseService.deleteAllInBatch(entities)
        assertEquals(0, baseService.count())
    }

    @Test
    fun `should delete entity by ID`() {
        val entity = baseService.upsert(TestEntity("testValue"))
        baseService.deleteById(entity.id!!)
        assertFalse(baseService.exists(entity.id!!))
    }

    @Test
    fun `should count entities`() {
        baseService.upsert(TestEntity("test1"))
        baseService.upsert(TestEntity("test2"))
        assertEquals(2, baseService.count())
    }

    @Test
    fun `should check if entity exists`() {
        val entity = baseService.upsert(TestEntity("testValue"))
        assertTrue(baseService.exists(entity.id!!))
    }
}
