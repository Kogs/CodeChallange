package de.kogs.codechallange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.kogs.codechallange.data.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
}
