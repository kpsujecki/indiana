package pl.sujecki.indiana.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class UserDetails {

    @Id
    private Long id;
    private String name;
    private String surname;
    private String country;
    private String whenCreated;

    public UserDetails() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
