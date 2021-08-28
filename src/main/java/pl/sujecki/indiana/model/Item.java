package pl.sujecki.indiana.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Item {

    @Id
    public Long id;
    public String name;

    @ManyToOne
    public User user;
    public String description;
    public String picture;
    public String whenFound;
    public String whereFound;
    public String coordinates;

    public Item() {
    }
}
