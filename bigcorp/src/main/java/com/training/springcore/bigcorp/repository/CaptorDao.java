package com.training.springcore.bigcorp.repository;

import com.training.springcore.bigcorp.model.Captor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CaptorDao extends CrudDao <Captor,String> {
    List<Captor> findBySiteId(String siteId);
}
