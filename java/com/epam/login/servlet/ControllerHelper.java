/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.login.servlet;

import com.epam.login.commands.CommandLogin;
import com.epam.login.commands.CommandMissing;
import com.epam.login.commands.ICommand;
import com.epam.login.commands.LogoutCommand;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Artem
 */
public class ControllerHelper {

    private static ControllerHelper instance = null;
    HashMap<String, ICommand> commands = new HashMap<String, ICommand>();

    public ControllerHelper() {
        commands.put("login", new CommandLogin());
        commands.put("logOut", new LogoutCommand());
    }

    public ICommand getCommand(HttpServletRequest request) {
        ICommand command = commands.get(request.getParameter("command"));
        if (command == null) {
            command = new CommandMissing();
        }
        return command;
    }

    public static ControllerHelper getInstance() {
        if (instance == null) {
            instance = new ControllerHelper();
        }
        return instance;
    }
}
