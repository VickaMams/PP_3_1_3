package ru.mams.spring.boot_security.PP_312_3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mams.spring.boot_security.PP_312_3.models.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
