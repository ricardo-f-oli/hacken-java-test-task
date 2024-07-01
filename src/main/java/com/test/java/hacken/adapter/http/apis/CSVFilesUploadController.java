package com.test.java.hacken.adapter.http.apis;

import com.test.java.hacken.domain.service.CSVFilesUploadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/v1")
public class CSVFilesUploadController {
    private final CSVFilesUploadService csvFilesUploadService;
    public CSVFilesUploadController(CSVFilesUploadService csvFilesUploadService){
        this.csvFilesUploadService = csvFilesUploadService;
    }
    @PostMapping(value = "/csv", consumes = {"multipart/form-data"})
    public ResponseEntity<Long> uploadCSVfiles(
            @RequestPart("file")MultipartFile file
            ){
        try {
            return ResponseEntity.ok(csvFilesUploadService.uploadCSVFiles(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
