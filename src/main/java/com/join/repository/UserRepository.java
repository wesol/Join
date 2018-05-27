package com.join.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.join.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findOneByEmail(String email);

	// TODO method to activate user
	User findOneById(Long id);

}
