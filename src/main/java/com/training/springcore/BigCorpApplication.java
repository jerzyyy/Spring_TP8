package com.training.springcore;

import com.training.springcore.model.ApplicationInfo;
import com.training.springcore.service.SiteService;
import com.training.springcore.service.SiteServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BigCorpApplication {

    public static void main (String[] args){
        BigCorpApplication application = new BigCorpApplication();
        application.run();
    }

    public void run(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(BigCorpApplicationConfig.class);
        ApplicationInfo applicationInfo = context.getBean(ApplicationInfo.class);
        System.out.println("==========================================================");
        System.out.println("Application [" + applicationInfo.getName() + "] - version : "
                + applicationInfo.getVersion());
        System.out.println("plus d'informations sur " + applicationInfo.getWebSiteUrl());
        System.out.println("==========================================================");
        SiteService service = context.getBean(SiteService.class);
        service.findById("ok");
    }
}
