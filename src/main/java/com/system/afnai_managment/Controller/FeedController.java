package com.system.afnai_managment.Controller;

import com.system.afnai_managment.pojo.FeedPojo;
import com.system.afnai_managment.service.FeedService;
import jakarta.validation.Valid;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;


@Builder
@Controller
@RequiredArgsConstructor
@RequestMapping("/feed")

public class FeedController {

    private final FeedService feedService;
    @PostMapping("/save")
    public String saveFeed(@Valid FeedPojo feedPojo) throws IOException {
        feedService.saveFeed(feedPojo);
        return "User/Home";   //Write the pop box of sucess message
    }


//    @GetMapping("/feedList") //This is for to see the order in the order list by Admin
//    public String getFeedList(Model model) {
//        List<Feed> feed = feedService.fetchAll();
//        model.addAttribute("feedList", feed);
//        return "User/FeedList";
//    }



}
