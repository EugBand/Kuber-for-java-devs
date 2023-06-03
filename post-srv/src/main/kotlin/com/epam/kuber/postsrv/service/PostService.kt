package com.epam.kuber.postsrv.service

import com.epam.kuber.postsrv.dto.PostRequestDto
import com.epam.kuber.postsrv.dto.PostResponseDto
import com.epam.kuber.postsrv.mapper.PostMapper
import com.epam.kuber.postsrv.model.Post
import com.epam.kuber.postsrv.repository.PostRepository
import com.mongodb.MongoException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue

@Service
class PostService(@Autowired val repository: PostRepository, @Autowired val mapper: PostMapper) {

    val all: MutableList<PostResponseDto?>?
        get() = repository.findAll().stream().map { it?.let { it1 -> mapper.toTaskResponseDto(it1) } }?.toList()

    fun getCountByUserId(id: Long?): Int? {
        return id?.let { repository.countByUserId(it) }
    }

    fun save(requestDto: PostRequestDto?): Boolean {
        return try {
            val taskEntity: Post? = requestDto?.let { mapper.toPost(it) }
            taskEntity?.id = Random().nextLong()
            taskEntity?.let { repository.save(it) }
            true
        } catch (e: MongoException) {
            false
        }
    }

    fun getById(id: Long?): Optional<PostResponseDto> {
        return try {
            val optionalPost: Optional<Post?>? = id?.let { repository.findById(it) }
            val post: Post? = optionalPost?.orElseThrow()
            val toTaskResponseDto = post?.let { mapper.toTaskResponseDto(it) }
            Optional.ofNullable(toTaskResponseDto)
        } catch (e: MongoException) {
            Optional.empty<PostResponseDto>()
        }
    }

    fun search(search: String?, status: String?, order: Long?): MutableList<PostResponseDto?>? {
        return repository.findTasksWithParams(search, status, order)?.stream()?.map { it?.let { it1 -> mapper.toTaskResponseDto(it1) } }?.toList()
    }

    fun update(id: Long?, requestDto: PostRequestDto?): Boolean {
        if (id?.let { repository.existsById(it) } == true) {
            return false
        }
        val newPost: Post? = requestDto?.let { mapper.toPost(it) }
        newPost?.id = id;
        newPost?.let { repository.insert(it) }
        return true
    }

    fun delete(id: Long?): Boolean {
        try {
            id?.let { repository.deleteById(it) }
        } catch (e: Exception) {
            return false
        }
        return true
    }
}
