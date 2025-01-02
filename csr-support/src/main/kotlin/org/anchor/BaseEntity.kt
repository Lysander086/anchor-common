package org.anchor

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.Version
import lombok.EqualsAndHashCode
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.domain.Persistable
import java.io.Serializable
import java.time.Instant
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@MappedSuperclass
@EqualsAndHashCode
abstract class BaseEntity<ID : Serializable> : Persistable<ID> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: ID? = null

    @Version
    private val version: ID? = null

    @field:CreationTimestamp
    val createdAt: Instant? = null

    @field:UpdateTimestamp
    val updatedAt: Instant? = null

    override fun getId(): ID? {
        return id
    }

    override fun isNew(): Boolean {
        return version == null
    }

    override fun toString(): String {
        return Json.encodeToString(this)
    }
}