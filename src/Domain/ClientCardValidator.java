package Domain;

public class ClientCardValidator {

    public void validate (ClientCard clientCard){
        String errors = "";
        if (clientCard.getCnp().length() != 13 ) {
            errors += "The cnp must have 13 digits !\n";
        }

        if (!errors.isEmpty()) {
            throw new RuntimeException(errors);
        }
    }
}
