package org.example.service;

import org.example.entity.command.Command;
import org.example.util.ConsoleReader;
import org.example.util.ConsoleWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;


public class UserService {

    @Autowired
    private Map<String, Command> getCommand;

    public void run() {
        while (true) {
            showMenu();Command command = selectCommand();
            if (command == null) {
                ConsoleReader.read("Goodbye");
                break;
            }
            command.action();
        }
    }

    private Command selectCommand() {
        String command = ConsoleWriter.write("Enter operation:");
        if (getCommand.containsKey(command)) {
            return getCommand.get(command);
        }
        return null;
    }

    private void showMenu() {
        ConsoleReader.read("1 - registration\n" +
                "2 - authorization\n" +
                "0 - exit\n");
    }
}
