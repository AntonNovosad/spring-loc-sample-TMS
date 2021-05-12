package org.example;

import org.springframework.stereotype.Component;

@Component
public class Multiply implements Operation {

    @Override
    public void action() {
        ConsoleReader.reader("Enter number 1");
        double numberOne = ConsoleWriter.numberWriter();
        ConsoleReader.reader("Enter number 2");
        double numberTwo = ConsoleWriter.numberWriter();
        double result = numberOne * numberTwo;
        ConsoleReader.reader("Result = " + result);
    }
}
