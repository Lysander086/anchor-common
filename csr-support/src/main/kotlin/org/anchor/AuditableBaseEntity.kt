package org.anchor

import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@MappedSuperclass
abstract class AuditableBaseEntity : BaseEntity<Long>() {
    var createdBy: String? = null
    var updatedBy: String? = null

    @field:CreationTimestamp
    val createdAt: Instant? = null

    @field:UpdateTimestamp
    val updatedAt: Instant? = null
}