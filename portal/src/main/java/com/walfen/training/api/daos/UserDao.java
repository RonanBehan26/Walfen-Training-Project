package com.walfen.training.api.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walfen.training.api.entities.User;

public interface UserDao extends JpaRepository<User, Long> {

}
