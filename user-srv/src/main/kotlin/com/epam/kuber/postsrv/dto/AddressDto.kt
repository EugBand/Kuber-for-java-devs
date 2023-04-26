package com.epam.kuber.postsrv.dto

import com.fasterxml.jackson.annotation.JsonProperty

class AddressDto {
    @JsonProperty("country")
    val country: String? = null

    @JsonProperty("city")
    val city: String? = null

    @JsonProperty("postCode")
    val postCode: String? = null

    @JsonProperty("address")
    val localAddress: String? = null
}
