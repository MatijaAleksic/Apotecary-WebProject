package Services;

import Model.Dermatologist;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

public class DermathologistService {

    public static Dermatologist dermBaza = new Dermatologist("Pera", "Peric", "pera", "peric");
    public static ArrayList<Dermatologist> bazaDermatologa = new ArrayList<Dermatologist>();

    public DermathologistService() {
        bazaDermatologa.add(dermBaza);
    }

    public boolean registerDermathologist(String firstName, String lastName, String username, String password)
    {
        Dermatologist newDerm = new Dermatologist(firstName, lastName, username, password);

        boolean flag = true;
        for(Dermatologist d : bazaDermatologa)
        {
            if (username.equalsIgnoreCase(d.getUserName())) {
                flag = false;
                break;
            }
        }

        if(flag)
        {
            bazaDermatologa.add(newDerm);
            return flag;
        }
        return flag;
    }
}
