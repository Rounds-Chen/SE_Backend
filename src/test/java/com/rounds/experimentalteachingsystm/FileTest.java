package com.rounds.experimentalteachingsystm;


import com.rounds.experimentalteachingsystm.service.FileStorageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.util.IOUtils;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootTest
@EnableAutoConfiguration
public class FileTest {
    @Resource
    FileStorageService fileStorageService;

//    String uploadPath="/files/";
//    public String upload(MultipartFile file) {
//        if (file.isEmpty()){
//            return null;
//        }
//
//        try{
//            File fileP=new File(uploadPath);
//            if(!fileP.isDirectory()){
//                System.out.println("创建文件夹");
//                fileP.mkdirs();
//            }
//
////            String fileName=getFileName(file.getOriginalFilename());
//            String filePath=uploadPath+"/"+file.getOriginalFilename();
//            File dest=new File(filePath);
//            file.transferTo(dest);
//
//            return filePath;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    //https://github.com/SteafanMrZhou/springBootPractice/tree/master/FileUploadDemo-master
    @Test
    public  void testFileUpload() throws IOException {
        File test=new File("C:\\Users\\round\\Desktop\\test.txt");
        FileInputStream inputStream=new FileInputStream(test);
        MultipartFile multipartFile=new MockMultipartFile("test.txt",test.getName(),"text/plain", inputStream);

        System.out.println("测试文件上传");
        String path=fileStorageService.upload(multipartFile);
        System.out.println("文件上传的位置为："+path);
    }
}
