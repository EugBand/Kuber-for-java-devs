package com.epam.kuber.postsrv.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.TextIndexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "posts")
data class Post(@Id var id: Long?) {

//    @Id var id: Long? = null
    val userId: Long? = null

    @TextIndexed
    val text: String? = null
    val status: PostStatusType? = null
    val created: LocalDateTime? = null
    val modified: LocalDateTime? = null
}
