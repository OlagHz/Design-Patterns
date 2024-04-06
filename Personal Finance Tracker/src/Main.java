import Controller.Gui.LoginController;

public class Main {
    public static void main(String[] args) {
//      ExpenseFactory factory = new ExpenseFactory();
//
//        Expense n1 = factory.createExpense("Factory.NonDeductible", "business expense", 1);
//        Expense t1 = factory.createExpense("Factory.TaxDeductible", "tomatoes", 1);
//        Expense t2 = factory.createExpense("Factory.Tin", "canned cola", 1); //Expect 0.6 + 0.09+ 0.15 = 0.84
//        Expense t3 = factory.createExpense("Factory.Plastic", "Bottled Cola", 1);
//
//
//        ExpenseView view = new ExpenseView();
//
//        ExpenseController c1 = new ExpenseController(n1, view);
//        ExpenseController c2 = new ExpenseController(t1, view);
//        ExpenseController c3 = new ExpenseController(t2, view);
//        ExpenseController c4 = new ExpenseController(t3, view);
//
//        c1.updateView();
//        c2.updateView();
//        c3.updateView();
//        c4.updateView();

     /*   User user = new User("Deji", 1000.0);

        user.addExpense(n1);
        user.addExpense(t1);
        user.addExpense(t2);
        user.addExpense(t3);
        user.removeExpense(n1);

        user.undoLastRemoveAction();

        System.out.println("Expense list after adding expenses:");
        for (Expense expense : user.getExpenseList()) {
            System.out.println(expense.getName());
        }*/
        LoginController gui = new LoginController();
    }
}