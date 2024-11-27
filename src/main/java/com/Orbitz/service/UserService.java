package com.Orbitz.service;

import com.Orbitz.entity.User;
import com.Orbitz.exception.AdminException;
import com.Orbitz.exception.UserException;
import com.Orbitz.payload.UserDto;

public interface UserService {
    UserDto registerUser(UserDto dto) throws UserException;

    UserDto registerPropertyOwner(UserDto dto) throws UserException;

    UserDto registerPropertyManager(UserDto dto) throws UserException;

    UserDto registerAdmin(UserDto dto) throws AdminException;

    UserDto getUserDetailsById(User user);

    void deleteUser(User user);

    UserDto updateUser(User user, UserDto dto);
}
