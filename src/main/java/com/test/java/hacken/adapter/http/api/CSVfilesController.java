package com.test.java.hacken.adapter.http.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class CSVfilesController {
    public CSVfilesController(){}

    @PostMapping("/csv")
    public void uploadCSVfiles(){}

//    @GetMapping
//    public ResponseEntity<> searchCSVfile(){}

}
