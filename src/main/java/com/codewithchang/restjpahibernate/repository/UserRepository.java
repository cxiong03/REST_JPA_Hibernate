package com.codewithchang.restjpahibernate.repository;

import com.codewithchang.restjpahibernate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
