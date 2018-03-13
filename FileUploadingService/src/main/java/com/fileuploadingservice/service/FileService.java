package com.fileuploadingservice.service;

import com.fileuploadingservice.model.FileMetaData;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {

    String storeFile(MultipartFile file, FileMetaData fileMetaData) throws IOException;

    void saveMetaData(FileMetaData metaData);

    FileMetaData getMetaData(Long fileId);
    List<FileMetaData> getAllFiles();
    List<FileMetaData> searchByType(String type);
}
