package Model;

public class TinTaxDecorator extends ExpenseWrapper{
    public TinTaxDecorator(TaxDeductibleExpense expense) {
        super(expense);
    }
    @Override
    public Double calculateTotal() {
        total= 0.15 + getCost() + (((double) getTax() /100)* getCost());
        return total;
    }

}
