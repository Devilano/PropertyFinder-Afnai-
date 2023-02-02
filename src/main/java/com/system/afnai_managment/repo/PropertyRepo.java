package com.system.afnai_managment.repo;


import com.system.afnai_managment.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PropertyRepo extends JpaRepository<Property, Integer> {

}
