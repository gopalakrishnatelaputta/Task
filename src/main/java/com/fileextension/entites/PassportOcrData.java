package com.fileextension.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassportOcrData {
    private LocalDateTime dateOfBirth;
    private LocalDateTime DateOfExpiration;
    private LocalDateTime IssuedDate;
    private String FirstName;
    private String LastName;
    private String Nationality;
    private String documentNumber;
    private String placeOfIssue;
    private String sex;
    private String name;

}