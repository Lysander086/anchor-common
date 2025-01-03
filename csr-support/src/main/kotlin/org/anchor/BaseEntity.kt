package org.anchor

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.Version
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.domain.Persistable
import java.time.Instant

@MappedSuperclass
abstract class BaseEntity<Long> : Persistable<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null

    override fun getId(): Long? = id

    @Version
    private val version: Long? = null

    @field:CreationTimestamp
    val createdAt: Instant? = null

    @field:UpdateTimestamp
    val updatedAt: Instant? = null

    override fun isNew(): Boolean {
        return version == null
    }

    override fun toString(): String {
        return Json.encodeToString(this)
    }
}