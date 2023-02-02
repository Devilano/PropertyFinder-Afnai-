package com.system.afnai_managment.service;
import com.system.afnai_managment.entity.Property;
import com.system.afnai_managment.pojo.PropertyPojo;

import java.util.List;

public interface PropertyService {
    Property fetchById(Integer id) ;

    String saveProperty(PropertyPojo propertyPojo);
    List<Property> fetchAll();

    void deleteById(Integer id);

}
