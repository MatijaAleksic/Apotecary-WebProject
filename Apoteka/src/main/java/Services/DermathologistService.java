package Services;

import Model.Dermatologist;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

public class DermathologistService {

    public static Dermatologist dermBaza = new Dermatologist("Pera", "Peric", "pera", "peric");
    public static ArrayList<Dermatologist> bazaDermatologa = new ArrayList<Dermatologist>();


    public boolean registerDermathologist(String firstName,String lastName, String username, String password)
    {
        bazaDermatologa.add(dermBaza);
        Dermatologist newDerm = new Dermatologist(firstName, lastName, username, password);

        bazaDermatologa.add(newDerm);

        for(Dermatologist d : bazaDermatologa)
        {
            System.out.println(d);
        }
        return true;
    }
}
