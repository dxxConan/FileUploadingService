package com.fileuploadingservice;

import com.fileuploadingservice.ExceptionHandler.FileExceptionHandler;
import com.fileuploadingservice.model.FileMetaData;
import com.fileuploadingservice.repository.FileMetaDataRepository;
import com.fileuploadingservice.service.FileServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileuploadingserviceApplicationTests {

	@Before
	public void setUpMock() {
        MockitoAnnotations.initMocks(this);
	}

	@Test
    public void testMockGetAllFiles() {
        FileMetaDataRepository mockRepository = mock(FileMetaDataRepository.class);
        List<FileMetaData> list = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            list.add(new FileMetaData());
        }

        when(mockRepository.findAll()).thenReturn(list);
        int size = mockRepository.findAll().size();
        assertEquals(3, size);
    }

    @Test
    public void testMockGetFileById() {
        FileMetaDataRepository mockRepository = mock(FileMetaDataRepository.class);
        FileMetaData fileMetaData = new FileMetaData("test");
        when(mockRepository.findByFileId(1L)).thenReturn(fileMetaData);

        FileServiceImpl service = new FileServiceImpl(mockRepository);
        assertEquals("test",service.getMetaData(1l).getFileName());
    }

}
