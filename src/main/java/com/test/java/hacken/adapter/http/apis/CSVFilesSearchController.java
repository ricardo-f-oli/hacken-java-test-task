package com.test.java.hacken.adapter.http.apis;

import com.test.java.hacken.domain.service.CSVFilesSearchService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class CSVFilesSearchController {
    private final CSVFilesSearchService csvFilesSearchService;

    public CSVFilesSearchController(CSVFilesSearchService csvFilesSearchService){
        this.csvFilesSearchService = csvFilesSearchService;
    }

}
