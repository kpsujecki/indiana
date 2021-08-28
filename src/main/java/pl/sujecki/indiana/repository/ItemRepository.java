package pl.sujecki.indiana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sujecki.indiana.model.Item;
import pl.sujecki.indiana.model.User;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {


    List<Item> findAllByUser(User user);

    Item findItemById(Long id);
}
