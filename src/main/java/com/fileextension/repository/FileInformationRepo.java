package com.fileextension.repository;

import com.fileextension.entites.FileInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileInformationRepo extends JpaRepository<FileInformation,Long> {
}
