package com.test.java.hacken.adapter.http.api;

import com.test.java.hacken.domain.entites.GenericCSVFileEntity;
import com.test.java.hacken.domain.service.CSVFilesSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class CSVFilesSearchController {

    @Autowired
    private CSVFilesSearchService searchService;

    @GetMapping("/search")
    public List<GenericCSVFileEntity> search(@RequestParam("keyword") String keyword) {
        List<GenericCSVFileEntity> files = new ArrayList<>();
        return files;
        //        return searchService.search(keyword);
    }
}
