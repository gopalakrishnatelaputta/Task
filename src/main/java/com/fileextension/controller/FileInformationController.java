package com.fileextension.controller;

import com.fileextension.service.FIleInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/file")
public class FileInformationController {
    @Autowired
    private FIleInformationService service;


    @PostMapping("/upload")
    public ResponseEntity<Map<String,Object>> uploadFile(@RequestParam String correlationId, @RequestParam MultipartFile file) throws IOException {
       Map<String,Object> map=this.service.uploadFile(correlationId,file);
       return ResponseEntity.ok().body(map);
    }


}
