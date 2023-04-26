package com.epam.kuber.postsrv.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.time.LocalDateTime

@Document(collection = "users")
class User {
    @Id
    var id: Long? = null
    val firstName: String? = null
    val lastName: String? = null
    val sex: GenderType? = null
    val dob: LocalDate? = null
    var address: Address? = null
    val amountOfPosts: Long? = null
    val position: String? = null
    val active: Boolean? = null
    val created: LocalDateTime? = null
    val modified: LocalDateTime? = null
}

