package dev.danvega.Services;

import dev.danvega.Model.Pacijent;

public class ChangeInformation {
    Pacijent p = new Pacijent("Uros","Stojanovic", "uros.stojanovic99@gmail.com", "ustojanovic", "12345", "njegoseva 14", "12864918246");
    public void changeInfo(String newName, String newLastName, String newUsername, String newAddress, String newPhoneNumber) {
        p.setName(newName);
        p.setLastName(newLastName);
        p.setUsername(newUsername);
        p.setAddress(newAddress);
        p.setPhoneNumber(newPhoneNumber);
    }
}
