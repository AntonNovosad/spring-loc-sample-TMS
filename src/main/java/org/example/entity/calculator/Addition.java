package org.example.entity.calculator;

import org.example.dao.HistoryOperationDao;
import org.example.dao.UserDao;
import org.example.entity.HistoryOperation;
import org.example.util.ConsoleWriter;
import org.example.util.ConsoleReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Addition implements Operation {
    @Autowired
    private HistoryOperationDao historyOperationDao;
    @Autowired
    private UserDao userDao;

    @Override
    public void action() {
        double numberOne = ConsoleWriter.writeDouble("Enter number 1");
        double numberTwo = ConsoleWriter.writeDouble("Enter number 2");
        double result = numberOne + numberTwo;
        ConsoleReader.read("Result = " + result);
        historyOperationDao.add(new HistoryOperation(numberOne, numberTwo, result, "Addition", userDao.getUserInSession()));
    }
}
