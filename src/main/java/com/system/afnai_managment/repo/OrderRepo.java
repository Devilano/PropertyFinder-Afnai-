package com.system.afnai_managment.repo;


import com.system.afnai_managment.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

}
