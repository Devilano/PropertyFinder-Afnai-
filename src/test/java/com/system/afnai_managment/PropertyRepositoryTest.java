package com.system.afnai_managment;

import com.system.afnai_managment.entity.Property;
import com.system.afnai_managment.repo.PropertyRepo;
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
public class PropertyRepositoryTest {
    @Autowired
    private PropertyRepo propertyRepo;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void savePropertyTest(){
        Property property = Property.builder()
                .propertyName("butwal")
                .email("a@hg.com")
                .OwnerAddress("kathmandu")
                .PCity("Kathmandu")
                .areaSq("25")
                .location("loman")
                .mobileNo("9811529654")
                .ownerName("shirjan")
                .room("24")
                .build();

        propertyRepo.save(property);
        Assertions.assertThat(property.getP_id()).isGreaterThan(0);
    }
    @Test
    @Order(2)
    public void getPropertyTest(){
        Property userCreated=propertyRepo.findById(1).get();
        Assertions.assertThat(userCreated.getP_id()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void getListofPropertyTest(){
        Property property = Property.builder()
                .propertyName("butwal")
                .email("a@hg.com")
                .OwnerAddress("kathmandu")
                .PCity("Kathmandu")
                .areaSq("25")
                .location("loman")
                .mobileNo("9811529654")
                .ownerName("shirjan")
                .room("24")
                .build();
        propertyRepo.save(property);
        List<Property> Property=propertyRepo.findAll();
        Assertions.assertThat(Property.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
//    @Rollback(value = false)
    public void updateUserTest(){
        Property property = Property.builder()
                .propertyName("butwal")
                .email("a@hg.com")
                .OwnerAddress("kathmandu")
                .PCity("Kathmandu")
                .areaSq("25")
                .location("loman")
                .mobileNo("9811529654")
                .ownerName("shirjan")
                .room("24")
                .build();
        propertyRepo.save(property);
        Property property1=propertyRepo.findById(property.getP_id()).get();
        property1.setPropertyName("butwal");
        Property userUpdated=propertyRepo.save(property);
        Assertions.assertThat(userUpdated.getPropertyName()).isEqualTo("butwal");
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deletePropertyTest(){
        Property property = Property.builder()
                .propertyName("butwal")
                .email("a@hg.com")
                .build();
        propertyRepo.delete(property);
        Property property1=null;
        Optional<Property> optionalUser=propertyRepo.findByEmail("a@hg.com");
        if (optionalUser.isPresent()){
            property1=optionalUser.get();
        }
        Assertions.assertThat(property1).isNull();
    }


}
