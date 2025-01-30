package org.anchor


import org.anchor.impl.TestEntity
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

// ingz 1 2 test case fix. vs code copilot https://chatgpt.com/c/679b71b9-1f28-800f-a288-8d4d890c5cb3
class BaseServiceTest {

    private lateinit var repositoryMock: JpaRepository<TestEntity, Long>
    private lateinit var baseService: BaseService<Long, TestEntity>

    @BeforeEach
    fun setUp() {
        repositoryMock = mock(JpaRepository::class.java) as JpaRepository<TestEntity, Long>
        baseService = BaseService(repositoryMock)
    }

    @Test
    fun save() {
        val entity = TestEntity("testValue")
        `when`(repositoryMock.save(entity)).thenReturn(entity)

        val result = baseService.save(entity)
        assertEquals(entity, result)
        verify(repositoryMock, times(1)).save(entity)
    }

    @Test
    fun saveAndFlush() {
        val entity = TestEntity("testValue")
        `when`(repositoryMock.saveAndFlush(entity)).thenReturn(entity)

        val result = baseService.saveAndFlush(entity)
        assertEquals(entity, result)
        verify(repositoryMock, times(1)).saveAndFlush(entity)
    }

    @Test
    fun saveAll() {
        val entities = listOf(TestEntity("testValue1"), TestEntity("testValue2"))
        `when`(repositoryMock.saveAll(entities)).thenReturn(entities)

        val result = baseService.saveAll(entities)
        assertEquals(entities, result)
        verify(repositoryMock, times(1)).saveAll(entities)
    }

    @Test
    fun findOne() {
        val entity = TestEntity("testValue1")
        `when`(repositoryMock.findById(1L)).thenReturn(Optional.of(entity))

        val result = baseService.findOne(1L)
        assertEquals(entity, result)
        verify(repositoryMock, times(1)).findById(1L)
    }

    @Test
    fun findAll() {
        val entities = listOf(TestEntity("testValue1"), TestEntity("testValue2"))
        `when`(repositoryMock.findAll()).thenReturn(entities)

        val result = baseService.findAll()
        assertEquals(entities, result)
        verify(repositoryMock, times(1)).findAll()
    }

    @Test
    fun findAllWithSort() {
        val entities = listOf(TestEntity("testValue1"), TestEntity("testValue2"))
        val sort = Sort.by("id")
        `when`(repositoryMock.findAll(sort)).thenReturn(entities)

        val result = baseService.findAll(sort)
        assertEquals(entities, result)
        verify(repositoryMock, times(1)).findAll(sort)
    }

    @Test
    fun findAllWithPageable() {
        val entities = listOf(TestEntity("testValue1"), TestEntity("testValue2"))
        val pageable = PageRequest.of(0, 10)
        val page = PageImpl(entities)
        `when`(repositoryMock.findAll(pageable)).thenReturn(page)

        val result = baseService.findAll(pageable)
        assertEquals(page, result)
        verify(repositoryMock, times(1)).findAll(pageable)
    }

    @Test
    fun update() {
        val entity = TestEntity("testValue1")
        `when`(repositoryMock.save(entity)).thenReturn(entity)

        val result = baseService.update(entity)
        assertEquals(entity, result)
        verify(repositoryMock, times(1)).save(entity)
    }

    @Test
    fun deleteAllInBatch() {
        val entities = listOf(TestEntity("testValue1"), TestEntity("testValue2"))
        doNothing().`when`(repositoryMock).deleteAllInBatch(entities)

        baseService.deleteAllInBatch(entities)
        verify(repositoryMock, times(1)).deleteAllInBatch(entities)
    }

    @Test
    fun deleteById() {
        doNothing().`when`(repositoryMock).deleteById(1L)

        baseService.deleteById(1L)
        verify(repositoryMock, times(1)).deleteById(1L)
    }

    @Test
    fun count() {
        `when`(repositoryMock.count()).thenReturn(2L)

        val result = baseService.count()
        assertEquals(2L, result)
        verify(repositoryMock, times(1)).count()
    }

    @Test
    fun exists() {
        `when`(repositoryMock.existsById(1L)).thenReturn(true)

        val result = baseService.exists(1L)
        assertTrue(result)
        verify(repositoryMock, times(1)).existsById(1L)
    }

    @Test
    fun flush() {
        doNothing().`when`(repositoryMock).flush()

        baseService.flush()
        verify(repositoryMock, times(1)).flush()
    }
}
