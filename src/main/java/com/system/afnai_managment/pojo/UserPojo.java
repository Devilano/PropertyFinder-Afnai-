package com.system.afnai_managment.pojo;

import com.system.afnai_managment.entity.User;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserPojo {

    private String userName;
    private Integer id;
    private String email;
    private String mobileNo;
    private String password;

    public UserPojo(User user){
        this.id=user.getId();
        this.email=user.getEmail();
        this.userName=user.getUseernname();
        this.mobileNo=user.getMobileNo();
        this.password=user.getPassword();


    }
}
