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

    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "sex", source = "sex")
    @Mapping(target = "dob", source = "dob")
    @Mapping(target = "amountOfPosts", source = "amountOfPosts")
    @Mapping(target = "position", source = "position")
    @Mapping(target = "active", source = "active")
    @Mapping(target = "created", source = "created")
    @Mapping(target = "modified", source = "modified")
    fun toResponseDto(user: User): UserResponseDto

    fun toAddress(addressDto: AddressDto, userId: Long): Address

    @Mapping(target = "country", source = "country")
    @Mapping(target = "city", source = "city")
    @Mapping(target = "postCode", source = "postCode")
    @Mapping(target = "localAddress", source = "localAddress")
    fun toAddressDto(address: Address): AddressDto
}
