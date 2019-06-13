package com.training.springcore.bigcorp.repository;

import com.training.springcore.bigcorp.model.Captor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CaptorDao extends JpaRepository<Captor,String> {
    List<Captor> findBySiteId(String siteId);
}
