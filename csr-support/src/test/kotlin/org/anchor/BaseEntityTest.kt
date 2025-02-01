package org.anchor

import org.anchor.impl.TestEntity
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BaseEntityTest {

    @Test
    fun `should correctly initialize BaseEntity`() {
        // Arrange
        val entity = TestEntity("test")

        // Assert
        assertEquals("test", entity.text)
    }
}