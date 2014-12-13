/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.login.dao;

import com.sun.xml.ws.transport.tcp.util.ConnectionManagementSettings;
import java.sql.Connection;

/**
 *
 * @author Vova
 */
public class ConnectionManager {
    private static final ConnectionManager instance = new ConnectionManager();
    private static final ConnectionPool pool = ConnectionPool.getInstance();
    private ConnectionManager(){
    
    }
    
    public ConnectionManager getInstance(){
    return instance;
    }
    
    public Connection getConnection(){
        return pool.getConnection();
    }
    
    public void freeConnection(Connection con){
        pool.free(con);
    }
}
