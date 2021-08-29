package pl.sujecki.indiana.model;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    private Long id;
    private String name;

    @ManyToOne
    private User user;
    private String description;
    private String picture;
    private String whenFound;
    private String whereFound;
    @OneToOne
    private Coordinates coordinates;

    public Item() {
    }
}
