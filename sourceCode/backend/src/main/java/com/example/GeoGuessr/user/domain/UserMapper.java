package com.example.GeoGuessr.user.domain;

import com.example.GeoGuessr.user.dto.UserRequest;
import com.example.GeoGuessr.user.dto.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "id", target = "id")
    UserResponse userToUserResponse(User user);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    User userRequestToUser(UserRequest user);
}
