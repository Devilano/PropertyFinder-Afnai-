package com.system.afnai_managment.service.impl;
import com.system.afnai_managment.entity.Feed;
import com.system.afnai_managment.entity.Property;
import com.system.afnai_managment.pojo.FeedPojo;
import com.system.afnai_managment.repo.FeedRepo;
import com.system.afnai_managment.service.FeedService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedServiceImpl implements FeedService {
    public final FeedRepo feedRepo;

    @Override
    public Property fetchByF_id(Integer F_id) {
        return null;
    }

    public String saveFeed(FeedPojo feedPojo) throws IOException {
        Feed feed = new Feed();
        feed.setFullName(feedPojo.getFullName());
        feed.setEmail(feedPojo.getEmail());
        feed.setMobileNo(feedPojo.getMobileNo());

        feed.setRequirement(feedPojo.getRequirement());
        feed.setBudget(feedPojo.getBudget());
        feedRepo.save(feed);
        return "created";
    }



    @Override
    public List<Feed> fetchAll() {
        return feedRepo.findAll();
    }
    @Override
    public void deleteById(Integer F_id) {
        feedRepo.deleteById(F_id);
    }


}

