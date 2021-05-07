package dev.danvega.DTO;

public class PhrmacistChangeInfo {
    String name;
    String lastName;
    String address;
    String city;
    String country;
    String phone;

    public PhrmacistChangeInfo() {
    }

    public PhrmacistChangeInfo(String name, String lastName, String address, String city, String country, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phone = phone;
    }

    public PhrmacistChangeInfo(String firstname, String lastname, String username, String password, String email, String adress, String city, String country, String phone) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
