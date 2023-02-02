package com.system.afnai_managment.service.impl;
import com.system.afnai_managment.entity.Property;
import com.system.afnai_managment.pojo.PropertyPojo;
import com.system.afnai_managment.repo.PropertyRepo;
import com.system.afnai_managment.service.PropertyService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {
    public final PropertyRepo propertyRepo;


    public String saveProperty(PropertyPojo propertyPojo) {
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
        propertyRepo.save(property);
        return "created";
    }

    @Override
    public Property fetchById(Integer id) {
        return null;
    }

    @Override
    public List<Property> fetchAll() {
        return propertyRepo.findAll();
    }
    @Override
    public void deleteById(Integer id) {
        propertyRepo.deleteById(id);
    }


}
