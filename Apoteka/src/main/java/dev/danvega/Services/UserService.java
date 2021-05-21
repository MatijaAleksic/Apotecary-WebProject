package dev.danvega.Services;


import dev.danvega.Model.Pharmacist;
import dev.danvega.Model.User;
import dev.danvega.Repository.AdministratorRepository;
import dev.danvega.Repository.DermatologistRepository;
import dev.danvega.Repository.PatientRepository;
import dev.danvega.Repository.PharmacistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService implements ServiceInterface<User> {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private DermatologistRepository dermatologistRepository;

    @Autowired
    private PharmacistRepository pharmacistRepository;


    @Transactional
    public User findUser(String username, String password) throws Exception {
        User found_user = null;

        if(patientRepository.findByUsernameAndPassword(username, password) != null){
            found_user = patientRepository.findByUsernameAndPassword(username, password);
        }
        if(administratorRepository.findByUsernameAndPassword(username, password) != null) {
            found_user = administratorRepository.findByUsernameAndPassword(username, password);
        }
        if(dermatologistRepository.findByUsernameAndPassword(username, password) != null) {
            found_user = dermatologistRepository.findByUsernameAndPassword(username, password);
        }
        if(pharmacistRepository.findByUsernameAndPassword(username, password) != null){
            found_user = pharmacistRepository.findByUsernameAndPassword(username, password);
        }

        if(found_user == null){
            throw new Exception("User with given username and password doesn't exists");
        }
        return found_user;
    }


    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findOne(Long id) {
        return null;
    }

    @Override
    public User create(User entity) throws Exception {
        return null;
    }

    @Override
    public User update(User entity, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {

    }
}
