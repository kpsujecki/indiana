package pl.sujecki.indiana.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Roles {

    @Id
    private Long id;
    private EnumRoles name;

    public Roles() {
    }

    public EnumRoles getName() {
        return name;
    }
}
