package dev.danvega.Services;

import dev.danvega.Model.Patient;

public class ChangeInformation {
    Patient p = new Patient(1L, "Uros","Stojanovic","ustojanovic", "12345", "uros.stojanovic99@gmail.com", "njegoseva 14","Novi Sad", "Srbija", "12864918246");
    public void changeInfo(String newName, String newLastName, String newUsername, String newAddress, String newPhoneNumber) {
        p.setFirstname(newName);
        p.setLastname(newLastName);
        p.setUsername(newUsername);
        p.setAdress(newAddress);
        p.setPhone(newPhoneNumber);
    }
}
