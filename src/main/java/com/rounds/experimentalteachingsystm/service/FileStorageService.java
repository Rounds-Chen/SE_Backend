package com.rounds.experimentalteachingsystm.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

public interface FileStorageService {

    public String upload(MultipartFile file);

    public boolean delete(String fileLink);
}
