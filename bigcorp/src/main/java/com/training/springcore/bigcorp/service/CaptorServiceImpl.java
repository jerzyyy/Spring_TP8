package com.training.springcore.bigcorp.service;

import com.training.springcore.bigcorp.model.Captor;
import com.training.springcore.bigcorp.repository.CaptorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CaptorServiceImpl implements CaptorService {
    @Value("${bigcorp.measure.default-simulated}")
    private Integer defaultValue;


    @Autowired
    private CaptorDao captorDao;

    @Override
    @Monitored
    public Set<Captor> findBySite(String siteId) {
        List<Captor> captors = captorDao.findBySiteId(siteId) ;
        return captors.stream().collect(Collectors.toSet());
    }
}
