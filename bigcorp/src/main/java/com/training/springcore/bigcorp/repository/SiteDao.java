package com.training.springcore.bigcorp.repository;

import com.training.springcore.bigcorp.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteDao extends JpaRepository<Site,String> {
}
