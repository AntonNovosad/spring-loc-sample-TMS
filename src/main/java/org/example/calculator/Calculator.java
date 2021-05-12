package org.example.calculator;

import java.util.Scanner;


public class Calculator {
    private Scanner scanner = new Scanner(System.in);
    private boolean isStarted = true;


    public void run() {
        while (isStarted) {
            write("Select operation");
            Operation operation = select();
            operation.action();
        }
        write("Goodbye");
    }

    private void write(String message) {
        System.out.println(message);
    }

    private Operation select() {
        switch (scanner.nextInt()) {
            case 1:
                return new Addition();
            case 2:
                return new Subtraction();
            case 3:
                return new Multiply();
            case 4:
                return new Divide();
            case 0:
                isStarted = false;
        }
        return null;
    }
}
