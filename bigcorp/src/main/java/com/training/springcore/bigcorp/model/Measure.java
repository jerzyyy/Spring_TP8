package com.training.springcore.bigcorp.model;

import javax.persistence.*;
import java.time.Instant;
@Entity
public class Measure {
    @Column(nullable = false)
    private Instant instant;

    @Column(nullable = false)
    private Integer valueInWatt;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional=false)
    public Captor captor;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Measure(){

    }

    public Measure(Instant instant, Integer valueInWatt, Captor captor){
        this.setInstant(instant);
        this.setValueInWatt(valueInWatt);
        this.captor=captor;
    }


    public Integer getValueInWatt() {
        return valueInWatt;
    }

    public void setValueInWatt(Integer valueInWatt) {
        this.valueInWatt = valueInWatt;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public Captor getCaptor() {
        return captor;
    }
}
