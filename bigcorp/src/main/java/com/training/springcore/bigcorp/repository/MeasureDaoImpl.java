package com.training.springcore.bigcorp.repository;

import com.training.springcore.bigcorp.model.Measure;

import com.training.springcore.bigcorp.model.Captor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MeasureDaoImpl implements MeasureDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void persist(Measure element) {
        em.persist(element);

    }

    @Override
    public Measure findById(Long aLong) {
        return em.find(Measure.class, aLong);
    }

    @Override
    public List<Measure> findAll() {
        return em.createQuery("Select m from Measure m ",
                Measure.class)
                .getResultList();
    }


    @Override
    public void delete(Measure id) {
        em.remove(id);
    }
}