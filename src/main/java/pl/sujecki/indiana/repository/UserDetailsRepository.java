package pl.sujecki.indiana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sujecki.indiana.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
}
