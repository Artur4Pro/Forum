package com.example.forum.convertor;

import com.example.forum.dto.userDto.UserResponseDto;
import com.example.forum.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConvertor {

    public UserResponseDto toUserDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setUserId(user.getId());
        userResponseDto.setFirstName(user.getFirstName());
        userResponseDto.setLastName(user.getLastName());
        userResponseDto.setUserName(user.getUserName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setVerification(user.getEnabled());
        userResponseDto.setRole(user.getRoles().ordinal());
        return userResponseDto;
    }

}
