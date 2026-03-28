package com.vocaldoc.model;

import jakarta.persistence.*;

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Long userId;
    private String fileName;
    private String filePath;

    public Document(){}

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public Long getUserId(){
        return userId;
    }

    public void setUserId(Long userId){
        this.userId=userId;
    }

    public String getFileName(){
        return fileName;
    }

    public void setFileName(String fileName){
        this.fileName=fileName;
    }

    public String getFilePath(){
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
