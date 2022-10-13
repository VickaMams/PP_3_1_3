package ru.mams.spring.boot_security.PP_312_3.services;



import ru.mams.spring.boot_security.PP_312_3.models.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    void addRole(Role role);

    List<Role> listRoles();

    Role getRoleByID(Long id);

    Set<Role> findRolesByName(String roleName);
}