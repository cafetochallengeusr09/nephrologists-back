package com.cafeto.challenge.user.repository;

import com.cafeto.challenge.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);

}
