package Controller.Commands;

import Model.Expense.Expense;
import Model.User.User;

public class AddExpenseCommand implements ExpenseCommand {
    private final User user;
    private final Expense expense;

    public AddExpenseCommand(User user, Expense expense) {
        this.user = user;
        this.expense = expense;
    }

    @Override
    public void execute() {
        user.expenseList.add(expense);
    }

    @Override
    public void undo() {
        user.expenseList.remove(expense);
    }
}
