package br.com.caelum.criacionais.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
/*
    public Connection getConnection() {
        try {
            Connection conexao = 
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "usuario", "senha");

            return conexao;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
*/
    public Connection getConnection() {
    	String banco = System.getenv("tipoBanco");
        try {
            Connection conexao = 
                    DriverManager.getConnection("jdbc:"+banco+"mysql://localhost:3306/banco", "usuario", "senha");
            return conexao;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}