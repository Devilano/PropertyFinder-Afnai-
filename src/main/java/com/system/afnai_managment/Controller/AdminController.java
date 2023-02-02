package com.system.afnai_managment.Controller;

import com.system.afnai_managment.entity.Property;
import com.system.afnai_managment.entity.User;
import com.system.afnai_managment.pojo.PropertyPojo;
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

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final PropertyService propertyService;

    @GetMapping("/Admin")
    public String getUserListAdmin(Model model) {
        List<User> users = userService.fetchAll();
        model.addAttribute("userList", users);
        return "User/AdminDashboard";
    }

    @PostMapping("/save")
    public String saveProperty(@Valid PropertyPojo propertyPojo) {
        propertyService.saveProperty(propertyPojo);
        return "User/propertylist";   //Write the pop box of sucess message
    }

    @GetMapping("/propertyList")    //This is for admin side to view teams and update delete
    public String getPropertyList(Model model) {
        List<Property> property = propertyService.fetchAll();
        model.addAttribute("propertyList", property);
        return "User/Propertylist";
    }

    @GetMapping("/create")
    public String createProperty(Model model) {
        model.addAttribute("property", new PropertyPojo());
        return "User/AddProperty";
    }

    @GetMapping("/edit/{id}")
    public String editProperty(@PathVariable("id") Integer id, Model model) {
        Property property = propertyService.fetchById(id);
        model.addAttribute("teams", new PropertyPojo(property));
        return "/User/create";
    }

    @GetMapping("/delete/{id}")
    public String deleteProperty(@PathVariable("id") Integer id) {
        System.out.println("delete");
        propertyService.deleteById(id);
        return "redirect:/teams/list";

    }


}