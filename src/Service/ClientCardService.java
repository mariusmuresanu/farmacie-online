package Service;

import Domain.ClientCard;
import Repository.ClientCardRepository;

import java.util.Date;
import java.util.List;

public class ClientCardService {

    private ClientCardRepository repository;

    public ClientCardService(ClientCardRepository repository){
        this.repository = repository;
    }

    public void insert(String id, String name, String firstName, String cnp, String birthDate, String registerDate){
        ClientCard clientCard = new ClientCard(id, name, firstName, cnp, birthDate, registerDate);
        repository.insert(clientCard);
    }

    public void update(String id, String name, String firstName, String cnp, String birthDate, String registerDate){
        ClientCard clientCard = new ClientCard(id, name, firstName, cnp, birthDate, registerDate);
        repository.update(clientCard);
    }
    public void remove(String id){
        repository.remove(id);
    }

    public List<ClientCard> getAll(){
        return repository.getAll();
    }
}
