package com.system.afnai_managment.pojo;
import com.system.afnai_managment.entity.Feed;
import com.system.afnai_managment.entity.Property;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedPojo {

    private Integer F_id;
    private String fullName;
    private String requirement;
    private String budget;

    private String email;
    private String mobileNo;


    public FeedPojo(Feed feed){
        this.F_id= feed.getF_id();
        this.fullName=feed.getFullName();
        this.requirement=feed.getRequirement();
        this.email=feed.getEmail();
        this.mobileNo=feed.getMobileNo();
        this.budget=feed.getBudget();


    }

}
