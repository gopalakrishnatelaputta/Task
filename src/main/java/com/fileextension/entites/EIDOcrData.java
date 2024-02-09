package com.fileextension.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EIDOcrData {

    private LocalDateTime expiryDate;
    private String idNumber;
    private LocalDateTime IssuedDate;

}
