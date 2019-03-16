package Repository;

import Domain.Transaction;
import Domain.TransactionValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionRepository {
    private Map<String, Transaction> storage = new HashMap<>();
    private TransactionValidator validator;


    /**
     *
     * @param transactionValidator
     */

    public TransactionRepository(TransactionValidator transactionValidator){
        this.validator = transactionValidator;
    }

    public Transaction getById(String id){
        return storage.get(id);
    }


    /**
     *
     * @param transaction
     */
    public void insert(Transaction transaction){
        if (storage.containsKey(transaction.getId())){
            throw new RuntimeException(String.format("There already is a transaction with id=%s",transaction.getId()));
        }

        validator.validate(transaction);
        storage.put(transaction.getId(), transaction);
    }

    /**
     *
     * @param transaction
     */
    public void update(Transaction transaction){
        if (!storage.containsKey(transaction.getId())){
            throw new RuntimeException(String.format("There is no transaction with id=%s",transaction.getId()));
        }

        validator.validate(transaction);
        storage.put(transaction.getId(), transaction);
    }

    /**
     *
     * @param id
     */
    public void remove(String id){
        if (!storage.containsKey(id)){
            throw new RuntimeException(String.format("There is no transaction with id=%s", id));
        }
        storage.remove(id);
    }

    public List<Transaction> getAll(){
        return new ArrayList<>(storage.values());
    }
}
