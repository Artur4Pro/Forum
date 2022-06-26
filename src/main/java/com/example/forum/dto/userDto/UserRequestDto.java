package com.example.forum.dto.userDto;


import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class UserRequestDto implements Serializable {

    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;


}
