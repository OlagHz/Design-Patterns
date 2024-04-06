package Controller.Gui;

import Model.Expense.Expense;
import Model.User.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteExpenseController {
    public DeleteExpenseController(Expense expense, User user) {
        JFrame frame = new JFrame("Delete| Personal Finance Tracker");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 1));
        frame.add(panel);

        JLabel label = new JLabel("Do you want to delete this expense " + expense.getName() + "?");
        panel.add(label);

        JButton yesButton = new JButton("Yes");
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.removeExpense(expense);
                frame.dispose();
                new MainExpenseController(user);
            }
        });
        panel.add(yesButton);

        JButton noButton = new JButton("No");
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainExpenseController(user);
            }
        });
        panel.add(noButton);

        frame.setVisible(true);
    }
}
