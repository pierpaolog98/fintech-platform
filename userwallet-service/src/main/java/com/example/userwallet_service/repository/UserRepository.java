package com.example.userwallet_service.repository;

import com.example.userwallet_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
