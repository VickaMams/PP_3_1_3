package ru.mams.spring.boot_security.PP_312_3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.mams.spring.boot_security.PP_312_3.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    User findByUsername(String username);
}
