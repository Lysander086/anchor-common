package org.anchor.integrationTest

import org.anchor.AuditableBaseEntity
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AuditableBaseEntityTest {

    @Test
    fun testCreatedBy() {
        val entity = object : AuditableBaseEntity() {}
        entity.createdBy = "testUser"
        assertEquals("testUser", entity.createdBy)
    }

    @Test
    fun testUpdatedBy() {
        val entity = object : AuditableBaseEntity() {}
        entity.updatedBy = "testUser"
        assertEquals("testUser", entity.updatedBy)
    }
}