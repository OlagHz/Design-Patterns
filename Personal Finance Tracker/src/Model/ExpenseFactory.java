package Model;

public class ExpenseFactory {

    public ExpenseFactory(){

    }

    public Expense createExpense(String type, String name, double cost) {
        return switch (type) {
            case "Factory.NonDeductible" -> new NonDeductibleExpense(cost, name);
            case "Factory.TaxDeductible" -> new TaxDeductibleExpense(cost, name);
            case "Factory.Tin" -> new TinTaxDecorator(new TaxDeductibleExpense(cost, name));
            case "Factory.Plastic" -> new PlasticTaxDecorator(new TaxDeductibleExpense(cost, name));
            default -> null;
        };
    }
}
