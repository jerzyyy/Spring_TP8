package com.training.springcore.bigcorp.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FIXED")
public class FixedCaptor extends Captor {

    private Integer defaultPowerInWatt ;

    @Deprecated
    public FixedCaptor() {
        super();
        // used only by serializer and deserializer
    }
    public FixedCaptor(String name, Site site) {
        super(name, site);
    }

    public FixedCaptor(String name, Site site, Integer defaultPowerInWatt) {
        super(name, site);
        this.defaultPowerInWatt = defaultPowerInWatt;
    }
}
