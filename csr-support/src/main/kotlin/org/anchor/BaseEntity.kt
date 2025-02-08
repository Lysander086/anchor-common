package org.anchor

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.MappedSuperclass
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.springframework.data.domain.Persistable


@Entity
@MappedSuperclass
abstract class BaseEntity : Persistable<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null
    override fun getId(): Long? = id
    @Version
    private val version: Int? = null

    override fun isNew(): Boolean {
        return version == null
    }

    override fun toString(): String {
        return Json.encodeToString(this)
    }
}