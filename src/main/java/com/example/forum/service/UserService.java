package com.example.forum.service;

import com.example.forum.dto.userDto.UserRequestDto;
import com.example.forum.dto.userDto.UserResponseDto;
import com.example.forum.dto.userDto.UserUpdateRequestDto;
import com.example.forum.dto.userDto.UserUpdateResponseDto;

import java.util.List;

public interface UserService {
    UserUpdateResponseDto creatUser(UserRequestDto user);
    UserResponseDto getByUserName(String userName);
    UserResponseDto getById( Long id);
    List<UserResponseDto> getAllUsers();
    List<UserResponseDto> getAllAdmins();

    UserUpdateResponseDto updateUser(UserUpdateRequestDto userUpdateRequestDto);

    UserUpdateResponseDto changeRole(UserUpdateRequestDto userUpdateRequestDto);

    UserUpdateResponseDto resetPassword(String email);

    UserUpdateResponseDto updateUserPassword(String token, String password);
}
