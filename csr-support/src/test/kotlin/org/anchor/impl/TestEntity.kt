package org.anchor.impl

import jakarta.persistence.Entity
import org.anchor.AuditableBaseEntity

/**
 * This Spring official guides](https://github.com/spring-guides/tut-spring-boot-kotlin#persistence-with-jpa) shows we shouldn't use kotlin data class with spring-data-jpa.
 */

@Entity
  class TestEntity(
  var text: String,
) : AuditableBaseEntity()