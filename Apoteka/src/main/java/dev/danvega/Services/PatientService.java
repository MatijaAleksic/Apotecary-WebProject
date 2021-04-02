package dev.danvega.Services;

import dev.danvega.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public PatientService() {}

    //trebalo bi da se ispravi tako da proverava i ID pacijenta
    public boolean exists(String username, String password){
        if(!username.isEmpty()) {
            if (!password.isEmpty()) {
                return patientRepository.findByUsernameAndPassword(username, password);
            } else {
                return false;
            }
        }
        else{
            return false;
        }
    }
}
