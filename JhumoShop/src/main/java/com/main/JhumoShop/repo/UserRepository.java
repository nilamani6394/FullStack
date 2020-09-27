package com.main.JhumoShop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.JhumoShop.midelData.User;

public interface UserRepository extends JpaRepository<User, Long> {
	

}
