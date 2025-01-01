package org.anchor

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BaseEntityTest {

    @Test
    fun `should correctly initialize BaseEntity`() {
        // Arrange
        val id = 1L
        val version = 1
        val createdBy = 123L

        // Act
        val baseEntity = BaseEntity(id, version, createdBy)

        // Assert
        assertEquals(id, baseEntity.id)
        assertEquals(version, baseEntity.version)
        assertEquals(createdBy, baseEntity.createdBy)
    }
}
