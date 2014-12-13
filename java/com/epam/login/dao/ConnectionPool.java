/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.login.dao;

import com.epam.login.manager.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vova
 */
public class ConnectionPool {

    private static final ConnectionPool instance = new ConnectionPool();
    private static final Deque<Connection> pool = new ArrayDeque<Connection>();
    private static final int COUNT = 10;

    private ConnectionPool() {

        for (int i = 0; i < COUNT; i++) {

            try {
                Class.forName(Config.getInstance().getProperty(Config.DRIVER));
                pool.add(DriverManager.getConnection(Config.getInstance().getProperty(Config.URL)));

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public static ConnectionPool getInstance() {
        return instance;
    }

    public Connection getConnection() {

        return pool.poll();
    }

    public void free(Connection con) {

        pool.add(con);
    }

}
