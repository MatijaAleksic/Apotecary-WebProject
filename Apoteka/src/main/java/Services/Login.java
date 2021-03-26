package Services;

import Model.Pacijent;

public class Login {
    Pacijent p = new Pacijent("Uros","Stojanovic", "uros.stojanovic99@gmail.com", "ustojanovic", "12345", "njegoseva 14", "12864918246");
    public String login(String username, String password){
        if(username.equalsIgnoreCase(p.getUsername()) && password.equalsIgnoreCase(p.getPassword())){
            return "Uspesno ulogovan " + username;
        }
        else{
            return "Username ili sifra se ne poklapaju.";

        }
    }
}
