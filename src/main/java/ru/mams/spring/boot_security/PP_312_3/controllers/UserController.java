package ru.mams.spring.boot_security.PP_312_3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mams.spring.boot_security.PP_312_3.services.RoleService;
import ru.mams.spring.boot_security.PP_312_3.services.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String pageUser(Principal principal, Model model) {
        model.addAttribute("user", userService.findByUsername(principal.getName()));
        model.addAttribute("roles", roleService.listRoles());
        return "/user";
    }

    @GetMapping("/{id}")
    public String pageUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("roles", roleService.listRoles());
        model.addAttribute("user", userService.findById(id));
        return "/user";
    }

}
