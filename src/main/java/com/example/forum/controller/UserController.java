package com.example.forum.controller;

import com.example.forum.dto.userDto.UserRequestDto;
import com.example.forum.dto.userDto.UserResponseDto;
import com.example.forum.dto.userDto.UserUpdateRequestDto;
import com.example.forum.dto.userDto.UserUpdateResponseDto;
import com.example.forum.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@AllArgsConstructor
public class

UserController {

    private final UserService userService;

    @GetMapping("/success")
    public String viewConfirmPage() {
        return "success";
    }

    @PostMapping("/creat")
    public UserUpdateResponseDto register(@RequestBody UserRequestDto request) {
        return userService.creatUser(request);
    }
    @PostMapping("/resetPassword")
    public UserUpdateResponseDto resetPassword(@RequestBody UserUpdateRequestDto userUpdateRequestDto ){
        return userService.resetPassword(userUpdateRequestDto.getEmail() );
    }
    @PostMapping("/updatePassword")
    public UserUpdateResponseDto updatePassword(@RequestBody UserUpdateRequestDto userUpdateRequestDto){
        return userService.updateUserPassword(userUpdateRequestDto.getToken(),userUpdateRequestDto.getPassword());
    }


    @GetMapping("/user/{username}")
    public UserResponseDto getUserByUserName(@PathVariable("username") String name){

        return userService.getByUserName(name);

    }

    @GetMapping("/userById/{id}")
    public UserResponseDto getUserByUserId(@PathVariable("id") Long id){

        return userService.getById(id);

    }

    @PostMapping("/changeRole")
    public UserUpdateResponseDto changeRole(@RequestBody UserUpdateRequestDto userUpdateRequestDto){
        return userService.changeRole(userUpdateRequestDto);
    }

    @PostMapping("/updateUser")
    public UserUpdateResponseDto removeUser(@RequestBody UserUpdateRequestDto userUpdateRequestDto){
        return userService.updateUser(userUpdateRequestDto);
    }

    @GetMapping("/getAllUsers")
    public List<UserResponseDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/getAllAdmins")
    public List<UserResponseDto> getAllAdmins(){
        return userService.getAllAdmins();
    }


}
