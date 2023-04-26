package com.epam.kuber.postsrv.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
class PostResponseDto {
    @JsonProperty("id")
    private val id: Long? = null

    @JsonProperty("userId")
    private val userId: Long? = null

    @JsonProperty("text")
    private val text: String? = null

    @JsonProperty("status")
    private val status: String? = null

    @JsonProperty("created")
    private val created: LocalDateTime? = null

    @JsonProperty("modified")
    private val modified: LocalDateTime? = null
}
