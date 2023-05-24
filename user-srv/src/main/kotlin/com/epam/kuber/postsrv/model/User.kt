package com.epam.kuber.postsrv.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.time.LocalDateTime

@Document(collection = "users")
class User {
    @Id
    var id: Long? = null
    var firstName: String? = null
    var lastName: String? = null
    var sex: GenderType? = null
    var dob: LocalDate? = null
    var address: Address? = null
    var amountOfPosts: Long? = null
    var position: String? = null
    var active: Boolean? = null
    var created: LocalDateTime? = null
    var modified: LocalDateTime? = null
}

