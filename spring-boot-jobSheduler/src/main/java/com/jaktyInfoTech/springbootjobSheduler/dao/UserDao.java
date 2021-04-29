package com.jaktyInfoTech.springbootjobSheduler.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jaktyInfoTech.springbootjobSheduler.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
	

}
