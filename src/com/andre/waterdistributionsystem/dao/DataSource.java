package com.andre.waterdistributionsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Andre Luis Sabino
 * @version 1.1
 * @since 12/04/2017
 */
public class DataSource {
    private String hostname;
    private int port;
    private String database;
    private String username;
    private String password;
    
    private Connection connection;

    public DataSource() {
        try {
            hostname = "localhost";
            port = 3306;
            database = "distribution";
            username = "root";
            password = "";
            
            String url = "jdbc:mysql://"+hostname+":"+port+"/"+database;
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection(url, username, password);
            
            System.out.println("Tudo OK...");
        } 
        catch (SQLException ex) {
            System.err.println("ERRO na conexão com o banco".concat(ex.getMessage()));
        }
        catch(Exception ex){
            System.err.println("ERRO do Sistema, busque o suporte técnico".concat(ex.getMessage()));
        }
    }
   
    public Connection getConnection() {
        return this.connection;
    }
    
    public void closeDataSource(){
        try {
            connection.close();
            
        } catch (Exception ex) {
            System.err.println("Erro ao desconectar do banco"+ex.getMessage());
        }
    }
    
    
}
