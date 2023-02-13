package com.system.afnai_managment.service.impl;
import com.system.afnai_managment.entity.Property;
import com.system.afnai_managment.pojo.PropertyPojo;
import com.system.afnai_managment.repo.PropertyRepo;
import com.system.afnai_managment.service.PropertyService;
import lombok.RequiredArgsConstructor;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {
    public final PropertyRepo propertyRepo;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/House";


    public String saveProperty(PropertyPojo propertyPojo) throws IOException {
        Property property = new Property();
        property.setPropertyName(propertyPojo.getPropertyName());
        property.setEmail(propertyPojo.getEmail());
        property.setMobileNo(propertyPojo.getMobileNo());

        property.setOwnerName(propertyPojo.getOwnerName());
        property.setAreaSq(propertyPojo.getAreaSq());
        property.setRoom(propertyPojo.getRoom());
        property.setLocation(propertyPojo.getLocation());
        property.setPCity(propertyPojo.getPCity());
        property.setOwnerAddress(propertyPojo.getOwnerAddress());
        if(propertyPojo.getImage()!=null){
            StringBuilder fileNames = new StringBuilder();
            System.out.println(UPLOAD_DIRECTORY);
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, propertyPojo.getImage().getOriginalFilename());
            fileNames.append(propertyPojo.getImage().getOriginalFilename());
            Files.write(fileNameAndPath, propertyPojo.getImage().getBytes());
            property.setImage(propertyPojo.getImage().getOriginalFilename());
        }

        propertyRepo.save(property);
        return "created";
    }

    @Override
    public Property fetchById(Integer P_id) {
        return propertyRepo.findById(P_id).orElseThrow(()->new RuntimeException("Not Found"));

    }

    @Override
    public List<Property> fetchAll() {
        return propertyRepo.findAll();
    }
    @Override
    public void deleteById(Integer P_id) {
        propertyRepo.deleteById(P_id);
    }


}
