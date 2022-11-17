package com.ibrahim.test.services.imp;

import com.ibrahim.test.entity.User;
import com.ibrahim.test.repo.UserRepository;
import com.ibrahim.test.services.UserService;
import com.ibrahim.test.userdto.UserDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userrepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user.setCreatedDate(new Date());
        user.setCreatedDate(new Date());
        user.setCreatedBy("ibrahim");


        return modelMapper.map(userrepository.save(user), UserDto.class);
    }


    @Override
    public List<UserDto> getUsers() {
        List<User> users = userrepository.findAll();
        List<UserDto> userDtosList = users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return userDtosList;
    }

    @Override
    public UserDto getById(Long id) {
        Optional<User> user = userrepository.findById(id);

        if (user.isEmpty()) {
            return null;
        }
        return modelMapper.map(user.get(), UserDto.class);
    }

    @Override
    public UserDto updateUser(Long id, UserDto user) {
        Optional<User> userslist = userrepository.findById(id);
        if (userslist.isEmpty()) return null;
        else {

            userslist.get().setAd(user.getAd());
            userslist.get().setSoyad(user.getSoyad());
            userslist.get().setYas(user.getYas());
            userslist.get().setUpdateBy("root");
            userslist.get().setUpdatedAt(new Date());


            return modelMapper.map(userrepository.save(userslist.get()), UserDto.class);
        }

    }

    @Override
    public Boolean deleteUser(Long id) {
        Optional<User> userlist = userrepository.findById(id);
        if (userlist.isEmpty()) {
            return false;
        } else {
            userrepository.deleteById(id);
            return true;
        }


    }


}
