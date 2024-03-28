package Model;

public interface Expense {
    public String getName();
    public Double getCost();
    public String getCreatedBy();
    public Double calculateTotal();
}
