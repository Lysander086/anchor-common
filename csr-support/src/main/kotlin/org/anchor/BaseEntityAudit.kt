package org.anchor

import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntityAudit : BaseEntity<Long>()  {
    var createdBy: String? = null
    var updatedBy: String? = null

}