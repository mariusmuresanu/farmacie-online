import Domain.DrugValidator;
import Repository.DrugRepository;
import Service.DrugService;
import UI.Console;

public class Main {

    public static void main(String[] args) {
        DrugValidator drugValidator = new DrugValidator();


        DrugRepository drugRepository = new DrugRepository(drugValidator);


        DrugService drugService = new DrugService(drugRepository);


        Console console = new Console(drugService);
        console.run();



    }
}
