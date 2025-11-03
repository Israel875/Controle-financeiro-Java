package app;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String Url = "jdbc:sqlite:financeiro.db";

    public static Connection connect() {
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(Url);
            System.out.println(" Conectado ao banco SQLite!");
        } catch (SQLException e) {
            System.out.println(" Erro ao conectar ao banco:" + e.getMessage());
        }
        return  conn;
    }
}
