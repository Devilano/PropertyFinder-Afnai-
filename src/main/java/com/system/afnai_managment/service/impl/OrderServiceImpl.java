package com.system.afnai_managment.service.impl;
import com.system.afnai_managment.entity.Order;
import com.system.afnai_managment.entity.User;
import com.system.afnai_managment.exception.AppException;
import com.system.afnai_managment.pojo.OrderPojo;
import com.system.afnai_managment.pojo.UserPojo;
import com.system.afnai_managment.repo.OrderRepo;
import com.system.afnai_managment.repo.PropertyRepo;
import com.system.afnai_managment.repo.UserRepo;
import com.system.afnai_managment.service.OrderService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    public final OrderRepo orderRepo;
    public final UserRepo userRepo;
    public final PropertyRepo propertyRepo;
    public String saveOrder(OrderPojo orderPojo) {
        Order order = new Order();
        order.setProperty(propertyRepo.findById(orderPojo.getP_id()).orElseThrow());
        order.setUser(userRepo.findById(orderPojo.getU_id()).orElseThrow());
        order.setOrderid(orderPojo.getOrderid());
        orderRepo.save(order);
        return "created";
    }

    @Override
    public Order fetchById(Integer orderid) {
        return null;
    }

    @Override
    public List<Order> fetchAll() {
        return orderRepo.findAll();
    }
    @Override
    public void deleteById(Integer orderid) {
        orderRepo.deleteById(orderid);
    }
    @Override
    public OrderPojo findByOrderid(String orderid) {
        Order order = orderRepo.findByOrderid(orderid)
                .orElseThrow(() -> new AppException("Invalid User email", HttpStatus.BAD_REQUEST));
        return new OrderPojo(order);

    }


}
