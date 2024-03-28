package View;

import Model.Expense;

public class ExpenseView {

    public void printExpense(Expense model) {
        System.out.println("Total: "+ model.calculateTotal());
        System.out.println("Name: " + model.getName());
    }
}
