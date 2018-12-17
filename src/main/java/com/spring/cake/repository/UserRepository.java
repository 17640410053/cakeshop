package com.spring.cake.repository;

import com.spring.cake.model.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<UsersEntity, Integer> {
    UsersEntity findUsersEntityByMail(String mail);

    UsersEntity findUsersEntityByMailAndPassword(String mail, String password);
}
