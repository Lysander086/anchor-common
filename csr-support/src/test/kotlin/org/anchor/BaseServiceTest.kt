package org.anchor

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

class BaseServiceTest {

    private lateinit var repository: JpaRepository<BaseEntity<Long>, Long>
    private lateinit var baseService: BaseService<Long, BaseEntity<Long>>

    @BeforeEach
    fun setup() {
        @Suppress("UNCHECKED_CAST") // is there a better way?
        repository = mock(JpaRepository::class.java) as JpaRepository<BaseEntity<Long>, Long>
        baseService = BaseService(repository)
    }


    @Test
    fun `should save entity`() {
        // Arrange
        val entity = BaseEntity(id = 1L, version = 1, createdBy = 123L)
        `when`(repository.save(entity)).thenReturn(entity)

        // Act
        val savedEntity = baseService.save(entity)

        // Assert
        assertEquals(entity, savedEntity)
        verify(repository, times(1)).save(entity)
    }

    @Test
    fun `should find all entities`() {
        // Arrange
        val entities = listOf(
            BaseEntity(id = 1L, version = 1, createdBy = 123L),
            BaseEntity(id = 2L, version = 1, createdBy = 124L)
        )
        `when`(repository.findAll()).thenReturn(entities)

        // Act
        val result = baseService.findAll()

        // Assert
        assertEquals(entities, result)
        verify(repository, times(1)).findAll()
    }

    @Test
    fun `should find entity by ID`() {
        // Arrange
        val entity = BaseEntity(id = 1L, version = 1, createdBy = 123L)
        `when`(repository.findById(1L)).thenReturn(Optional.of(entity))

        // Act
        val result = baseService.findOne(1L)

        // Assert
        assertEquals(entity, result)
        verify(repository, times(1)).findById(1L)
    }
}
