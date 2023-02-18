package com.system.afnai_managment.service;
import com.system.afnai_managment.entity.Order;
import com.system.afnai_managment.pojo.OrderPojo;
import com.system.afnai_managment.pojo.UserPojo;

import java.util.List;

public interface OrderService {

    String saveOrder(OrderPojo orderPojo);

    Order fetchById(Integer orderid);

    List<Order> fetchAll();

    void deleteById(Integer orderid);


    OrderPojo findByOrderid(String orderid);
}
