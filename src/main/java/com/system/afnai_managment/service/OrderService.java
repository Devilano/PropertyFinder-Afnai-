package com.system.afnai_managment.service;
import com.system.afnai_managment.entity.Property;
import com.system.afnai_managment.pojo.OrderPojo;
import com.system.afnai_managment.pojo.PropertyPojo;
import jakarta.persistence.criteria.Order;

import java.util.List;

public interface OrderService {
//    Property fetchById(Integer O_id) ;

    String saveOrder(OrderPojo orderPojo);

//    List<Order> fetchAll();

//    void deleteById(Integer O_id);

}
