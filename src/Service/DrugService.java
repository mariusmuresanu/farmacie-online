package Service;

import Domain.Drug;
import Repository.DrugRepository;

import java.util.List;

public class DrugService {
    private DrugRepository repository;

    public DrugService(DrugRepository repository) {
        this.repository = repository;
    }

    public void insert(String id, String name, String manufacturer, double price, boolean recipies) {
        Drug drug = new Drug(id, name, manufacturer, price, recipies);
        repository.insert(drug);
    }

    public void uppdate(String id, String name, String manufacturer, double price, boolean recipies) {
        Drug drug = new Drug(id, name, manufacturer, price, recipies);
        repository.update(drug);
    }

    public void remove(String id) {
        repository.remove(id);

    }
    public List<Drug> getAll(){
        return repository.getAll();
    }

}
