package com.ibrahim.test.services.imp;

import com.ibrahim.test.entity.User;
import com.ibrahim.test.repo.UserRepository;
import com.ibrahim.test.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private  final UserRepository userrepository;

    @Override
    public User createUser(User user) {
        user.setCreatedDate(new Date());
        user.setCreatedBy("ibrahim");


        return userrepository.save(user);
    }
    @Override
    public User userCreate(User user){
        return  userrepository.save(user);
    }


    @Override
    public List<User> getUsers(){
        return  userrepository.findAll();
    }

    @Override
    public User getById(Long id) {
        Optional <User>  user = userrepository.findById(id);
        if (user.isEmpty()){
            return null;
        }
        return user.get();

    }
    @Override
    public  User updateUser(Long id,User user){
        Optional <User> userslist=userrepository.findById(id);
        if(userslist.isEmpty()) return null;
        else {
            userslist.get().setAd(user.getAd());
            userslist.get().setSoyad(user.getSoyad());
            userslist.get().setYas(user.getYas());
            userslist.get().setUpdateBy("root");


            return userrepository.save(userslist.get()) ;
        }

    }

    @Override
    public  Boolean deleteUser(Long id){
        Optional <User> userlist=userrepository.findById(id);
        if(userlist.isEmpty()){
            return false;
        }
        else{
            userrepository.deleteById(id);
            return true;
        }


    }


}
