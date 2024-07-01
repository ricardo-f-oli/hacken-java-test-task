package com.test.java.hacken.domain.service;

import com.opencsv.CSVReader;
import com.test.java.hacken.domain.entites.GenericCSVEntity;
import com.test.java.hacken.domain.entites.GenericCSVFileEntity;
import com.test.java.hacken.domain.repository.GenericCSVFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVFilesSearchService {
    @Autowired
    private GenericCSVFileRepository genericCSVFileRepository;

    public List<GenericCSVEntity> search(String query) {
        List<GenericCSVEntity> results = new ArrayList<>();
        List<GenericCSVFileEntity> csvFiles = genericCSVFileRepository.findAll();

        for (GenericCSVFileEntity csvFile : csvFiles) {
            try (CSVReader csvReader = new CSVReader(new StringReader(csvFile.getContent()))) {
                String[] nextLine;
                while ((nextLine = csvReader.readNext()) != null) {
                    for (String field : nextLine) {
                        if (field.toLowerCase().contains(query.toLowerCase())) {
                            results.add(new GenericCSVEntity(nextLine));
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}