package com.epam.kuber.postsrv.mapper

import com.epam.kuber.postsrv.dto.AddressDto
import com.epam.kuber.postsrv.dto.UserRequestDto
import com.epam.kuber.postsrv.dto.UserResponseDto
import com.epam.kuber.postsrv.model.Address
import com.epam.kuber.postsrv.model.User
import org.mapstruct.CollectionMappingStrategy
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import java.util.*

@Mapper(componentModel = "spring", collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE)
interface UserMapper {
    @Mapping(target = "address", expression = "java(toAddress(requestDto.getAddress(), requestDto.getId()))")
    @Mapping(target = "amountOfPosts", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "modified", ignore = true)
    fun toUserFromRequestDto(requestDto: UserRequestDto): User

    @Mapping(target = "address", source = "address")
    fun toResponseDto(user: User): UserResponseDto
    fun toAddress(addressDto: AddressDto, userId: Long): Address
    fun toAddressDto(address: Address): AddressDto
}
