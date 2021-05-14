package dev.danvega.DTO;

public class FirstLoginChangePasswordDTO {

    private Long userId;
    private String userType;
    private String newPassword;

    public FirstLoginChangePasswordDTO() {
    }

    public FirstLoginChangePasswordDTO(Long userId, String newPassword, String userType) {
        this.userId = userId;
        this.userType = userType;
        this.newPassword = newPassword;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
