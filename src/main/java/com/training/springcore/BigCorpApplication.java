package com.training.springcore;

import com.training.springcore.service.SiteService;
import com.training.springcore.service.SiteServiceImpl;

public class BigCorpApplication {

    public static void main (String[] args){
        BigCorpApplication application = new BigCorpApplication();
        application.run();
    }

    public void run(){
        ObjectFacory objFct = new ObjectFacory();
        System.out.println("Application startup");
        SiteService siteService = objFct.createSiteService();;
        System.out.println(siteService.findById("siteA"));
    }
}
