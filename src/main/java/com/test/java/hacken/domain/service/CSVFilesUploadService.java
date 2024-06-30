package com.test.java.hacken.domain.service;

import com.opencsv.CSVReader;
import com.test.java.hacken.domain.entites.GenericCSVFileEntity;
import com.test.java.hacken.domain.repository.GenericCSVFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    public Integer uploadCSVFiles(MultipartFile csvFile) {
        List<GenericCSVFileEntity> records;
        try (CSVReader reader = new CSVReader(new InputStreamReader(csvFile.getInputStream(), StandardCharsets.UTF_8))) {
            String[] headers = reader.readNext();
            records = new ArrayList<>();
            String[] values;
            while ((values = reader.readNext()) != null) {
                Map<String, String> fields = new HashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    fields.put(headers[i], values[i]);
                }
                GenericCSVFileEntity record = new GenericCSVFileEntity();
                record.setFields(fields);
                records.add(record);
            }
            genericCSVFileRepository.saveAll(records);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao processar o arquivo CSV");
        }
        return records.size();
    }

}
