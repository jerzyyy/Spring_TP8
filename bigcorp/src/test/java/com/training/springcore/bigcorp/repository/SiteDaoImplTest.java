package com.training.springcore.bigcorp.repository;
import com.training.springcore.bigcorp.model.Site;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@JdbcTest
@ComponentScan
public class SiteDaoImplTest {

    @Autowired
    private SiteDao siteDao;


    
    @Before
    public void init(){
        Site site = new Site("name");
        site.setId("site1");
    }
    @Test
    public void findById() {
        Site site = siteDao.findById("site1");
        Assertions.assertThat(site.getName()).isEqualTo("Bigcorp Lyon");
    }
    @Test
    public void findByIdShouldReturnNullWhenIdUnknown() {
        Site site = siteDao.findById("unknown");
        Assertions.assertThat(site).isNull();
    }
    @Test
    public void findAll() {
        List<Site> sites = siteDao.findAll();
        Assertions.assertThat(sites)
                .hasSize(1)
                .extracting("id", "name")
                .contains(Tuple.tuple("site1", "Bigcorp Lyon"));
    }
    @Test
    public void create() {
        Assertions.assertThat(siteDao.findAll()).hasSize(1);
        siteDao.create(new Site("New site"));
        Assertions.assertThat(siteDao.findAll())
                .hasSize(2)
                .extracting(Site::getName)
                .contains("Bigcorp Lyon", "New site");
    }
    @Test
    public void update() {
        Site site = siteDao.findById("site1");
        Assertions.assertThat(site.getName()).isEqualTo("Bigcorp Lyon");
        site.setName("Site updated");
        siteDao.update(site);
        site = siteDao.findById("site1");
        Assertions.assertThat(site.getName()).isEqualTo("Site updated");
    }
    @Test
    public void deleteById() {
        Site newsite = new Site("New site");
        siteDao.create(newsite);
        Assertions.assertThat(siteDao.findById(newsite.getId())).isNotNull();
        siteDao.deleteById(newsite.getId());
        Assertions.assertThat(siteDao.findById(newsite.getId())).isNull();
    }
    @Test
    public void deleteByIdShouldThrowExceptionWhenIdIsUsedAsForeignKey() {
        Assertions.assertThatThrownBy(() -> siteDao.deleteById("site1"))
                .isExactlyInstanceOf(DataIntegrityViolationException.class);
    }
}
