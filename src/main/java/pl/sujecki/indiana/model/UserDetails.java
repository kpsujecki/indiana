package pl.sujecki.indiana.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class UserDetails {

    @Id
    public Long id;
    public String name;
    public String surname;
    public String country;
    public String whenCreated;

    public UserDetails() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
