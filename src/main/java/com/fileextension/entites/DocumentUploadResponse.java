package com.fileextension.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentUploadResponse<T> {
    private String id;
    private String fileName;
    private String fileSize;
    private String fileExtension;
    private String documentType;
    private LocalDateTime uploadDate;
    private T OcrData;


}