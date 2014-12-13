/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.login.dao;

/**
 *
 * @author dimonk
 */
public class ActionFactory {
    static ActionFactory actionFactory=new ActionFactory();
    private ActionFactory(){}
    public ActionFactory getInstance(){
        return actionFactory;
    }
}
