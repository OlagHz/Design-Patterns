package Controller.Gui;

import Model.Expense.Expense;
import Model.User.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainExpenseController {
    private User user;
    private JLabel budgetLabel;
    private JLabel moneyLeftLabel;
    private JLabel spendingLabel;


    public MainExpenseController(User user) {
        this.user = user;

        JFrame frame = new JFrame("Main Expense");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        frame.add(mainPanel);

        JPanel budgetPanel = new JPanel(new GridLayout(2, 2));
        budgetPanel.setBackground(Color.WHITE);
        mainPanel.add(budgetPanel, BorderLayout.NORTH);

        budgetLabel = new JLabel("Name: " + user.getName()+ "  Budget: €" + user.getBudget());

        JButton changeBudgetButton = new JButton("Change Budget");
        changeBudgetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newBudgetString = JOptionPane.showInputDialog("Enter new budget:");
                try {
                    double newBudget = Double.parseDouble(newBudgetString);
                    user.setBudget(newBudget);
                    updateLabels(budgetLabel, spendingLabel, moneyLeftLabel);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Input a number");
                }
            }
        });
        budgetPanel.add(budgetLabel);
        budgetPanel.add(changeBudgetButton);

        JPanel expensesPanel = new JPanel(new GridLayout(0, 3));
        expensesPanel.setBackground(Color.LIGHT_GRAY);
        mainPanel.add(expensesPanel, BorderLayout.CENTER);

        boolean firstExpense = true;
        for (Expense expense : user.getExpenseList()) {
            String formattedTotal = String.format("%.2f", expense.calculateTotal());
            JButton expenseButton = new JButton(expense.getName() + ": €" + formattedTotal);
            expenseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    new DeleteExpenseController(expense, user);
                }
            });
            if (firstExpense) {
                expensesPanel.add(new JLabel());
                firstExpense = false;
            }
            expensesPanel.add(expenseButton);
        }

        JPanel footerPanel = new JPanel();
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        JLabel spendingLabel = new JLabel("Spending: €" + String.format("%.2f", user.calculateSpending()));
        JLabel moneyLeftLabel = new JLabel("Money Left: €" + String.format("%.2f", user.getBudget() - user.calculateSpending()));
        footerPanel.add(spendingLabel);
        footerPanel.add(moneyLeftLabel);

        JButton addButton = new JButton("Add expense");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddExpenseController(user);
                frame.dispose();
            }
        });
        footerPanel.add(addButton);

        frame.setVisible(true);
    }

    private void updateLabels(JLabel budgetLabel, JLabel spendingLabel, JLabel moneyLeftLabel) {
        budgetLabel.setText("Budget: €" + user.getBudget());
        spendingLabel.setText("Spending: €" + String.format("%.2f", user.calculateSpending()));
        moneyLeftLabel.setText("Money Left: €" + String.format("%.2f", user.getBudget() - user.calculateSpending()));
    }
}
