package dev.danvega.DTO;

public class ChangePasswordRequest {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    Long id;
    String newPassword;

    public ChangePasswordRequest(Long id, String newPassword) {
        this.id = id;
        this.newPassword = newPassword;
    }

    public ChangePasswordRequest(){

    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
