package pl.sujecki.indiana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sujecki.indiana.model.EnumRoles;
import pl.sujecki.indiana.model.Roles;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles, Long> {

    Optional<Roles> findByName(EnumRoles name);
}
