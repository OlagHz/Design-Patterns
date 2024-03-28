package Model;

public class PlasticTaxDecorator extends ExpenseWrapper{

    public PlasticTaxDecorator(TaxDeductibleExpense expense) {
        super(expense);
    }
    @Override
    public Double calculateTotal() {
        total= 0.25 + getCost() + (((double) getTax() /100)* getCost());
        return total;
    }

}
