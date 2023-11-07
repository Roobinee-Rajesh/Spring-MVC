package com.spring_mvc.model;

import javax.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String name;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email address")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).*$",
            message = "Password must contain at least one lowercase letter, one uppercase letter, one digit, and one special character")
    private String password;
    private String cPassword;
    @NotNull(message = "Please select a gender")
    private String gender;
    @NotNull(message = "Please select a language")
    private String[] language;
    @NotNull(message = "Please select a state")
    private String state;
    @NotNull(message = "Please select a qualification")
    private List<String> qualification;

    public User(){
        qualification = new ArrayList<>();

        qualification.add("Post Graduate");
        qualification.add("Under Graduate");
        qualification.add("HSLC");
        qualification.add("SSLC");
    }

    public List<String> getQualification() {
        return qualification;
    }

    public void setQualification(List<String> qualification) {
        this.qualification = qualification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getLanguage() {
        return language;
    }

    public void setLanguage(String[] language) {
        this.language = language;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
