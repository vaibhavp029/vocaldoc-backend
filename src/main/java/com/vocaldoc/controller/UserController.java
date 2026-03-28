package com.vocaldoc.controller;

import com.vocaldoc.dto.LoginRequestDTO;
import com.vocaldoc.dto.UserRequestDTO;
import com.vocaldoc.dto.UserResponseDTO;
import com.vocaldoc.model.Document;
import com.vocaldoc.repository.DocumentRepository;
import com.vocaldoc.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.vocaldoc.model.User;
import com.vocaldoc.service.UserService;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    DocumentService documentService;

    @PostMapping("/adduser")
    public UserResponseDTO addUser(@RequestBody UserRequestDTO dto){

        return userService.addUser(dto);

    }

    @GetMapping("/users")
    public List<UserResponseDTO> getUsers(){

        return userService.getUsers();

    }

    @PostMapping("/login")

    public UserResponseDTO login(@RequestBody LoginRequestDTO request){

        return userService.login(
        request.getEmail(),
        request.getPassword());
    }

    @PostMapping("/upload")

    public String upload(
            @RequestParam MultipartFile file,
            @RequestParam Long userId
            )

    throws Exception{

        String uploadDir =System.getProperty("user.dir") +"/uploads/";
        System.out.println("Saving to: " + uploadDir);
        File directory = new File(uploadDir);
        if(!directory.exists()){
            directory.mkdirs();
        }
        String fileName = file.getOriginalFilename();

        String lowerName = fileName.toLowerCase();

        if(!(lowerName.endsWith(".txt") ||
                lowerName.endsWith(".pdf") ||
                lowerName.endsWith(".docx"))){

            return "Only TXT, PDF, DOCX allowed";

        }
        String filePath = uploadDir + System.currentTimeMillis() + "_" + file.getOriginalFilename();

        File dest =new File(filePath);
        file.transferTo(dest);

        Document doc = new Document();
        doc.setUserId(userId);
        doc.setFileName(file.getOriginalFilename());
        doc.setFilePath(filePath);
        documentService.save(doc);

        String text = documentService.extractText(filePath);
        System.out.println("Extracted text:\n\n");
        System.out.println(text + "\n");

        return "File uploaded Successfully";

    }
}