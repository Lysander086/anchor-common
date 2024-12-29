package org.anchor.dao

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import java.io.Serializable

@NoRepositoryBean
interface BaseRepository<T : BaseEntity<ID>, ID : Serializable> : JpaRepository<T, ID> {
}
