package org.example.service;

import org.example.dao.HistoryOperationDao;
import org.example.dao.UserDao;
import org.example.entity.HistoryOperation;
import org.example.entity.User;
import org.example.entity.calculator.Operation;
import org.example.util.ConsoleWriter;
import org.example.util.ConsoleReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class CalculatorService {
    boolean isStarted = true;
    @Autowired
    private HistoryOperationDao historyOperationDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private Map<String, Operation> getOperation;


    public void run() {
        while (isStarted) {
            showMenu();
            String select = ConsoleWriter.write("Select operation");
            if (select.equals("1")) {
                while (true) {
                    showCalculator();
                    Operation operation = (Operation) operation(getOperation);
                    operation.action();
                }
            } else if (select.equals("2")) {
                history();
            }
            isStarted = false;
        }
        ConsoleReader.read("Goodbye");
    }

    public void history() {
        ConsoleReader.read("History operation:");
        if (historyOperationDao.get().isEmpty()) {
            ConsoleReader.read("Operation is empty");
        }
        User user = userDao.getUserInSession();
        for (HistoryOperation operation : historyOperationDao.get()) {
            if (operation.getUser().equals(user)) {
                ConsoleReader.read(operation);
            }
        }
    }

    public Object operation(Map<String, ?> map) {
        String select = ConsoleWriter.write("Select operation");
        if (map.containsKey(select)) {
            return map.get(select);
        }
        return null;
    }

    private void showMenu() {
        ConsoleReader.read("1 - Calculator\n" +
                "2 - History operations\n" +
                "3 - Log Out\n");
    }

    private void showCalculator() {
        ConsoleReader.read("1 - Addition\n" +
                "2 - Subtraction\n" +
                "3 - Multiply\n" +
                "4 - Divide\n" +
                "0 - Back in menu\n");
    }
}
