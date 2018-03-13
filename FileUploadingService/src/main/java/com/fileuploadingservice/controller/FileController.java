package com.fileuploadingservice.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fileuploadingservice.model.FileMetaData;
import com.fileuploadingservice.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/files")
public class FileController {

    private final FileService fileService;


    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/singleFileupload")
    public ResponseEntity<Object> handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        FileMetaData metaData = new FileMetaData(file.getOriginalFilename());
        String targetFilePath = fileService.storeFile(file, metaData);
        metaData.setFilePath(targetFilePath);
        String[] array = file.getOriginalFilename().split("\\.");
        //    System.out.println(array.length);
        //    System.out.println(array[array.length - 1]);
        metaData.setFileType(array[array.length - 1]);
        metaData.setTimeStamp(new java.util.Date());
        fileService.saveMetaData(metaData);
        return new ResponseEntity<>("File upload successfully", HttpStatus.CREATED);
    }

    @PostMapping("/multipleFileUpload")
    public ResponseEntity<Object> multipleFileUpload(@RequestParam("file") MultipartFile[] files) throws IOException {

        // Save file on system
        for (MultipartFile file : files) {
            FileMetaData metaData = new FileMetaData(file.getOriginalFilename());
            String targetFilePath = fileService.storeFile(file, metaData);
            metaData.setFilePath(targetFilePath);
            String[] array = file.getOriginalFilename().split("\\.");
        //    System.out.println(array.length);
        //    System.out.println(array[array.length - 1]);
            metaData.setFileType(array[array.length - 1]);
            metaData.setTimeStamp(new java.util.Date());
            fileService.saveMetaData(metaData);
        }
        return new ResponseEntity<>("Files upload successfully", HttpStatus.CREATED);
    }

    @GetMapping(path = "{fileId}/metadata")
    public ResponseEntity<FileMetaData> getFileMetaData(@PathVariable Long fileId) throws Exception {
        FileMetaData fileMetaData = fileService.getMetaData(fileId);
        if(null == fileMetaData) {
            throw new FileNotFoundException("File doesn't exist");
        }else {
            return new ResponseEntity<>(fileMetaData, HttpStatus.OK);
        }
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<FileMetaData>> getAllFiles() throws Exception {
        List<FileMetaData> list = fileService.getAllFiles();
        if(list == null) {
            throw new FileNotFoundException("File doesn't exist");
        }else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @GetMapping(path = "/search/{type}")
    public ResponseEntity<List<FileMetaData>> searchByType(@PathVariable String type) throws Exception {
        List<FileMetaData> list = fileService.searchByType(type);
        if(list == null || list.size() == 0) {
            throw new FileNotFoundException("File doesn't exist");
        }else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }
}
