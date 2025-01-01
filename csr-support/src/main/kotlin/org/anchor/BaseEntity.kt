package org.anchor

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedBy

import java.io.Serializable


@MappedSuperclass
open class BaseEntity<ID : Serializable>(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: ID,
    @Version
    val version: Int,
    @CreatedBy
    val createdBy: ID
)
