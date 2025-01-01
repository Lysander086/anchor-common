package org.anchor.impl

import org.anchor.BaseRepository
import org.springframework.stereotype.Repository

// ingz: すべてのテストにパスします。
@Repository
interface  TestRepository : BaseRepository<TestEntity, Long>{}
