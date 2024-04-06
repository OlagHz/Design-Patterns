package Controller.Commands;

import java.util.ArrayList;
import java.util.List;

public class ExpenseInvoker {

    public void executeCommand(ExpenseCommand command) {
        command.execute();
    }
}
