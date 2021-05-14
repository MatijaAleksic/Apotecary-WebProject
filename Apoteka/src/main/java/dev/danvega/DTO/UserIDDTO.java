package dev.danvega.DTO;

public class UserIDDTO {
    private Long id;

    public UserIDDTO(Long id) {
        this.id = id;
    }

    public UserIDDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
