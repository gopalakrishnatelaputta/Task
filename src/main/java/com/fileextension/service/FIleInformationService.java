package com.fileextension.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface FIleInformationService {
    Map<String, Object> uploadFile(String correlationId,MultipartFile file) throws IOException;
}
