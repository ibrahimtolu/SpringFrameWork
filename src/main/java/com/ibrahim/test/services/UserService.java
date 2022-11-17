package com.ibrahim.test.services;

import com.ibrahim.test.entity.User;
import com.ibrahim.test.userdto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    List<UserDto> getUsers();

    UserDto getById(Long id);

    UserDto updateUser(Long id, UserDto user);

    Boolean deleteUser(Long id);


}
