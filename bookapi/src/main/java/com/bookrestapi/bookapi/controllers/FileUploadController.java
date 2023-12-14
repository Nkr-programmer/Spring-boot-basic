package com.bookrestapi.bookapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bookrestapi.bookapi.helper.FileUploadHelper;


@RestController
public class FileUploadController {
    
    @Autowired
    private FileUploadHelper fileUploadHelper;
    @PostMapping("/upload-file")
    public ResponseEntity<String>  uploadImage(@RequestParam("file") MultipartFile file)
    {
        System.out.println(file.getOriginalFilename()+"\n"+file.getSize()+"\n"+file.getContentType()+"\n"+file.getName());
         try{
        if(file.isEmpty()){return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("must have a  file");}
        if(!file.getContentType().equals("image/jpeg")){return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file type must be jpeg");}
        boolean f=fileUploadHelper.uploadFile(file);
        if(f){return ResponseEntity.ok("UPLOAD SUCCESSFULLY AND HERE IS LINK->"+
        ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString()//TO SHOW THE URL LINK===> JUST RUN THE APPLICATION YOU WILL COME TO KNOW
        );}
         }
         catch(Exception e)
        {   e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SOMETHING WRONG");
    }
    
}
