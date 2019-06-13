package com.training.springcore.bigcorp.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Captor<integer> {
    /**
     * Captor id
     */
    @Id
    private String id = UUID.randomUUID().toString();

    /**
     * Captor name
     */
    @Column(nullable = false)
    private String name;

    @ManyToOne(optional = false)
    private Site site;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private PowerSource powerSource;



    private Integer defaultPowerInWatt;

    public Captor(){

    }
    public Captor(String name, Site site) {
        this.name = name;
        this.site= site;
    }
    @Deprecated
    public Captor(String name) {
        // Use for serializer or deserializer
    }

    public PowerSource getPowerSource() {
        return powerSource;
    }

    public void setPowerSource(PowerSource powerSource) {
        this.powerSource = powerSource;
    }



    public Integer getDefaultPowerInWatt() {
        return defaultPowerInWatt;
    }

    public void setDefaultPowerInWatt(Integer defaultPowerInWatt) {
        this.defaultPowerInWatt = defaultPowerInWatt;
    }



    /**
     * Constructor to use with required property
     * @param name
     */


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Captor site = (Captor) o;
        return Objects.equals(name, site.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Captor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


    public Site getSite() {
        return site;

    }
}
