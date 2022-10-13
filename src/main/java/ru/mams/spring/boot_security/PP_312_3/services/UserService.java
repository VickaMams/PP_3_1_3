package ru.mams.spring.boot_security.PP_312_3.services;


import ru.mams.spring.boot_security.PP_312_3.models.User;

import java.util.List;

public interface UserService {
    User findByUsername(String username);

    public List<User> findAll();

    public User saveUser(User user);
    User getUser(Long id);
    public User findById(Long id);

    void deleteById(Long id);
}
