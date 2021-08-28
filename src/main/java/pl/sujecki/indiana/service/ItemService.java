package pl.sujecki.indiana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sujecki.indiana.model.Item;
import pl.sujecki.indiana.model.User;
import pl.sujecki.indiana.repository.ItemRepository;
import pl.sujecki.indiana.repository.UserRepository;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;
    private UserRepository userRepository;

    public ItemService(ItemRepository itemRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    public List<Item> findAllByUsername(String username){
        User user = userRepository.getUserByUsername(username);
        return itemRepository.findAllByUser(user);
    }

    public void addNewItem(Item item){
        itemRepository.save(item);
    }

    public void deleteItem(Item item){
        itemRepository.delete(item);
    }
    //TODO
    public void updateItem(Item item) {

    }
}
