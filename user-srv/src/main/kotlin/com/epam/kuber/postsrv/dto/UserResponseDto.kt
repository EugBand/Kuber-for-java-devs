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
    var id: Long? = null

    @JsonProperty("firstName")
    var firstName: String? = null

    @JsonProperty("lastName")
    var lastName: String? = null

    @JsonProperty("sex")
    var sex: String? = null

    @JsonProperty("dob")
    @JsonDeserialize(using = LocalDateDeserializer::class)
    @JsonSerialize(using = LocalDateSerializer::class)
    var dob: LocalDate? = null

    @JsonProperty("address")
    var address: AddressDto? = null

    @JsonProperty("amountOfPosts")
    var amountOfPosts: Long? = null

    @JsonProperty("position")
    var position: String? = null

    @JsonProperty("active")
    var active: Boolean? = null

    @JsonProperty("created")
    var created: LocalDateTime? = null

    @JsonProperty("modified")
    var modified: LocalDateTime? = null
}
