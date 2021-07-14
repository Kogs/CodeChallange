package de.kogs.codechallange.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import de.kogs.codechallange.data.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    @Query
    public Collection<User> findByFirstNameIgnoreCase(String name);

}
