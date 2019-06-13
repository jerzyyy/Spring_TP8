package com.training.springcore.bigcorp.repository;

import com.training.springcore.bigcorp.model.Site;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SiteDaoImpl implements SiteDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void persist(Site site) {
        em.persist(site);
    }

    @Override
    public Site findById(String id) {
        return em.find(Site.class, id);
    }

    @Override
    public List<Site> findAll() {
        return em.createQuery("Select s from Site s",
                Site.class)
                .getResultList();
    }

    @Override
    public void delete(Site id) {
        em.remove(id);
    }

}
