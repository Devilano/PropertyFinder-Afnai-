package com.system.afnai_managment.Controller;

import com.system.afnai_managment.entity.Property;
import com.system.afnai_managment.entity.User;
import com.system.afnai_managment.pojo.OrderPojo;
import com.system.afnai_managment.pojo.PropertyPojo;
import com.system.afnai_managment.pojo.UserPojo;
import com.system.afnai_managment.service.OrderService;
import com.system.afnai_managment.service.PropertyService;
import com.system.afnai_managment.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.Principal;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final PropertyService propertyService;
    private final OrderService orderService;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/Gallery";


    @GetMapping("/list")
    public String getUserList(Model model) {
        List<User> users = userService.fetchAll();
        model.addAttribute("userList", users.stream().map(user ->
                User.builder()
                        .U_id(user.getU_id())
                        .imageBase64(getImageBase64(user.getImage()))
                        .email(user.getEmail())
                        .useernname(user.getUseernname())
                        .mobileNo(user.getMobileNo())
                        .build()
        ));
        return "User/index";
    }

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new UserPojo());
        return "User/create";
    }



    public Map<String, String> validateRequest(BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            return null;
        }
        Map<String, String> errors = new HashMap<>();
        bindingResult.getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return errors;

    }


    @PostMapping("/save")
    public String createUser(@Valid UserPojo userPojo,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {

        Map<String, String> requestError = validateRequest(bindingResult);
        if (requestError != null) {
            redirectAttributes.addFlashAttribute("requestError", requestError);
            return "redirect:/user/register";
        }

        userService.saveUser(userPojo);
        redirectAttributes.addFlashAttribute("successMsg", "User saved successfully");

        return "User/login";
    }
    @PostMapping("/saveOrder")
    public String saveOrder(@Valid OrderPojo orderPojo,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {

        Map<String, String> requestError = validateRequest(bindingResult);
        if (requestError != null) {
            redirectAttributes.addFlashAttribute("requestError", requestError);
            return "redirect:/user/register";
        }

        orderService.saveOrder(orderPojo);
        redirectAttributes.addFlashAttribute("successMsg", "User saved successfully");

        return "User/Property";
    }

    @GetMapping("/edit/{U_id}")
    public String editUser(@PathVariable("U_id") Integer id,Model model){
        User user =userService.fetchById(id);
        model.addAttribute("user",new UserPojo(user));
        return "User/AddProperty";
    }

    @GetMapping("/delete/{U_id}")
    public String deleteById(@PathVariable("U_id") Integer id){
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
        model.addAttribute("logged",userService.findByEmail(principal.getName()));
        model.addAttribute("user", property);
        return "User/Property";
    }

    public String getImageBase64(String fileName) {
        String filePath = System.getProperty("user.dir") + "/Gallery/";
        File file = new File(filePath + fileName);
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return base64;
    }








}

