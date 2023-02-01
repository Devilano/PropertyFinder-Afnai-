package com.system.afnai_managment.Controller;

import com.system.afnai_managment.entity.User;
import com.system.afnai_managment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    @GetMapping("/Admin")
    public String getUserListAdmin(Model model) {
        List<User> users = userService.fetchAll();
        model.addAttribute("userList", users);
        return "User/AdminDashboard";
    }


}
