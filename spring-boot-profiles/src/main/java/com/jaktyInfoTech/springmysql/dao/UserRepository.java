package com.jaktyInfoTech.springmysql.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaktyInfoTech.springmysql.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

}
