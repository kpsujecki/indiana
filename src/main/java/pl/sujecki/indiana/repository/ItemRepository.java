package pl.sujecki.indiana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sujecki.indiana.model.Item;
import pl.sujecki.indiana.model.User;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {


    List<Item> findAllByUser(Optional<User> user);

    Item findItemById(Long id);
}
