package pl.sujecki.indiana.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Roles {

    @Id
    private Long id;
    private String name;

    public Roles() {
    }
}
