package com.epam.kuber.postsrv.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
class PostRequestDto {
    @JsonProperty("userId")
    var userId: Long? = null

    @JsonProperty("text")
    var text: String? = null

    @JsonProperty("topic")
    var topic: String? = null

    @JsonProperty("status")
    var status: String? = null
}
