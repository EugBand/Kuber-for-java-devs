package com.epam.kuber.postsrv.service

import com.epam.kuber.postsrv.dto.UserRequestDto
import com.epam.kuber.postsrv.dto.UserResponseDto
import com.epam.kuber.postsrv.mapper.UserMapper
import com.epam.kuber.postsrv.model.User
import com.epam.kuber.postsrv.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import java.util.*
import kotlin.Boolean
import kotlin.Exception
import kotlin.Long

@Service
class UserService(@Autowired val mapper: UserMapper,
        @Autowired val repository: UserRepository,
        @Autowired val postApiClient: WebClient) {

    val all: MutableList<UserResponseDto?>?
        get() = repository.findAll().stream().map { it?.let { it1 -> mapper.toResponseDto(it1) } }.toList()

    fun saveFromDto(requestDto: UserRequestDto?): Boolean {
        return try {
            val user: User? = requestDto?.let { mapper.toUserFromRequestDto(it) }
            user?.let { repository.save(it) }
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getById(id: Long): Optional<UserResponseDto> {
        return try {
            val userDto: Optional<UserResponseDto> = repository.findById(id).stream().map(mapper::toResponseDto).findFirst()
            val amountOfPosts: Mono<Long> = postApiClient
                    .get()
                    .uri("user/$id")
                    .retrieve()
                    .bodyToMono(Long::class.java)
            userDto.ifPresent { u: UserResponseDto -> u.amountOfPosts = amountOfPosts.toFuture().join() }
            userDto
        } catch (e: Exception) {
            Optional.empty()
        }
    }

    fun update(id: Long?, requestDto: UserRequestDto?): Boolean {
        return try {
            if (id?.let { repository.existsById(it) } == true) {
                return false
            }
            val user: User? = requestDto?.let { mapper.toUserFromRequestDto(it) }
            user?.id = id
            user?.let { repository.save(it) }
            true
        } catch (e: Exception) {
            false
        }
    }

    fun delete(id: Long?): Boolean {
            if (id != null) {
                repository.deleteById(id)
            }
        return false
    }
}
