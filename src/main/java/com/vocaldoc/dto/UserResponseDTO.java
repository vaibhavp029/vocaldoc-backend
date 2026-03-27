package com.vocaldoc.dto;

public class UserResponseDTO {

    private Long id;
    private String email;
    private String message;

    public String getMessage(){
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public Long getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    public void setId(Long id){
        this.id=id;
    }

    public void setEmail(String email){
        this.email=email;
    }


}
