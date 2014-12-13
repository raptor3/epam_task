/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.login.commands;

import com.epam.login.manager.Config;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dimonk
 */
public class LogoutCommand implements ICommand {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
     String page = null;
     HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        page = Config.getInstance().getProperty(Config.LOGIN);
        return page;        

//To change body of generated methods, choose Tools | Templates.
    }

}
