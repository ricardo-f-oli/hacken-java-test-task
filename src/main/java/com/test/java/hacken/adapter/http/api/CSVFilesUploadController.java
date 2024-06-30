package com.test.java.hacken.adapter.http.api;

import com.test.java.hacken.domain.service.CSVFilesUploadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1")
public class CSVFilesUploadController {
    private final CSVFilesUploadService csvFilesUploadService;
    public CSVFilesUploadController(CSVFilesUploadService csvFilesUploadService){
        this.csvFilesUploadService = csvFilesUploadService;
    }
    @PostMapping(value = "/csv", consumes = {"multipart/form-data"})
    public ResponseEntity<Integer> uploadCSVfiles(
            @RequestPart("file")MultipartFile file
            ){
        return ResponseEntity.ok(csvFilesUploadService.uploadCSVFiles(file));
    }

}
