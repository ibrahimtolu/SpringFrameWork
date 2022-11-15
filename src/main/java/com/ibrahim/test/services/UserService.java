package com.ibrahim.test.services;

import com.ibrahim.test.entity.User;
import com.ibrahim.test.repo.UserRepository;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);

    List<User> getUsers();
    User getById(Long id);
    User updateUser(Long id,User user);
    Boolean deleteUser(Long id);
    User userCreate(User user);




}
