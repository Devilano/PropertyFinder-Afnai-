package com.system.afnai_managment.repo;


import com.system.afnai_managment.entity.Feed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FeedRepo extends JpaRepository<Feed, Integer> {

}
