package pl.sujecki.indiana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sujecki.indiana.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByUsername(String username);
}
