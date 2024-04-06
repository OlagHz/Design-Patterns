package Controller.Gui;

import Model.Expense.Expense;
import Model.Expense.ExpenseFactory;
import Model.User.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddExpenseController {
    private Expense expense;
    public AddExpenseController(User user) {
        JFrame frame = new JFrame("Add| Personal Finance Tracker");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                new MainExpenseController(user); // Create a new instance of MainExpenseController when the frame is closed
            }
        });

        JPanel panel = new JPanel(new GridLayout(0, 2));
        frame.add(panel);


        String[] expenseTypes = {"NonDeductible", "TaxDeductible","Tin(TaxDeductible)","Plastic(TaxDeductible)"};
        JComboBox<String> typeDropdown = new JComboBox<>(expenseTypes);
        panel.add(new JLabel("Expense Type:"));
        panel.add(typeDropdown);

        JTextField nameField = new JTextField();
        panel.add(new JLabel("Expense Name:"));
        panel.add(nameField);


        JTextField costField = new JTextField();
        panel.add(new JLabel("Expense Cost:"));
        panel.add(costField);

        JPanel taxPanel = new JPanel(new GridLayout(0, 2));
        JComboBox<String> taxDropdown = new JComboBox<>();
        taxPanel.add(new JLabel("Tax Type:"));
        taxPanel.add(taxDropdown);

        typeDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    frame.revalidate();

            }
        });

        JButton addButton = new JButton("Add Expense");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String expenseType = (String) typeDropdown.getSelectedItem();
                String expenseName = nameField.getText();
                double expenseCost = Double.parseDouble(costField.getText());


                ExpenseFactory factory = new ExpenseFactory();
                if(expenseType != null)
                {

                    if (expenseType.equals("NonDeductible")) {
                        expense = factory.createExpense("Factory.NonDeductible", expenseName, expenseCost);
                    }
                    else if(expenseType.equals("TaxDeductible")){
                        expense = factory.createExpense("Factory.TaxDeductible", expenseName, expenseCost);
                    }
                    else if(expenseType.equals("Tin(TaxDeductible)")){
                        expense = factory.createExpense("Factory.Tin", expenseName, expenseCost);
                    }
                    else if(expenseType.equals("Plastic(TaxDeductible)")){
                        expense = factory.createExpense("Factory.Plastic", expenseName, expenseCost);
                    }

                    user.addExpense(expense);
                    new MainExpenseController(user);

                    frame.dispose();
                }
            }
        });
        panel.add(addButton);

        frame.setVisible(true);
    }
}
