package Service;

import Domain.Transaction;
import Repository.TransactionRepository;

import java.util.List;

public class TransactionService {
    private TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public void insert (String id, String idDrug, String idCard, int nr, String dateHour){
        Transaction transaction = new Transaction(id, idDrug, idCard, nr, dateHour);
        repository.insert(transaction);
    }

    public void update (String id, String idDrug, String idCard, int nr, String dateHour){
        Transaction transaction = new Transaction(id, idDrug, idCard, nr, dateHour);
        repository.update(transaction);
    }

    public void remove (String id){
        repository.remove(id);
    }

    public List<Transaction> getAll(){
        return repository.getAll();
    }
}
