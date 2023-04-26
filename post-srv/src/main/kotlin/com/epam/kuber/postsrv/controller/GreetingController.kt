package com.epam.kuber.postsrv.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/api/v1/greeting"])
class GreetingController {
    @GetMapping
    private fun greeting(): ResponseEntity<String> {
        return ResponseEntity(GREETING, HttpStatus.OK)
    }

    companion object {
        const val GREETING = "Hello, k8s!"
    }
}
