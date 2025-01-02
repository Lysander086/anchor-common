package org.anchor

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.io.Serializable

@Repository
interface BaseRepository<T : BaseEntity<ID>, ID : Serializable> : CrudRepository<BaseEntity<ID>, Long>