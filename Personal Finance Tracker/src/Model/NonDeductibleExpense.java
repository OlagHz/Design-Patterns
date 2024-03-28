package Model;

public class NonDeductibleExpense implements Expense{
    private String createdBy;
    private final double cost;
    private final String name;

    public NonDeductibleExpense(double cost, String name){
        this.cost = cost;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public Double calculateTotal() {
        return cost;
    }
}
