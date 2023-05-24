package com.epam.kuber.postsrv.dto

import com.fasterxml.jackson.annotation.JsonProperty

class AddressDto(


    @JsonProperty("country")
    var country: String? = null,

    @JsonProperty("city")
    var city: String? = null,

    @JsonProperty("postCode")
    var postCode: String? = null,

    @JsonProperty("address")
    var localAddress: String? = null
)
