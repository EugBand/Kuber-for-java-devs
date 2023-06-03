package com.epam.kuber.postsrv.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
class PostResponseDto {
    @JsonProperty("id")
    var id: Long? = null

    @JsonProperty("userId")
    var userId: Long? = null

    @JsonProperty("text")
    var text: String? = null

    @JsonProperty("topic")
    var topic: String? = null

    @JsonProperty("status")
    var status: String? = null

    @JsonProperty("created")
    var created: LocalDateTime? = null

    @JsonProperty("modified")
    var modified: LocalDateTime? = null
}
