package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "user")
@JsonIgnoreProperties("id")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String UserName;

    @Column(name = "email", nullable = false, unique = true)
    private String Email;

//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "accessToken", unique = true)
    private String AccessToken;

//    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private Set<MonitoredEndpoint> monitoredEndpoints;

    /** Arguments Constructor.
     *
     * @param id id
     * @param userName name
     * @param Email email
     * @param AccessToken token
     */
    public User(int id, String userName, String Email, String AccessToken) {
        this.id = id;
        this.UserName = userName;
        this.Email = Email;
        this.AccessToken = AccessToken;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setAccessToken(String accessToken) {
        AccessToken = accessToken;
    }

//    public void setMonitoredEndpoints(Set<MonitoredEndpoint> monitoredEndpoints) {
//        this.monitoredEndpoints = monitoredEndpoints;
//    }


    public int getId() {
        return id;
    }

    public String getUserName() {
        return UserName;
    }

    public String getEmail() {
        return Email;
    }

    public String getAccessToken() {
        return AccessToken;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
