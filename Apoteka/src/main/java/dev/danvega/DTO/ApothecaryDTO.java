package dev.danvega.DTO;

public class ApothecaryDTO {
    String name;
    String address;

    public ApothecaryDTO() {

    }

    public ApothecaryDTO(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
