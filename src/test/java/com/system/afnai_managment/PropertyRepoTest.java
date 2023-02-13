package com.system.afnai_managment;

import com.system.afnai_managment.entity.Property;
import com.system.afnai_managment.entity.User;
import com.system.afnai_managment.repo.PropertyRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)



public class PropertyRepoTest {

    @Autowired
    private PropertyRepo propertyRepo;
    @Test
    @Order(1)
    @Rollback(value = false)
    public void savePropertyTest() {

        Property property = Property.builder()
                .propertyName("Bangloo")
                .OwnerAddress("Kathmandu")
                .PCity("Butwal")
                .areaSq("25")
                .ownerName("nawain")
                .email("wrabwagle123@gmail.com")
                .location("thamel")
                .room("3")
                .mobileNo("9811529654")
                .build();

        propertyRepo.save(property);

        Assertions.assertThat(property.getP_id()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public  void getPropertyTest(){
//        User userN=userRepo.findById(user.getU_id()).get();
        Property propertyCreated= propertyRepo.findById(1).get();
        Assertions.assertThat(propertyCreated.getP_id()).isEqualTo(1);
    }




}
