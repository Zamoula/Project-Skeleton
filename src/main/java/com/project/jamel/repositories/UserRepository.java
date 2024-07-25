package com.project.jamel.repositories;

import com.project.jamel.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends GenericRepository<User, Long>{
}
