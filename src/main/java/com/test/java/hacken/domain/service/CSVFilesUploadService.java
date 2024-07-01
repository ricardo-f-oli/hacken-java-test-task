package com.test.java.hacken.domain.service;

import com.opencsv.CSVReader;
import com.test.java.hacken.domain.entites.GenericCSVFileEntity;
import com.test.java.hacken.domain.repository.GenericCSVFileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class CSVFilesUploadService {
    @Autowired
    private GenericCSVFileRepository genericCSVFileRepository;

    public Long uploadCSVFiles(MultipartFile file)  throws IOException {
        String content = new String(file.getBytes());
        GenericCSVFileEntity csvFile = new GenericCSVFileEntity();
        csvFile.setName(file.getOriginalFilename());
        csvFile.setContent(content);
        genericCSVFileRepository.save(csvFile);
        return csvFile.getId();
    }
}
