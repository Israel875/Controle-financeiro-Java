package app;

import app.dao.TransacaoDAO;
import app.model.Transacao;
import app.model.Despesa;
import app.model.Receita;
import app.model.DatabaseSetup;
import app.model.DatabaseConnection;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        DatabaseSetup.createTable();
        Scanner sc = new Scanner(System.in);
        List<Transacao> transacoes = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n=== CONTROLE FINANCEIRO ===");
            System.out.println("1. Adicionar Receita");
            System.out.println("2. Adicionar Despesa");
            System.out.println("3. Listar Transações");
            System.out.println("4. Ver Saldo");
            System.out.println("5. Excluir transação");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            while (!sc.hasNextInt()) {
                System.out.print("Digite um número válido: ");
                sc.next();
            }

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1 -> {
                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();
                    System.out.print("Valor: ");
                    double val = sc.nextDouble();
                    Receita r = new Receita(desc, val);
                    transacoes.add(r);
                    TransacaoDAO.salvar(r);
                }

                case 2 -> {
                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();
                    System.out.print("Valor: ");
                    double val = sc.nextDouble();
                    Despesa d = new Despesa(desc, val);
                    transacoes.add(d);
                    TransacaoDAO.salvar(d);
                }

                case 3 -> TransacaoDAO.listar();

                case 4 -> {
                    double saldo = TransacaoDAO.calcularSaldo();
                    System.out.println("Saldo total: R$ " + saldo);
                }

                case 5 -> {
                    System.out.print("ID da transação para excluir: ");
                    int id = sc.nextInt();
                    TransacaoDAO.excluir(id);
                }

                case 0 -> System.out.println("Saindo...");

                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }
}


