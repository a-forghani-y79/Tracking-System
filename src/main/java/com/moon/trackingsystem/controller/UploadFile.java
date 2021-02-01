package com.moon.trackingsystem.controller;

import com.moon.trackingsystem.models.attachment.Attachment;
import com.moon.trackingsystem.models.attachment.AttachmentRepository;
import com.moon.trackingsystem.models.card.Card;
import com.moon.trackingsystem.models.card.CardRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@RestController
public class UploadFile {

    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/uploads";
    @Autowired
    private AttachmentRepository attachmentRepository;
    @Autowired
    private CardRepository cardRepository;

    @PostMapping(value = "/upload", produces = "application/json")
    public File upload(@RequestBody MultipartFile files, int cardId) {
        if (files == null)
            return new File();

        StringBuilder fileNames = new StringBuilder();


        Path fileNameAndPath = Paths.get(uploadDirectory, files.getOriginalFilename());

        fileNames.append(files.getOriginalFilename());
        try {
            Files.write(fileNameAndPath, files.getBytes());
            File file = new File();
            file.setFilePath("/uploads/" + files.getOriginalFilename());
            Attachment attachment = new Attachment().builder().name(files.getOriginalFilename()).url(file.getFilePath()).build();
            attachmentRepository.save(attachment);
            Card card = cardRepository.findById(cardId).get();
            card.getAttachments().add(attachment);
            cardRepository.save(card);
            return file;
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

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return this.filePath;
    }
}


