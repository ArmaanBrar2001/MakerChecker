package com.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


@Data
@Component
public class FileUploadDto {
    private CommonsMultipartFile myFile;
    private String fileName;
}
