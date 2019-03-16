package Domain;

public class TransactionValidator {

    public void validate(Transaction transaction){


        String errors = "";
        if (transaction.getId().length() <= 0) {
            errors += "The id must be > 0!\n";
        }
        if (transaction.getNr() <= 0) {
            errors += "The number must be > 0!\n";
        }

        if (!errors.isEmpty()) {
            throw new RuntimeException(errors);
        }
    }

}
