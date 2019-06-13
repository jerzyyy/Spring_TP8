package com.training.springcore.bigcorp.repository;

import com.training.springcore.bigcorp.model.Measure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasureDao extends JpaRepository<Measure,Long> {
}
