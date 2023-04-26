package com.epam.kuber.postsrv.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import java.time.LocalDate
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
class UserResponseDto {
    @JsonProperty("id")
    val id: Long? = null

    @JsonProperty("firstName")
    val firstName: String? = null

    @JsonProperty("lastName")
    val lastName: String? = null

    @JsonProperty("sex")
    val sex: String? = null

    @JsonProperty("dob")
    @JsonDeserialize(using = LocalDateDeserializer::class)
    @JsonSerialize(using = LocalDateSerializer::class)
    val dob: LocalDate? = null

    @JsonProperty("address")
    var address: AddressDto? = null

    @JsonProperty("amountOfPosts")
    var amountOfPosts: Long? = null

    @JsonProperty("position")
    val position: String? = null

    @JsonProperty("active")
    val active: Boolean? = null

    @JsonProperty("created")
    val created: LocalDateTime? = null

    @JsonProperty("modified")
    val modified: LocalDateTime? = null
}
