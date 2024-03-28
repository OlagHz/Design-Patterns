import Controller.ExpenseController;
import Model.Expense;
import Model.ExpenseFactory;
import Model.NonDeductibleExpense;
import Model.TaxDeductibleExpense;
import View.ExpenseView;

public class Main {
    public static void main(String[] args) {
        ExpenseFactory factory = new ExpenseFactory();

        Expense n1 = factory.createExpense("Factory.NonDeductible", "business expense", 200);
        Expense t1 = factory.createExpense("Factory.TaxDeductible", "tomatoes", 200);
        Expense t2 = factory.createExpense("Factory.Tin", "canned cola", 0.6); //Expect 0.6 + 0.09+ 0.15 = 0.84
        Expense t3 = factory.createExpense("Factory.Plastic", "Bottled Cola", 1.5);


        ExpenseView view = new ExpenseView();

        ExpenseController c1 = new ExpenseController(n1, view);
        ExpenseController c2 = new ExpenseController(t1, view);
        ExpenseController c3 = new ExpenseController(t2, view);
        ExpenseController c4 = new ExpenseController(t3, view);

        //c1.updateView();
        //c2.updateView();
        c3.updateView();
        c4.updateView();

    }
}