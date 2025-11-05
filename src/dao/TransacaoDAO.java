package app.dao;

import app.model.DatabaseConnection;

import app.model.Transacao;
import java.sql.*;

public class TransacaoDAO {

    public static void salvar(Transacao t) {
        String sql = "INSERT INTO transacoes (tipo, descricao, valor) VALUES (?,?,?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, t.getTipo());
            pstmt.setString(2, t.getDescricao());
            pstmt.setDouble(3, t.getValor());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    public static void listar() {
        String sql = "SELECT * FROM transacoes";

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("tipo") + " | " +
                                rs.getString("descricao") + " | R$ " +
                                rs.getDouble("valor"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
    }

    public static double calcularSaldo() {
        String sql = "SELECT SUM(valor) as total FROM transacoes";
        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            return rs.getDouble("total");

        } catch (SQLException e) {
            return 0;
        }
    }

    public static void excluir(int id) {
        String sql = "DELETE FROM transacoes WHERE id=?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Transação removida!");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }
    }
}

