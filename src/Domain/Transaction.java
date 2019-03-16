package Domain;

import java.util.Objects;

public class Transaction {

    private String id, idDrug, idCard;
    private int nr;
    private String dateHour;


    public Transaction(String id, String idDrug, String idCard, int nr, String dateHour) {
        this.id = id;
        this.idDrug = idDrug;
        this.idCard = idCard;
        this.nr = nr;
        this.dateHour = dateHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction transaction = (Transaction) o;
        return Objects.equals(id, transaction.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", idDrug='" + idDrug + '\'' +
                ", idCard='" + idCard + '\'' +
                ", nr=" + nr +
                ", dateHour='" + dateHour + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdDrug() {
        return idDrug;
    }

    public void setIdDrug(String idDrug) {
        this.idDrug = idDrug;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public String getDateHour() {
        return dateHour;
    }

    public void setDateHour(String dateHour) {
        this.dateHour = dateHour;
    }
}
//id, id_medicament, id_card_client (poate fi nul), nr_bucăți, data și ora.
// Dacă există un card client, atunci aplicați o reducere de 10% dacă medicamentul nu necesită rețetă și de 15% dacă necesită.
// Se tipărește prețul plătit și reducerile acordate.