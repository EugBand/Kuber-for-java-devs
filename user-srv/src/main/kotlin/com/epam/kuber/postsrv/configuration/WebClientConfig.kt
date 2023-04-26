package com.epam.kuber.postsrv.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig {
    @Value("\${api.post-srv.path}")
    val postServicePath: String = "http://localhost:8091/api/v1/posts/"

    @Bean("resource-srv")
    fun resourceApiClient(): WebClient {
        return  WebClient.create(postServicePath)
    }
}
