package Model;

public class TaxDeductibleExpense implements Expense {
    private double total;
    private String createdBy;
    private int tax;
    private final double cost;
    private final String name;

    public TaxDeductibleExpense(double cost, String name){
        this.cost = cost;
        this.name = name;
        setTax();
        this.tax = getTax();
    }


    public int getTax() {
        return this.tax;
    }
    public void setTax() {
        if(getCost()< 1000){
            tax = 15;
        }
        else if(getCost()> 1000 && getCost() <= 5000){
            tax = 31;
        }
        else
        {
            tax = 45;
        }
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
        total= cost + (((double) getTax() /100)* cost);
        return total;
    }
}
