package com.training.springcore.service;

import com.training.springcore.model.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteServiceImpl implements SiteService {

    public SiteServiceImpl(){

    }

    private CaptorService captorService;
    @Autowired
    public SiteServiceImpl(CaptorService captorService) {
        System.out.println("Init SiteServiceImpl :" + this);
        this.captorService = captorService;
    }

    void readFile(String path) {

    }

    @Override
    public Site findById(String siteId) {
        System.out.println("Appel de findById :" + this);
        if (siteId == null) {
            return null;
        }

        Site site = new Site("Florange");
        site.setId(siteId);
        site.setCaptors(captorService.findBySite(siteId));
        return site;
    }
}
