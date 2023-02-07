package com.system.afnai_managment.service;
import com.system.afnai_managment.entity.Property;
import com.system.afnai_managment.pojo.PropertyPojo;

import java.io.IOException;
import java.util.List;

public interface PropertyService {
    Property fetchById(Integer P_id) ;

    String saveProperty(PropertyPojo propertyPojo) throws IOException;
    List<Property> fetchAll();

    void deleteById(Integer P_id);

}
