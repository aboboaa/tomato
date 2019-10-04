package com.tomato.dao;

import com.tomato.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User,Integer> {

}
