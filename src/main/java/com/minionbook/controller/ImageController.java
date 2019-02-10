/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minionbook.controller;

import com.minionbook.dao.ImageDao;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ImageController {
    
    @Autowired 
    ImageDao imageDao;
    
    @RequestMapping(value = "/InsertImage", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam("name") String name,@RequestParam("photo") MultipartFile photo ) throws IOException{
        try{
            imageDao.insertRecords(name,photo);
            
            return new ModelAndView("index","msg","Records successfully inserted");
            
        }
        catch (Exception e){
            return new ModelAndView("index","msg","Error: "+e.getMessage());
        }
    }
}
