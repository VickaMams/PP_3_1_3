package ru.mams.spring.boot_security.PP_312_3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mams.spring.boot_security.PP_312_3.models.User;
import ru.mams.spring.boot_security.PP_312_3.services.RoleService;
import ru.mams.spring.boot_security.PP_312_3.services.UserService;

import java.util.List;

@Controller
public class MyController {
    private final UserService userService;
    private final RoleService roleService;

    public MyController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }




    @RequestMapping("/admin")
    public String  showAllUsers(Model model){

        List<User> allUsers = userService.findAll();
        model.addAttribute("allUsers", allUsers);

        return "admin";
    }


    @RequestMapping("/addNewUser")
    public String addNewUser(Model model){

        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.listRoles());

        return "user";
    }

    @RequestMapping ("saveUser")
    public  String saveUser(@ModelAttribute("user") User user){

        userService.saveUser(user);

        return "redirect:/admin";
    }

//    @RequestMapping("/update")
//    public String updateUser(@RequestParam("userId") Long id, Model model){
//        System.out.println("UPDATE");
//        User user = userService.getUser(id);
//        model.addAttribute("user", user);
//        model.addAttribute("roles", roleService.listRoles());
//        return"user";
//    }
//
//
//
//
//    @RequestMapping("/delete")
//    public  String deleteUser(@RequestParam("userId") Long id){
//
//        userService.deleteUser(id);
//
//
//        return "redirect:/admin";
//    }

    @GetMapping("/admin/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.listRoles());

        return "user-update";
    }

    @PostMapping("/admin/user-update")
    public String updateUser(User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) { return "/user-update"; }
        else userService.saveUser(user);
        return "redirect:/admin";
    }

}
