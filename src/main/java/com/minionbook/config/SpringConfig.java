/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minionbook.config;

import com.minionbook.dao.ImageDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.minionbook.controller","com.minionbook.ImageDao"})
public class SpringConfig {
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setPrefix("/");
        vr.setSuffix(".jsp");
        
        return vr;
    }
    @Bean
    public MultipartResolver multipartResolver(){
        return new CommonsMultipartResolver();
    }
    
    /**
     *      DriverManagerDataSource is not an actual connection pool.
     * it just serves as simple replacement for a full-blown connection pool, 
     * implementing the same standard interface, but creating new Connections on every call.
     * if you need a "real" connection pool outside of a J2EE container, consider 
     * Jakarta Commons DBCP or C3P0. Commons DBCP's BasicDataSource and 
     * C3P0 ComboPooledDataSource are full connection pool beans, supporting the same basic 
     * properties as this class plus specific settings (such as min/max pool size etc).
     * @return 
     */
    @Bean
    public DriverManagerDataSource getDataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/minionstest");
        ds.setUsername("root");
        ds.setPassword("root1234");
        
        return ds;
                
    }
    @Bean
    public ImageDao getConnectionObject(){
        return new ImageDao(getDataSource());
    }
}
