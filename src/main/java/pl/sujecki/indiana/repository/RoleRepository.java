package pl.sujecki.indiana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sujecki.indiana.model.EnumRoles;
import pl.sujecki.indiana.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(EnumRoles name);
}
