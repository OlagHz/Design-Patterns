package Model.Expense;

public class PlasticTaxDecorator extends ExpenseWrapper{

    public PlasticTaxDecorator(TaxDeductibleExpense expense) {
        super(expense);
    }
    @Override
    public Double calculateTotal() {
        return super.calculateTotal() + 0.25;
    }
    @Override
    public String getName() {
        return super.getName()+ "(plastic tax)";
    }


}
