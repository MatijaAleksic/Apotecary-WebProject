package dev.danvega.DTO;

public class LoginResponseDTO {

    private Long userId;
    private String userType;
    private String firstTimeLogin;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(String userType, String firstTimeLogin, Long userId) {
        this.userId = userId;
        this.userType = userType;
        this.firstTimeLogin = firstTimeLogin;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFirstTimeLogin() {
        return firstTimeLogin;
    }

    public void setFirstTimeLogin(String firstTimeLogin) {
        this.firstTimeLogin = firstTimeLogin;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
