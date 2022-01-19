package com.yeuyar.todo.repository;

import com.yeuyar.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUserName(String userName);
}
