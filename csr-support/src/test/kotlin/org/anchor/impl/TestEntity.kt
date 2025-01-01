package org.anchor.impl

import jakarta.persistence.Entity
import org.anchor.BaseEntity

@Entity
class TestEntity(
    id: Long,
    version: Int,
    createdBy: Long
) : BaseEntity<Long>(id, version, createdBy)