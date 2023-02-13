package com.system.afnai_managment.Controller;

import com.system.afnai_managment.entity.Feed;
import com.system.afnai_managment.entity.Property;
import com.system.afnai_managment.entity.User;
import com.system.afnai_managment.pojo.PropertyPojo;
import com.system.afnai_managment.pojo.UserPojo;
import com.system.afnai_managment.service.FeedService;
import com.system.afnai_managment.service.PropertyService;
import com.system.afnai_managment.service.UserService;
import jakarta.validation.Valid;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.Principal;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final PropertyService propertyService;
    private final FeedService feedService;

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/Gallery";

    @GetMapping("/Admin")
    public String getUserListAdmin(Model model) {
        List<User> users = userService.fetchAll();
        model.addAttribute("userList", users);
        return "User/AdminDashboard";
    }

    @PostMapping("/save")
    public String saveProperty(@Valid PropertyPojo propertyPojo) throws IOException {
        propertyService.saveProperty(propertyPojo);
        return "User/propertylist";   //Write the pop box of sucess message
    }



    @GetMapping("/propertyList")    //This is for admin side to view teams and update delete
    public String getPropertyList(Model model) {
        List<Property> property = propertyService.fetchAll();
        model.addAttribute("propertyList", property.stream().map(user ->
                Property.builder()
                        .P_id(user.getP_id())
                        .imageBase64(getImageBase64(user.getImage()))
                        .propertyName(user.getPropertyName())
                        .areaSq(user.getAreaSq())
                        .room(user.getRoom())
                        .location(user.getLocation())
                        .PCity(user.getPCity())
                        .ownerName(user.getOwnerName())
                        .OwnerAddress(user.getOwnerAddress())
                        .email(user.getEmail())
                        .mobileNo(user.getMobileNo())
                        .build()
        ));

        return "User/Propertylist";
    }

    @GetMapping("/create")
    public String createProperty(Model model) {
        model.addAttribute("property", new PropertyPojo());
        return "User/AddProperty";
    }

    @GetMapping("/edit/{P_id}")
    public String editProperty(@PathVariable("P_id") Integer id, Model model) {
        Property property = propertyService.fetchById(id);
        model.addAttribute("teams", new PropertyPojo(property));
        return "/User/AddProperty";
    }

    @GetMapping("/delete/{P_id}")
    public String deleteProperty(@PathVariable("P_id") Integer P_id) {
        System.out.println("delete");
        propertyService.deleteById(P_id);
        return "redirect:/User/PropertyList";

    }
    @GetMapping("/delete/{U_id}")
    public String deleteById(@PathVariable("U_id") Integer id){
        userService.delteById(id);
        return "redirect:/user/list";
    }

    @GetMapping("/orderList") //This is for to see the order in the order list by Admin
    public String getTeamsList(Model model, Principal principal) {
        List<Property> property = propertyService.fetchAll();
        model.addAttribute("propertyList", property);
        model.addAttribute("logged",userService.findByEmail(principal.getName()));
        return "User/orderList";
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

    @GetMapping("/feedList") //This is for to see the order in the order list by Admin
    public String getFeedList(Model model) {
        List<Feed> feed = feedService.fetchAll();
        model.addAttribute("feedList", feed);
        return "User/FeedList";
    }



}
