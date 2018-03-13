package com.fileuploadingservice.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "file")
public class FileMetaData {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fileId;

    private String fileName;

    private String filePath;

    private String fileType;

    private Date timeStamp;

    public FileMetaData() {
    }

    public FileMetaData(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getFileType() { return fileType; }

    public void setFileType(String fileType) { this.fileType = fileType; }

    public void setTimeStamp(Date timeStamp) { this.timeStamp = timeStamp; }

    public Date getTimeStap() { return timeStamp; }
}
