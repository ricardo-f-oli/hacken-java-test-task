package com.test.java.hacken.adapter.http.apis;

import com.test.java.hacken.domain.entites.GenericCSVEntity;
import com.test.java.hacken.domain.entites.GenericCSVFileEntity;
import com.test.java.hacken.domain.service.CSVFilesSearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class CSVFilesSearchController {
    private final CSVFilesSearchService csvFilesSearchService;

    public CSVFilesSearchController(CSVFilesSearchService csvFilesSearchService){
        this.csvFilesSearchService = csvFilesSearchService;
    }

    @GetMapping("/records")
    public List<GenericCSVEntity> search(@RequestParam String query) {
        return csvFilesSearchService.search(query);
    }
}
