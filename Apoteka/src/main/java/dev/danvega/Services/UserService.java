package dev.danvega.Services;


import dev.danvega.Model.*;
import dev.danvega.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService implements ServiceInterface<User>  {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private DermatologistRepository dermatologistRepository;

    @Autowired
    private PharmacistRepository pharmacistRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityServiceImpl authService;

    @Autowired
    private ApotecaryRepository apotecaryRepository;


    @Transactional
    public User saveUsers(UserRequest userRequest){

        User user = null;
        if(userRequest.getRole().equals("admin")){
            user = new Administrator();

            user.setUsername(userRequest.getUsername());
            user.setEmail(userRequest.getEmail());
            user.setLastname(userRequest.getLastname());
            user.setFirstname(userRequest.getFirstname());
            user.setAdress(userRequest.getAdress());
            user.setCity(userRequest.getCity());
            user.setCountry(userRequest.getCountry());
            user.setPhone(userRequest.getPhone());
            user.setFirstTimeLogin(true);

            Apotecary temp = apotecaryRepository.findById(userRequest.getApotecary_id()).orElse(null);
            ((Administrator) user).setApotecary(temp);

            // pre nego sto postavimo lozinku u atribut hesiramo je
            //u.setPassword(passwordEncoder.encode(userRequest.getPassword()));

            user.setEnabled(true);

            List<Authority> auth = authService.findByname("ROLE_ADMIN");
            // u primeru se registruju samo obicni korisnici i u skladu sa tim im se i dodeljuje samo rola USER
            user.setAuthorities(auth);

            administratorRepository.save((Administrator) user);
        }
        if(userRequest.getRole().equals("patient")){

            user = new Patient();

            user.setUsername(userRequest.getUsername());
            user.setEmail(userRequest.getEmail());
            user.setLastname(userRequest.getLastname());
            user.setFirstname(userRequest.getFirstname());
            user.setAdress(userRequest.getAdress());
            user.setCity(userRequest.getCity());
            user.setCountry(userRequest.getCountry());
            user.setPhone(userRequest.getPhone());
            user.setFirstTimeLogin(true);

            // pre nego sto postavimo lozinku u atribut hesiramo je
            //u.setPassword(passwordEncoder.encode(userRequest.getPassword()));

            user.setEnabled(true);

            List<Authority> auth = authService.findByname("ROLE_PATI");
            // u primeru se registruju samo obicni korisnici i u skladu sa tim im se i dodeljuje samo rola USER
            user.setAuthorities(auth);

            patientRepository.save((Patient)user);
        }
        if(userRequest.getRole().equals("dermatologist")){
            user = new Dermatologist();

            user.setUsername(userRequest.getUsername());
            user.setEmail(userRequest.getEmail());
            user.setLastname(userRequest.getLastname());
            user.setFirstname(userRequest.getFirstname());
            user.setAdress(userRequest.getAdress());
            user.setCity(userRequest.getCity());
            user.setCountry(userRequest.getCountry());
            user.setPhone(userRequest.getPhone());
            user.setFirstTimeLogin(true);

            Apotecary temp = apotecaryRepository.findById(userRequest.getApotecary_id()).orElse(null);
            ((Dermatologist) user).setApotecary(temp);

            // pre nego sto postavimo lozinku u atribut hesiramo je
            //u.setPassword(passwordEncoder.encode(userRequest.getPassword()));

            user.setEnabled(true);

            List<Authority> auth = authService.findByname("ROLE_DERMA");
            // u primeru se registruju samo obicni korisnici i u skladu sa tim im se i dodeljuje samo rola USER
            user.setAuthorities(auth);

            dermatologistRepository.save((Dermatologist) user);
        }
        if(userRequest.getRole().equals("pharmacist")){
            user = new Pharmacist();

            user.setUsername(userRequest.getUsername());
            user.setEmail(userRequest.getEmail());
            user.setLastname(userRequest.getLastname());
            user.setFirstname(userRequest.getFirstname());
            user.setAdress(userRequest.getAdress());
            user.setCity(userRequest.getCity());
            user.setCountry(userRequest.getCountry());
            user.setPhone(userRequest.getPhone());
            user.setFirstTimeLogin(true);

            Apotecary temp = apotecaryRepository.findById(userRequest.getApotecary_id()).orElse(null);
            ((Pharmacist) user).setApotecary(temp);

            // pre nego sto postavimo lozinku u atribut hesiramo je
            //u.setPassword(passwordEncoder.encode(userRequest.getPassword()));

            user.setEnabled(true);

            List<Authority> auth = authService.findByname("ROLE_PHARMA");
            // u primeru se registruju samo obicni korisnici i u skladu sa tim im se i dodeljuje samo rola USER
            user.setAuthorities(auth);

            pharmacistRepository.save((Pharmacist)  user);
        }


        return user;
    }


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

    @Transactional
    public User findByUsername(String username) throws Exception {
        User found_user = null;

        if(patientRepository.findByUsername(username) != null){
            found_user = patientRepository.findByUsername(username);
        }
        if(administratorRepository.findByUsername(username) != null) {
            found_user = administratorRepository.findByUsername(username);
        }
        if(dermatologistRepository.findByUsername(username) != null) {
            found_user = dermatologistRepository.findByUsername(username);
        }
        if(pharmacistRepository.findByUsername(username) != null){
            found_user = pharmacistRepository.findByUsername(username);
        }

        return found_user;
    }


    public User findById(Long id) throws AccessDeniedException {
        User found_user = null;

        if(patientRepository.findById(id).orElse(null) == null){
            found_user = patientRepository.findById(id).orElse(null);
        }
        else if(administratorRepository.findById(id).orElse(null) == null) {
            found_user = administratorRepository.findById(id).orElse(null);
        }
        else if(dermatologistRepository.findById(id).orElse(null) == null) {
            found_user = dermatologistRepository.findById(id).orElse(null);
        }
        else if(pharmacistRepository.findById(id).orElse(null) == null){
            found_user = pharmacistRepository.findById(id).orElse(null);
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
