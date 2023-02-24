package com.system.afnai_managment;

import com.system.afnai_managment.entity.User;
import com.system.afnai_managment.repo.UserRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepo userRepo;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveUserTest(){
        User user = User.builder()
                .useernname("Rabi")
                .email("a@hg.com")
                .build();
        userRepo.save(user);
        Assertions.assertThat(user.getU_id()).isGreaterThan(0);
    }
    @Test
    @Order(2)
    public void getUserTest(){
        User userCreated=userRepo.findById(1).get();
        Assertions.assertThat(userCreated.getU_id()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void getListofUserTest(){
        User user = User.builder()
                .useernname("Rabi")
                .email("a@hg.com")
                .build();
        userRepo.save(user);
        List<User> User=userRepo.findAll();
        Assertions.assertThat(User.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateUserTest(){
        User user = User.builder()
                .useernname("Rabi")
                .email("a@hg.com")
                .build();
        userRepo.save(user);

        User userN=userRepo.findById(user.getU_id()).get();
        userN.setUseernname("Roman wagle");
        User userUpdated=userRepo.save(user);
//        Assertions.assertThat(userUpdated.getUsername()).isEqualTo("Roman wagle");
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteUserTest(){
        User user = User.builder()
                .useernname("Rabi")
                .email("a@hg.com")
                .build();
        userRepo.delete(user);
        User user1=null;
        Optional<User> optionalUser=userRepo.findById(0);
        if (optionalUser.isPresent()){
            user1=optionalUser.get();
        }
        Assertions.assertThat(user1).isNull();
    }


}
