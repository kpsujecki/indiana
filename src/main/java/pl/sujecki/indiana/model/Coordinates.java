package pl.sujecki.indiana.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coordinates {

    @Id
    private Long id;
    private double x;
    private double y;
}
