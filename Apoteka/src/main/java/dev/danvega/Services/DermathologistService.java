package dev.danvega.Services;

import dev.danvega.Model.Dermatologist;
import dev.danvega.Repository.DermatologistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DermathologistService {

    public static Dermatologist dermBaza = new Dermatologist("Pera", "Peric", "pera", "peric", "");
    public static ArrayList<Dermatologist> bazaDermatologa = new ArrayList<Dermatologist>();

    @Autowired
    private DermatologistRepository dermatologistRepository;

    public DermathologistService() {
        bazaDermatologa.add(dermBaza);
    }

    public List<Dermatologist> searchDermatologist(String firstname, String lastname) {
        return dermatologistRepository.findByFirstnameAndLastname(firstname, lastname);
    }



    public boolean registerDermathologist(String firstName, String lastName, String username, String password)
    {
        Dermatologist newDerm = new Dermatologist(firstName, lastName, username, password, "");

        boolean flag = true;
        for(Dermatologist d : bazaDermatologa)
        {
            if (username.equalsIgnoreCase(d.getUsername())) {
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
