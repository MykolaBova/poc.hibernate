package com.mkyong;

/**
 * Created by m.bova on 7/8/2014.
 */
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.cfg.Configuration;
public class Create {

    public static void main(String args[]){
        Configuration cfg=new AnnotationConfiguration();
        cfg.configure("hibernate.cfg.xml");

        SchemaExport se=new SchemaExport(cfg);

        se.create(true, true);


    }
}