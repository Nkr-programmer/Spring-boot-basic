package com.bookrestapi.bookapi.helper;

import java.io.File;
import java.io.IOException;
// import java.io.FileOutputStream;
// import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    

//    public final String UPLOAD_DIR="C:\\spring boot(vs code)\\bookapi\\src\\main\\resources\\static\\images";
      public final String UPLOAD_DIR=new ClassPathResource("static/images/").getFile().getAbsolutePath();// CONSTRUCTOR IS NEEDED TO HAVE THESE FUNCTIONS 
      public FileUploadHelper() throws IOException{}
    public boolean uploadFile(MultipartFile multipart){
      boolean f=true;
      try{
        // InputStream is=multipart.getInputStream();
        // byte data[]= new byte[is.available()];
        // is.read(data);

        // FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.separator+multipart.getOriginalFilename());
        // fos.write(data);
        // fos.close();// OTHER WAY TO PASS FILE TO RESOURCE
        Files.copy(multipart.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+multipart.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING );
     f=true;
    }
      catch(Exception e){e.printStackTrace();}
return f;
    }
}
