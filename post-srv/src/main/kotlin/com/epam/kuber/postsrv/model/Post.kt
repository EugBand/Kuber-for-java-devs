package com.epam.kuber.postsrv.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.TextIndexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "posts")
class Post {

    @Id
    var id: Long? = null
    var userId: Long? = null

    @TextIndexed
    var text: String? = null
    var topic: String? = null
    var status: PostStatusType? = null
    var created: LocalDateTime? = null
    var modified: LocalDateTime? = null
}
