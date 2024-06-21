package com.example.GeoGuessr.user.domain;

import com.example.GeoGuessr.user.dto.UserRequest;
import com.example.GeoGuessr.user.dto.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponse userToUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        String username = null;
        String password = null;
        long id = 0L;

        username = user.getUsername();
        password = user.getPassword();
        id = user.getId();

        UserResponse userResponse = new UserResponse( id, username, password );

        return userResponse;
    }

    @Override
    public User userRequestToUser(UserRequest user) {
        if ( user == null ) {
            return null;
        }

        User.UserBuilder user1 = User.builder();

        user1.username( user.username() );
        user1.password( user.password() );

        return user1.build();
    }
}