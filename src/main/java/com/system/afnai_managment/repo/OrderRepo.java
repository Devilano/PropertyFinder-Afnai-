package com.system.afnai_managment.repo;


import com.system.afnai_managment.entity.Order;

import com.system.afnai_managment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
    @Query(value = "select * from ORDERS where orderid=?1", nativeQuery = true)
    Optional<Order> findByOrderid(String orderid);

}
