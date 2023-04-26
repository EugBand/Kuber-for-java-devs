package com.epam.kuber.postsrv.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
class PostRequestDto {
    @JsonProperty("userId")
    private val userId: Long? = null

    @JsonProperty("text")
    private val text: String? = null

    @JsonProperty("status")
    private val status: String? = null
}
