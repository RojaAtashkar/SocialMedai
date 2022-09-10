package client.model;

import java.time.LocalDateTime;

public class User {
    int id;
    String userId;
    String username;
    String password;
    LocalDateTime joinDate;
    String email;
    String imageAddress;
    String phoneNumber;
    String gender;
    String bio;

    public User(int id, String userId, String username,
                String password, String email, String imageAddress,
                String phoneNumber, String gender, String bio){
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.imageAddress = imageAddress;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.bio = bio;
    }
    public User (){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
