package org.anchor.integrationTest

import org.anchor.impl.TestAuditableBaseEntity
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AuditableBaseEntityTest {

    @Test
    fun test() {
        val entity = TestAuditableBaseEntity(text = "testValue")
        entity.createdBy = "testUser"
        entity.updatedBy = "testUser"
        assertEquals("testUser", entity.createdBy)
        assertEquals("testUser", entity.updatedBy)
    }
}