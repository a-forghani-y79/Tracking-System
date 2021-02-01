package com.moon.trackingsystem.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@RestController
public class UploadFile {

    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/uploads";

    @PostMapping(value = "/upload", produces = "application/json")
    public File upload(MultipartFile files) {
        if (files == null)
            return new File();
        StringBuilder fileNames = new StringBuilder();
//        System.out.println(files.getSize() + "1111");


        Path fileNameAndPath = Paths.get(uploadDirectory, files.getOriginalFilename());

        fileNames.append(files.getOriginalFilename());
        try {
            Files.write(fileNameAndPath, files.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File();
        file.setFilePath("/uploads/" + files.getOriginalFilename());
        System.out.println(file.getFilePath());
        return file;
    }
}

@Data
class File {
    private String filePath;
}


