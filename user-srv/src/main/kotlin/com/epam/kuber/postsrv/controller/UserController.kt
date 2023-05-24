package com.epam.kuber.postsrv.controller

import com.epam.kuber.postsrv.dto.UserRequestDto
import com.epam.kuber.postsrv.dto.UserResponseDto
import com.epam.kuber.postsrv.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.PostMapping as PostMapping

@RestController
@RequestMapping(path = ["/api/v1/users"], produces = [MediaType.APPLICATION_JSON_VALUE])
class UserController(@Autowired val service: UserService) {
    @GetMapping("/{id}")
    private fun getById(@PathVariable id: Long): ResponseEntity<UserResponseDto> {
        return service.getById(id)
                .map { employee -> ResponseEntity(employee, HttpStatus.OK) }
                .orElseGet { ResponseEntity(HttpStatus.NOT_FOUND) }
    }

    @get:GetMapping
    val all: ResponseEntity<MutableList<UserResponseDto?>>
        get() {
            val users: MutableList<UserResponseDto?>? = service.all
            return ResponseEntity(users, HttpStatus.OK)
        }

    @PostMapping
    private fun add(@RequestBody user: UserRequestDto): ResponseEntity<Void> {
        return processResponse(service.saveFromDto(user), HttpStatus.CREATED)
    }

    @PatchMapping("/{id}")
    private fun update(@PathVariable id: Long, @RequestBody requestDto: UserRequestDto): ResponseEntity<Void> {
        return processResponse(service.update(id, requestDto), HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    private fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        return processResponse(service.delete(id), HttpStatus.NO_CONTENT)
    }

    private fun processResponse(result: Boolean, status: HttpStatus): ResponseEntity<Void> {
        return if (result) ResponseEntity(status) else ResponseEntity(HttpStatus.BAD_REQUEST)
    }
}
