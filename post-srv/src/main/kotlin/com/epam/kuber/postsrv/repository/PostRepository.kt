package com.epam.kuber.postsrv.repository

import com.epam.kuber.postsrv.model.Post
import org.springframework.data.mongodb.repository.Aggregation
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface PostRepository : MongoRepository<Post?, Long?> {

    @Aggregation(pipeline = ["{ '\$match': { '\$text': { '\$search': ?0}, 'status': ?1 } }", "{'\$sort':{'description':?2}}"])
    fun findTasksWithParams(search: String?, status: String?, sort: Long?): List<Post?>?

    fun countByUserId(id: Long): Int
}
