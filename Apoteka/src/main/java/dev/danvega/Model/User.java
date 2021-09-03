package dev.danvega.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User implements UserDetails {

    @Id
//    @SequenceGenerator(name="userSeq", sequenceName ="userSeqGen", initialValue = 1, allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeq")
    //@GeneratedValue
    @GeneratedValue (strategy = GenerationType.TABLE)
    private Long id;

    @Column(unique = false, nullable = true)
    private String firstname;

    @Column(unique = false, nullable = true)
    private String lastname;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = false, nullable = true)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = false, nullable = true)
    private String adress;

    @Column(unique = false, nullable = true)
    private String city;

    @Column(unique = false, nullable = true)
    private String country;

    @Column(unique = false, nullable = true)
    private String phone;

    @Column(unique = false, nullable = true)
    private Boolean firstTimeLogin;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "last_password_reset_date")
    private Timestamp lastPasswordResetDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;

    public User(Long id, String firstname, String lastname, String username, String password, String email, String adress, String city, String country, String phone) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.adress = adress;
        this.city = city;
        this.country = country;
        this.phone = phone;
    }

    public User(String firstname, String lastname, String username, String password, String email, String adress, String city, String country, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.adress = adress;
        this.city = city;
        this.country = country;
        this.phone = phone;
    }


    //IZBRISI KAD DOVRSIMO BACKEND OVO SAMO SLUZI DA SE NE CRVENI KOD ZA PRVI SPRINT STO SMO RADILI
    public User(String firstname, String lastname, String username, String password, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User() {
    }

    public User(String firstname, String lastname) {
    }

    public User(String firstname, String lastname, String city, String adress, String phone, String country) {
    }

    public User(Long id, String name, String lastName, String city, String address, String phone, String country) {
        this.id = id;
        this.firstname = name;
        this.lastname = lastName;
        this.city = city;
        this.adress= address;
        this.phone = phone;
        this.country = country;
    }

    public User(String username, String name, String lastName, String city, String address, String phone, String country) {
        this.username = username;
        this.firstname = name;
        this.lastname = lastName;
        this.city = city;
        this.adress= address;
        this.phone = phone;
        this.country = country;
    }

    public User(Long id,  String newPassword) {
        this.id = id;
        this.password = newPassword;
    }

    public User(String firstname, String lastname, String username, String email, String adress, String city, String country, String phone) {
        this.email = email;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
        this.adress= adress;
        this.phone = phone;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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

    public Boolean getFirstTimeLogin() {
        return firstTimeLogin;
    }

    public void setFirstTimeLogin(Boolean firstTimeLogin) {
        this.firstTimeLogin = firstTimeLogin;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }


    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Timestamp getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Timestamp lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
