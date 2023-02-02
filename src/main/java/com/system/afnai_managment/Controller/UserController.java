package com.system.afnai_managment.Controller;

import com.system.afnai_managment.entity.Property;
import com.system.afnai_managment.entity.User;
import com.system.afnai_managment.pojo.UserPojo;
import com.system.afnai_managment.service.PropertyService;
import com.system.afnai_managment.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final PropertyService propertyService;

    @GetMapping("/list")
    public String getUserList(Model model) {
        List<User> users = userService.fetchAll();
        model.addAttribute("userList", users);
        return "User/index";
    }

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new UserPojo());
        return "User/create";
    }


    @PostMapping("/save")
    public String saveUser(@Valid UserPojo userPojo) {
        userService.saveUser(userPojo);
        return "User/login"; //
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Integer id,Model model){
        User user =userService.fetchById(id);
        model.addAttribute("user",new UserPojo(user));
        return "User/AddProperty";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        userService.delteById(id);
        return "redirect:/user/list";
    }

    @GetMapping("/home")
    public String getHome(Model model) {
        return "User/Home";
    }

    @GetMapping("/sendEmail")
    public String sendRegistrationEmail(){
        this.userService.sendEmail();
        return "emailsucess";
    }

    @GetMapping("/property") //This is for user side
    public String getTeamsList(Model model, Principal principal) {
        List<Property> property = propertyService.fetchAll();
        model.addAttribute("propertyList", property);
        model.addAttribute("logged",userService.findByEmail(principal.getName()));
        return "User/Property";
    }





}

