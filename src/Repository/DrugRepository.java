package Repository;

import Domain.Drug;
import Domain.DrugValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrugRepository {

    private Map<String, Drug> storage = new HashMap<>();
    private DrugValidator validator;

    /**
     *
     * @param drugValidator
     */

    public DrugRepository(DrugValidator drugValidator){
        this.validator = drugValidator;
    }
    public Drug getById (String id){
        return storage.get(id);
    }

    /**
     *
     * @param drug
     */
    public void insert(Drug drug){
        if (storage.containsKey(drug.getId())){
            throw new RuntimeException(String.format("There already is a drug with id=%s", drug.getId()));
        }

        validator.validate(drug);
        storage.put(drug.getId(), drug);
    }

    /**
     *
     * @param drug
     */
    public void update(Drug drug){
        if (!storage.containsKey(drug.getId())){
            throw new RuntimeException(String.format("There is no drug with id=%s", drug.getId()));
        }
        validator.validate(drug);
        storage.put(drug.getId(), drug);
    }

    /**
     *
     * @param id
     */
    public void remove(String id){
        if (!storage.containsKey(id)){
            throw new RuntimeException(String.format("There is no drug with id=%s", id));
        }
        storage.remove(id);
    }

    /**
     *
     * @return
     */
    public List<Drug> getAll(){
        return new ArrayList<>(storage.values());
    }
}
