package UI;

import Domain.ClientCard;
import Domain.Drug;
import Domain.Transaction;
import Service.ClientCardService;
import Service.DrugService;
import Service.TransactionService;

import java.util.Date;
import java.util.Scanner;

public class Console {
    private DrugService drugService;
    private ClientCardService clientCardService;
    private TransactionService transactionService;
    private Scanner scanner;

    public Console(DrugService drugService) {
        this.drugService = drugService;
        this.scanner = new Scanner(System.in);
    }

    public Console(ClientCardService clientCardService){
        this.clientCardService = clientCardService;
        this.scanner = new Scanner(System.in);
    }

    public Console(TransactionService transactionService){
        this.transactionService = transactionService;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            showMenu();

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    runDrugs();
                    break;
                case "2":
                    runClientCards();
                    break;
                case "3":
                    runTransactions();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Optiune invalida!");
                    break;
            }
        }
    }

    private void runTransactions(){
        while (true){
            showTransactionMenu();
            String option = scanner.nextLine();
            switch (option){
                case "1":
                    handleAddTransaction();
                    break;
                case "2":
                    handleUpdateTransaction();
                    break;
                case "3":
                    handleRemoveTransaction();
                    break;
                case "4":
                    handleShowAllTransaction();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Optiune invalida!");
            }
        }
    }

    private void handleShowAllTransaction(){
        for (Transaction transaction : transactionService.getAll()){
            System.out.println(transaction);
        }
    }

    private void handleRemoveTransaction() {
        try {
            System.out.print("Enter id to remove: ");
            String id = scanner.nextLine();

            transactionService.remove(id);

            System.out.println("Transaction removed successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleUpdateTransaction() {
        try {
            System.out.print("Enter id to update: ");
            String id = scanner.nextLine();
            System.out.print("Enter new drug Id: ");
            String idDrug = scanner.nextLine();
            System.out.print("Enter new card Id: ");
            String idCard = scanner.nextLine();
            System.out.print("Enter new transaction numbers:");
            int nr = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter new date&hour: ");
            String dateHour = scanner.nextLine();


            transactionService.update(id, idDrug, idCard, nr, dateHour);

            System.out.println("Transaction updated successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleAddTransaction() {
        try {
            System.out.print("Enter id to update: ");
            String id = scanner.nextLine();
            System.out.print("Enter new drug Id: ");
            String idDrug = scanner.nextLine();
            System.out.print("Enter new card Id: ");
            String idCard = scanner.nextLine();
            System.out.print("Enter new transaction numbers:");
            int nr = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter new date&hour: ");
            String dateHour = scanner.nextLine();


            transactionService.insert(id, idDrug, idCard, nr, dateHour);

            System.out.println("Transaction added successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void showTransactionMenu() {
        System.out.println("1. Add Transaction");
        System.out.println("2. Update Transaction");
        System.out.println("3. Remove Transaction");
        System.out.println("4. Show all Transaction");
        System.out.println("x. Back");
    }



    private void runClientCards(){
        while (true){
            showClientCadrdMenu();
            String option = scanner.nextLine();
            switch (option){
                case "1":
                    handleAddClientCard();
                    break;
                case "2":
                    handleUpdateClientCard();
                    break;
                case "3":
                    handleRemoveClientCard();
                    break;
                case "4":
                    handleShowAllClientCard();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Optiune invalida!");
            }
        }
    }

    private void handleShowAllClientCard(){
        for (ClientCard clientCard : clientCardService.getAll()){
            System.out.println(clientCard);
        }
    }

    private void handleRemoveClientCard() {
        try {
            System.out.print("Enter id to remove: ");
            String id = scanner.nextLine();

            clientCardService.remove(id);

            System.out.println("ClientCard removed successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleUpdateClientCard() {
        try {
            System.out.print("Enter id to update: ");
            String id = scanner.nextLine();
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new firstName: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter new CNP: ");
            String cnp = scanner.nextLine();
            System.out.print("Enter new date of birth: ");
            String birthDate = scanner.nextLine();
            System.out.print("Enter new date of registration: ");
            String registerDate = scanner.nextLine();

            clientCardService.update(id, name, firstName, cnp, birthDate, registerDate);

            System.out.println("ClientCard updated successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleAddClientCard() {
        try {
            System.out.print("Enter id to update: ");
            String id = scanner.nextLine();
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new firstName: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter new CNP: ");
            String cnp = scanner.nextLine();
            System.out.print("Enter new date of birth: ");
            String birthDate = scanner.nextLine();
            System.out.print("Enter new date of registration: ");
            String registerDate = scanner.nextLine();

            clientCardService.insert(id, name, firstName, cnp, birthDate, registerDate);

            System.out.println("ClientCard updated successfully!");
        } catch (RuntimeException rex) {
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void showClientCadrdMenu() {
        System.out.println("1. Add Card");
        System.out.println("2. Update card");
        System.out.println("3. Remove card");
        System.out.println("4. Show all clients cards");
        System.out.println("x. Back");
    }


    private void runDrugs(){
        while (true){
            showDrugsMenu();
            String option = scanner.nextLine();
            switch (option){
                case "1":
                    handleAddDrug();
                    break;
                case "2":
                    handleUpdateDrug();
                    break;
                case "3":
                    handleRemoveDrug();
                    break;
                case "4":
                    handleShowAllDrugs();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Optiune invalida!");
            }
        }
    }

    private void handleShowAllDrugs(){
        for (Drug drug : drugService.getAll()){
            System.out.println(drug);
        }
    }
    private void handleRemoveDrug(){
        try {
            System.out.println("Entre id to remove: ");
            String id = scanner.nextLine();

            drugService.remove(id);

            System.out.println("Drug removed successfully");
        }catch (RuntimeException rex){
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleUpdateDrug(){
        try {
            System.out.println("Enter id to update: ");
            String id = scanner.nextLine();
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.println("Enter new manufacturer: ");
            String manufacturer = scanner.nextLine();
            System.out.println("Enter new price: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter new recipies (true/false): ");
            boolean recipe = Boolean.parseBoolean(scanner.nextLine());

            drugService.uppdate(id, name, manufacturer, price, recipe);

            System.out.println("Drug updated successfully!");
        }catch (RuntimeException rex){
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void handleAddDrug(){
        try {
            System.out.println("Enter id: ");
            String id = scanner.nextLine();
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.println("Enter manufacturer: ");
            String manufacturer = scanner.nextLine();
            System.out.println("Enter price: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter recipe (true/false): ");
            boolean recipe = Boolean.parseBoolean(scanner.nextLine());

            drugService.insert(id, name, manufacturer, price, recipe);

            System.out.println("Drug added successfully!");
        }catch (RuntimeException rex){
            System.out.println("Errors:\n" + rex.getMessage());
        }
    }

    private void showDrugsMenu(){
        System.out.println("1. Add drug");
        System.out.println("2. Update drug");
        System.out.println("3. Remove drug");
        System.out.println("4. Show all drugs");
        System.out.println("x. Back");
    }


    private void showMenu() {
        System.out.println("1. CRUD Drugs");
        System.out.println("2. CRUD Clients");
        System.out.println("3. CRUD Transactions");
        System.out.println("x. Exit");
    }
}
