package com.epam.kuber.postsrv.mapper

import com.epam.kuber.postsrv.dto.PostRequestDto
import com.epam.kuber.postsrv.dto.PostResponseDto
import com.epam.kuber.postsrv.model.Post
import org.mapstruct.CollectionMappingStrategy
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring", collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE)
interface PostMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "modified", ignore = true)
//    @Mapping(target = "userId", source = "userId")
//    @Mapping(target = "text", source = "text")
//    @Mapping(target = "status", source = "status")
    fun toPost(requestDto: PostRequestDto): Post

    fun toTaskResponseDto(post: Post): PostResponseDto
}
