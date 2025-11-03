package app;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseSetup {
    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS transacoes (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tipo TEXT NOT NULL," +
                "descricao TEXT NOT NULL," +
                "VALOR real not null," +
                "data TEXT NOT NULL" +
                ");";
        try (Connection conn = DatabaseConnection.connect();
        Statement stmt = conn.createStatement()) {

        stmt.execute(sql);
        System.out.println(" Tabela criada/verificada!");

        }catch (Exception e) {
        System.out.println(" Erro ao criar tabela:" + e.getMessage());
        }
    }
}
