package com.epam.kuber.postsrv.controller

import com.epam.kuber.postsrv.dto.PostRequestDto
import com.epam.kuber.postsrv.dto.PostResponseDto
import com.epam.kuber.postsrv.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/api/v1/posts"], produces = [MediaType.APPLICATION_JSON_VALUE])
class PostController(@Autowired val service: PostService) {

    @get:GetMapping
    private val all: ResponseEntity<MutableList<PostResponseDto?>>
        get() {
            val tasks: MutableList<PostResponseDto?>? = service.all
            return ResponseEntity.ok(tasks)
        }

    @GetMapping("/user/{id}")
    private fun getAmountByUserId(@PathVariable id: Long): ResponseEntity<Int> {
        val count: Int? = service.getCountByUserId(id)
        return if (count == null) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        } else ResponseEntity(count, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    private fun getById(@PathVariable id: Long): ResponseEntity<PostResponseDto> {
        return service.getById(id).map { value -> ResponseEntity(value, HttpStatus.OK) }
                .orElse(ResponseEntity(HttpStatus.NOT_FOUND))
    }

    @PostMapping
    private fun add(@RequestBody requestDto: PostRequestDto): ResponseEntity<Void> {
        return if (service.save(requestDto)) {
            ResponseEntity(HttpStatus.CREATED)
        } else {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping("/search")
    private fun getById(@RequestParam search: String, @RequestParam status: String,
                        @RequestParam order: Long): ResponseEntity<MutableList<PostResponseDto?>> {
        val response: MutableList<PostResponseDto?>? = service.search(search, status, order)
        return if (response?.isEmpty() == true) ResponseEntity<MutableList<PostResponseDto?>>(HttpStatus.OK)
        else ResponseEntity.ok(response)
    }

    @PatchMapping("/{id}")
    private fun update(@PathVariable id: Long, @RequestBody requestDto: PostRequestDto): ResponseEntity<Void> {
        return if (service.update(id, requestDto)) {
            ResponseEntity(HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @DeleteMapping("/{id}")
    private fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        return processResponse(service.delete(id), HttpStatus.NO_CONTENT)
    }

    private fun processResponse(result: Boolean, status: HttpStatus): ResponseEntity<Void> {
        return if (result) ResponseEntity(status) else ResponseEntity(HttpStatus.BAD_REQUEST)
    }
}
