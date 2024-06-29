package com.test.java.hacken.adapter.http.api;

import com.test.java.hacken.domain.service.CSVFilesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1")
public class CSVfilesController {
    private final CSVFilesService csvFilesService;
    public CSVfilesController(CSVFilesService csvFilesService){
        this.csvFilesService = csvFilesService;
    }
    @PostMapping(value = "/csv", consumes = {"multipart/form-data"})
    public ResponseEntity<Integer> uploadCSVfiles(
            @RequestPart("file")MultipartFile file
            ){
        return ResponseEntity.ok(csvFilesService.uploadCSVFiles(file));
    }

//    @GetMapping
//    public ResponseEntity<> searchCSVfile(){}

}
