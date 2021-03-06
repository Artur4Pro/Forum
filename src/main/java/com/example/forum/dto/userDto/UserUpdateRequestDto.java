package com.example.forum.dto.userDto;

import com.example.forum.enams.Roles;
import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class UserUpdateRequestDto {
    private String userName;
    private String token;
    private String password;
    private Long id;
    private String email;
    private Boolean status;
    private Roles roles;
}
