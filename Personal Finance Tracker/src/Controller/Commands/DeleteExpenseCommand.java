package Controller.Commands;

import Model.Expense.Expense;
import Model.User.User;

public class DeleteExpenseCommand implements ExpenseCommand {
    private final User user;
    private final Expense expense;

    public DeleteExpenseCommand(User user, Expense expense) {
        this.user = user;
        this.expense = expense;
    }

    @Override
    public void execute() {
        user.expenseList.remove(expense);
    }

    @Override
    public void undo() {
        user.expenseList.add(expense);
    }
}