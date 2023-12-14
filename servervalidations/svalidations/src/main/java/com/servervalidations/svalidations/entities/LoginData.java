package com.servervalidations.svalidations.entities;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginData {
    
    @NotBlank(message = "User name cant't be empty")
    @Size(min = 3,max =12, message = "length should be 3-12" )
    private String userName;
    @Override
    public String toString() {
        return "LoginData [userName=" + userName + ", email=" + email + ", agreed=" + agreed + "]";
    }
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
    private String email;
    @AssertTrue(message = "Tick pls")
    private boolean agreed;
    public LoginData() {
    }
    public LoginData(
            @NotBlank(message = "User name cant't be empty") @Size(min = 3, max = 12, message = "length should be 3-12") String userName,
            @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$") String email,
            @AssertTrue(message = "Tick pls") boolean agreed) {
        this.userName = userName;
        this.email = email;
        this.agreed = agreed;
    }
    public boolean isAgreed() {
        return agreed;
    }
    public void setAgreed(boolean agreed) {
        this.agreed = agreed;
    }
    public String getUserName() {
        return userName;
    }
    public String getEmail() {
        return email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setEmail(String email) {
        this.email = email;
    }


}
