package org.anchor.impl

import org.anchor.BaseRepository
import org.springframework.stereotype.Repository

@Repository
interface TestRepository : BaseRepository<TestEntity, Long>
