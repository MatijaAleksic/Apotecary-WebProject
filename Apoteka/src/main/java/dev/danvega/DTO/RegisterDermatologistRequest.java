package dev.danvega.DTO;

public class RegisterDermatologistRequest {
    String name;
    String lastName;
    String username;
    String password;

    public RegisterDermatologistRequest(String name, String lastName, String username, String password) {
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
}
