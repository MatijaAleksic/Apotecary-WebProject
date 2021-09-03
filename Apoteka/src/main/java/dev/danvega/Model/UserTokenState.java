package dev.danvega.Model;

import dev.danvega.DTO.LoginResponseDTO;

// DTO koji enkapsulira generisani JWT i njegovo trajanje koji se vracaju klijentu
public class UserTokenState {
	
    private String accessToken;
    private Long expiresIn;

    private LoginResponseDTO user_info;

    public UserTokenState() {
        this.accessToken = null;
        this.expiresIn = null;
    }

    public UserTokenState(String accessToken, long expiresIn) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }

    public UserTokenState(String accessToken, long expiresIn, LoginResponseDTO user_info) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.user_info = user_info;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public LoginResponseDTO getUser_info() {
        return user_info;
    }

    public void setUser_info(LoginResponseDTO user_info) {
        this.user_info = user_info;
    }
}