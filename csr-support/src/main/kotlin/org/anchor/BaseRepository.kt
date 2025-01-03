package org.anchor

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.NoRepositoryBean
import java.io.Serializable

@NoRepositoryBean
interface BaseRepository<T : BaseEntity<ID>, ID : Serializable> : CrudRepository<T, Long>