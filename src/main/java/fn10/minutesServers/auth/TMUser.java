package fn10.minutesServers.auth;

import java.net.PasswordAuthentication;
import java.sql.Date;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TMUser {

    private @Id @GeneratedValue Long id;
    private Instant CreationDate;

    private String Username;
    private String Password;

    public TMUser() {}

    public TMUser(Instant creation, String username, String password) {
        this.Username = username;
        this.Password = password;
        this.CreationDate = creation;
    }

    @Id
    public Long getId() {
        return this.id;
    }

    public void setId(Long Id) {
        this.id = Id;
    }

    public Instant getCreation() {
        return this.CreationDate;
    }

    public String getUsername() {
        return this.Username;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setCreation(Date val) {
        this.CreationDate = val;
    }

    public void setUsername(String val) {
        this.Username = val;
    }

    public void setPassword(String val) {
        this.Password = val;
    }
}
