package Model.Expense;

public class TinTaxDecorator extends ExpenseWrapper{
    public TinTaxDecorator(TaxDeductibleExpense expense) {
        super(expense);
    }
    @Override
    public Double calculateTotal() {
        return super.calculateTotal() + 0.15;
    }
    @Override
    public String getName() {
        return super.getName()+ "(tin tax)";
    }


}
