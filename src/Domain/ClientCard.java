package Domain;

import java.util.Date;
import java.util.Objects;

public class ClientCard {
    private String id, name, firstName, cnp, birthDate, registerDate;



    public ClientCard(String id, String name, String firstName, String cnp, String birthDate, String registerDate) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.cnp = cnp;
        this.birthDate = birthDate;
        this.registerDate = registerDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientCard clientCard = (ClientCard) o;
        return Objects.equals(id, clientCard.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ClientCard{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", cnp='" + cnp + '\'' +
                ", birthDate=" + birthDate +
                ", registerDate=" + registerDate +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }
}
