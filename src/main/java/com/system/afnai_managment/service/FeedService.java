package com.system.afnai_managment.service;
import com.system.afnai_managment.entity.Feed;
import com.system.afnai_managment.entity.Property;
import com.system.afnai_managment.pojo.FeedPojo;


import java.io.IOException;
import java.util.List;

public interface FeedService {

    Property fetchByF_id(Integer F_id);

    String saveFeed(FeedPojo feedPojo) throws IOException;
    List<Feed> fetchAll();

    void deleteById(Integer F_id);

}
