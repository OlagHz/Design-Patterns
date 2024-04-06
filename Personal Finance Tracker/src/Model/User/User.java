package Model.User;

import Controller.Commands.AddExpenseCommand;
import Controller.Commands.DeleteExpenseCommand;
import Controller.Commands.ExpenseInvoker;
import Model.Expense.Expense;
import Model.Expense.TaxDeductibleExpense;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String Name;
    private Double Budget; //How much the user wants to spend in the period
    public ArrayList<Expense> expenseList;
    public ExpenseInvoker invoker = new ExpenseInvoker();

    private List<AddExpenseCommand> addCommandHistory;
    private List<DeleteExpenseCommand> deleteCommandHistory;

    public User(String name, Double budget) {
        Name = name;
        Budget = budget;

        expenseList = new ArrayList<>();
        addCommandHistory = new ArrayList<>();
        deleteCommandHistory = new ArrayList<>();

    }

    public String getName() {
        return Name;
    }

    public Double calculateTotalTax() {
        double yearlyTax = 0.0;
        for (Expense expense : expenseList) {
            if (expense instanceof TaxDeductibleExpense) {
                yearlyTax += ((TaxDeductibleExpense) expense).getTax();
            }
        }
        return yearlyTax;
    }

    public Double calculateSpending() {
        double spending = 0.0;
        for (Expense expense : expenseList) {
                spending += expense.calculateTotal();
            }

        return spending;
    }

    public void addExpense(Expense expense) {

        AddExpenseCommand addCommand = new AddExpenseCommand(this, expense);
        invoker.executeCommand(addCommand);
        addCommandHistory.add(addCommand);
    }

    public void removeExpense(Expense expense) {
        DeleteExpenseCommand deleteCommand = new DeleteExpenseCommand(this, expense);
        invoker.executeCommand(deleteCommand);
        deleteCommandHistory.add(deleteCommand);
    }

    public void undoLastAddAction() {
        if (!addCommandHistory.isEmpty()) {
            AddExpenseCommand lastAddCommand = addCommandHistory.remove(addCommandHistory.size() - 1);
            lastAddCommand.undo();
        }
    }

    public void undoLastRemoveAction() {
        if (!deleteCommandHistory.isEmpty()) {
            DeleteExpenseCommand lastRemoveCommand = deleteCommandHistory.remove(deleteCommandHistory.size() - 1);
            lastRemoveCommand.undo();
        }
    }


    public void setName(String name) {
        Name = name;
    }

    public Double getBudget() {
        return Budget;
    }

    public void setBudget(Double budget) {
        Budget = budget;
    }

    public ArrayList<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(ArrayList<Expense> expenseList) {
        this.expenseList = expenseList;
    }


}
