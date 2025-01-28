package org.anchor

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BaseEntityAuditTest {

    @Test
    fun testCreatedBy() {
        val entity = object : BaseEntityAudit() {}
        entity.createdBy = "testUser"
        assertEquals("testUser", entity.createdBy)
    }

    @Test
    fun testUpdatedBy() {
        val entity = object : BaseEntityAudit() {}
        entity.updatedBy = "testUser"
        assertEquals("testUser", entity.updatedBy)
    }
}