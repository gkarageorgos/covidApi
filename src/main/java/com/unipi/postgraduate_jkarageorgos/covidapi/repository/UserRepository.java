package com.unipi.postgraduate_jkarageorgos.covidapi.repository;

import com.unipi.postgraduate_jkarageorgos.covidapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
