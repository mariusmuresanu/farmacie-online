package Domain;

public class DrugValidator {
    public void validate (Drug drug){
        String errors = "";
        if (drug.getName().length() <= 0){
            errors +="Name must have characters!\n";
        }
        if (drug.getPrice() <= 0){
            errors += "The price must be > 0! \n";
        }
        if (!errors.isEmpty()){
            throw new RuntimeException(errors);
        }
    }
}
