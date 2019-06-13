package com.training.springcore.bigcorp.repository;
import com.training.springcore.bigcorp.model.Captor;
import com.training.springcore.bigcorp.model.Measure;
import com.training.springcore.bigcorp.model.Site;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan
public class MeasureDaoImplTest {
    @Autowired
    private MeasureDao measureDao;


    @Test
    public void findById() {
        Optional<Measure> measure = measureDao.findById(-1L);
        Assertions.assertThat(measure).isPresent();
        measure.ifPresent(m ->{
            Assertions.assertThat(m.getId()).isEqualTo(-1L);
            Assertions.assertThat(m.getInstant()).isEqualTo(Instant.parse("2018-08-09T11:00:00.000Z"));
            Assertions.assertThat(m.getValueInWatt()).isEqualTo(1_000_000);
            Assertions.assertThat(m.getCaptor().getName()).isEqualTo("Eolienne");
            Assertions.assertThat(m.getCaptor().getSite().getName()).isEqualTo("Bigcorp Lyon");
        });

    }
    @Test
    public void findByIdShouldReturnNullWhenIdUnknown() {
        Measure measure = measureDao.getOne(-10L);
        Assertions.assertThat(measure).isNotNull();
    }
    @Test
    public void findAll() {
        List<Measure> measures = measureDao.findAll();
        Assertions.assertThat(measures).hasSize(10);
    }
    @Test
    public void create() {
        Captor captor = new Captor("Eolienne", new Site("site"));
        captor.setId("c1");
        Assertions.assertThat(measureDao.findAll()).hasSize(10);
        measureDao.save(new Measure(Instant.now(), 2_333_666, captor));
        Assertions.assertThat(measureDao.findAll()).hasSize(11);
    }
    @Test
    public void update() {
        Measure measure = measureDao.getOne(-1L);
        Assertions.assertThat(measure.getValueInWatt()).isEqualTo(1_000_000);
        measure.setValueInWatt(2_333_666);
        measureDao.save(measure);
        measure = measureDao.getOne(-1L);
        Assertions.assertThat(measure.getValueInWatt()).isEqualTo(2_333_666);
    }
    @Test
    public void deleteById() {
        Assertions.assertThat(measureDao.findAll()).hasSize(10);
        measureDao.delete(measureDao.getOne(-1L));
        Assertions.assertThat(measureDao.findAll()).hasSize(9);
    }
}