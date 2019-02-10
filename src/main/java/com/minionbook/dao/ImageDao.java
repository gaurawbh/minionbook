/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minionbook.dao;

import java.io.IOException;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.multipart.MultipartFile;

public class ImageDao {

    private final JdbcTemplate jdbcTemplate;

    public ImageDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        //I am goimng to develop new UI
    }
    //imagedao for minionbook

    public int insertRecords(String name, MultipartFile photo) throws IOException {

        byte[] photoBytes = photo.getBytes();
        String sql = "INSERT INTO minionprofiles(NAME,PHOTO) VALUES(?,?)";
        return jdbcTemplate.update(sql, new Object[]{name, photoBytes});
    }
}
