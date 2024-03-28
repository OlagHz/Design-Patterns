package Controller;

import Model.Expense;
import View.ExpenseView;

public class ExpenseController {
    private Expense model;
    private ExpenseView view;

    public ExpenseController(Expense model, ExpenseView view) {
        this.model = model;
        this.view = view;
    }

    public void updateView() {
        view.printExpense(model);
    }
}
