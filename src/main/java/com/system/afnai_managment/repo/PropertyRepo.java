package com.system.afnai_managment.repo;


import com.system.afnai_managment.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PropertyRepo extends JpaRepository<Property, Integer> {


    Optional<Property> findByEmail(String s);
}
