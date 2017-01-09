//
// WebConfiguration.java
// Aplikasi-Penjualan-Web 
//
// Created by Agung Pramono on 30/10/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//

package com.agung.penjualan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

/**
 *
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/index").setViewName("index");
    }
    
    @Bean
    public JasperReportsViewResolver jasperResolver(){
        JasperReportsViewResolver resolver = new JasperReportsViewResolver();
        
        resolver.setViewClass(JasperReportsMultiFormatView.class);
        resolver.setOrder(0); // cari template jasper dulu, kalau tidak ketemu, baru cari template thymeleaf
        resolver.setViewNames("report_*");
        resolver.setPrefix("classpath:/report/");
        resolver.setSuffix(".jrxml");
        resolver.setReportDataKey("dataDalamReport");
        
        return resolver;
    }
   
}
