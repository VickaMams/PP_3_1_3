package ru.mams.spring.boot_security.PP_312_3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mams.spring.boot_security.PP_312_3.models.User;
import ru.mams.spring.boot_security.PP_312_3.services.RoleService;
import ru.mams.spring.boot_security.PP_312_3.services.UserService;

import java.security.Principal;

@Controller
public class MyController {
    private final UserService userService;
    private final RoleService roleService;

    public MyController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping("/admin")
    public String findAll(Model model,Principal principal){


        model.addAttribute("admin", userService.findByUsername(principal.getName()));
        model.addAttribute("users", userService.findAll());
        model.addAttribute("roles", roleService.listRoles());
        model.addAttribute("newUser", new User());

        return "admin";
    }


    @PostMapping("/admin/create")
    public String createUser(@ModelAttribute("user") User user) {

        userService.saveUser(user);

        return "redirect:/admin";
    }


    @DeleteMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "redirect:/admin";
    }

    @PostMapping("/admin/update/{id}")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam(value = "role") String role) {
        user.setRoles(roleService.findRolesByName(role));
        userService.saveUser(user);
        return "redirect:/admin";
    }

}
