package com.ibrahim.test.repo;

import com.ibrahim.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
     public User findByYas(String yas);


}
