package Repository;

import Domain.ClientCard;
import Domain.ClientCardValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientCardRepository {
    private Map<String, ClientCard> storage = new HashMap<>();
    private ClientCardValidator validator;

    /**
     *
     * @param clientCardValidator
     */
    public ClientCardRepository(ClientCardValidator clientCardValidator){
        this.validator = clientCardValidator;
    }
    public ClientCard getById (String id){
        return storage.get(id);
    }

    /**
     *
     * @param clientCard
     */
    public void insert(ClientCard clientCard){
        if (storage.containsKey(clientCard.getId())){
            throw new RuntimeException(String.format("There already is a card with id=%s", clientCard.getId()));
        }
        validator.validate(clientCard);
        storage.put(clientCard.getId(), clientCard);
    }

    /**
     *
     * @param clientCard
     */
    public void update(ClientCard clientCard){
        if (!storage.containsKey(clientCard.getId())){
            throw new RuntimeException(String.format("There is no card with id=%s", clientCard.getId()));
        }
        validator.validate(clientCard);
        storage.put(clientCard.getId(), clientCard);
    }

    /**
     *
     * @param id
     */
    public void remove(String id){
        if (!storage.containsKey(id)){
            throw new RuntimeException(String.format("There is no card with id=%s", id));
        }
        storage.remove(id);
    }

    /**
     * @return
     */
    public List<ClientCard>getAll() {
        return new ArrayList<>(storage.values());
    }

}
