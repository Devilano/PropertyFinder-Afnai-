package com.system.afnai_managment.pojo;

import com.system.afnai_managment.entity.User;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserPojo {

    private String userName;
    private Integer U_id;
    private String email;
    private String mobileNo;
    private String password;
    private String OTP;
    private MultipartFile image;


    public UserPojo(User user){
        this.U_id=user.getU_id();
        this.email=user.getEmail();
        this.userName=user.getUseernname();
        this.mobileNo=user.getMobileNo();
        this.password=user.getPassword();
        this.OTP= user.getOTP();


    }
}
