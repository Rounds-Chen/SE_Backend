package com.rounds.experimentalteachingsystm.service.impl;

import com.rounds.experimentalteachingsystm.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.util.UUID;

@Service
public class FileStorageServiceImp implements FileStorageService {

    @Value("${file.server.path}")
    private  String uploadPath;


    /**
     * 获取随机文件名
     * @param fileOriginaName
     * @return 新的随机文件名
     */
    private static String getFileName(String fileOriginaName){
        String suffix=fileOriginaName.substring(fileOriginaName.lastIndexOf("."));
        return UUID.randomUUID()+suffix;
    }

    @Override
    public String upload(MultipartFile file) {
        if (file.isEmpty()){
            return null;
        }

        try{
            File fileP=new File(uploadPath);
            if(!fileP.isDirectory()){
                fileP.mkdirs();
            }

            String fileName=getFileName(file.getOriginalFilename());
            String filePath=uploadPath+"/"+fileName;
            File dest=new File(filePath);
            file.transferTo(dest);

            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public boolean delete(String fileLink) {

        File file=new File(fileLink);
        try{
            if(file.delete()){
                return true;
            }
            else
                return false;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


}
