package com.epam.kuber.postsrv.repository

import com.epam.kuber.postsrv.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface UserRepository : MongoRepository<User?, String?> {
    fun findById(id: Long): Optional<User>
    fun existsById(id: Long): Boolean
    fun deleteById(id: Long): Boolean
}
