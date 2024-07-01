package com.test.java.hacken.domain.service;

import com.opencsv.CSVReader;
import com.test.java.hacken.domain.entites.GenericCSVEntity;
import com.test.java.hacken.domain.entites.GenericCSVFileEntity;
import com.test.java.hacken.domain.repository.GenericCSVFileRepository;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVFilesSearchService {

    private final GenericCSVFileRepository genericCSVFileRepository;
    private final Counter searchCounter;

    @Autowired
    public CSVFilesSearchService(GenericCSVFileRepository genericCSVFileRepository, MeterRegistry meterRegistry) {
        this.genericCSVFileRepository = genericCSVFileRepository;
        this.searchCounter = meterRegistry.counter("csv.searches");
    }
    public List<GenericCSVEntity> search(String query) {
        searchCounter.increment();
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