package com.fileuploadingservice.repository;

import com.fileuploadingservice.model.FileMetaData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileMetaDataRepository extends JpaRepository<FileMetaData, Long> {

    FileMetaData findByFileId(Long fileId);

    //@Query(value = "select f.file_Id from File f", nativeQuery = true)
    List<FileMetaData> findByFileType(String fileType);
}

