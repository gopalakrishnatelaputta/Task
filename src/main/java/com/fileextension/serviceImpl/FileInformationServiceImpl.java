package com.fileextension.serviceImpl;


import com.fileextension.helper.Constants;
import com.fileextension.repository.FileInformationRepo;
import com.fileextension.service.FIleInformationService;
import com.fileextension.entites.FileInformation;
import com.fileextension.exception.InvaildFileExtensionException;
import com.fileextension.exception.InvaildFileNameException;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FileInformationServiceImpl implements FIleInformationService {

    @Value("${files.storage}")
    private String folderLocation;

    @Value("${allowedFileExtension}")
    private String allowedExtensions;

    @Autowired
    private FileInformationRepo fileRepo;

    @Override
    public Map<String, Object> uploadFile(String correlationId,MultipartFile file) throws IOException {
        Map<String, Object> map = new HashMap<>();

        String fileName = file.getOriginalFilename();

        if (!isValidFileName(fileName)) {
            throw new InvaildFileNameException(Constants.INVALID_FILE_NAME_EXCEPTION,correlationId);
        }

        String fileExtension = getFileExtension(fileName);

        if (!isAllowedExtension(fileExtension)) {
            throw new InvaildFileExtensionException(Constants.INVALID_FILE_EXTENSION_EXCEPTION,correlationId);
        }

        Tika tika = new Tika();
        String contentType = tika.detect(file.getInputStream());

        if (!isValidContentType(contentType, fileExtension)) {
            throw new InvaildFileExtensionException(Constants.INVALID_FILE_EXTENSION_EXCEPTION,correlationId);
        }

        FileInformation fileInfo = new FileInformation();
        fileInfo.setFileExtension(fileExtension);
        fileInfo.setFileName(fileName);
        fileInfo.setFileLocation(folderLocation);
        Files.copy(file.getInputStream(), Paths.get(folderLocation).resolve(fileName),
                StandardCopyOption.REPLACE_EXISTING);
        fileRepo.save(fileInfo);

        map.put(Constants.MESSAGE, Constants.FILE_UPDATED_SUCCESSFULLY);
        map.put(Constants.CONTENT_TYPE, contentType);

        return map;
    }

    private boolean isValidFileName(String fileName) {
        return fileName != null && (fileName.contains("_") || fileName.contains("-") || fileName.contains(" "));
    }

    private String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
    }

    private boolean isAllowedExtension(String fileExtension) {
        List<String> allowedExtensionsList = Arrays.asList(allowedExtensions.split(","));
        return allowedExtensionsList.contains(fileExtension);
    }

    private boolean isValidContentType(String contentType, String fileExtension) {
        if (contentType.startsWith(Constants.IMAGE)) {
            return fileExtension.equalsIgnoreCase("png") || fileExtension.equalsIgnoreCase("jpg") || fileExtension.equalsIgnoreCase("jpeg");
        } else {
            return contentType.equalsIgnoreCase(Constants.APPLICATION + fileExtension);
        }
    }
}
