package org.anchor.integrationTest

import org.anchor.impl.TestEntity
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class AuditableBaseEntityTest {

    @Test
    fun test() {
        val entity = TestEntity(text = "testValue")
        entity.createdBy = "testUser"
        entity.updatedBy = "testUser"
        assertEquals("testUser", entity.createdBy)
        assertEquals("testUser", entity.updatedBy)
        assertNotNull(entity.createdAt)
        assertNotNull(entity.updatedAt)
    }
}