package org.example.calculator;

import org.example.ConsoleReader;
import org.example.ConsoleWriter;
import org.springframework.stereotype.Component;

@Component
public class Addition implements Operation {

    @Override
    public void action() {
        ConsoleReader.reader("Enter number 1");
        double numberOne = ConsoleWriter.numberWriter();
        ConsoleReader.reader("Enter number 2");
        double numberTwo = ConsoleWriter.numberWriter();
        double result = numberOne + numberTwo;
        ConsoleReader.reader("Result = " + result);
    }
}
