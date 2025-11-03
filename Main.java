package app;

import dao.TransacaoDAO;
import model.Transacao;
import model.Despesas;
import model.Receita;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DatabaseSetup.createTable();

        Scanner sc = new Scanner(System.in);
        java.util.List<Transacao> transacoes = new java.util.ArrayList<>();
        int opcao;

        do {
            System.out.println("\n=== CONTROLE FINANCEIRO ===");
            System.out.println("1. Adicionar Receita");
            System.out.println("2. Adicionar Despesa");
            System.out.println("3. Listar Transações");
            System.out.println("4. Ver Saldo");
            System.out.println("5. Excluir transação");
            System.out.println("0. Sair");
            System.out.println("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine(); //limpar buffer

            switch (opcao) {
                case 1 -> {
                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();
                    System.out.print("Valor: ");
                    double val = sc.nextDouble();

                    Receita r = new Receita(desc, val, LocalDate.now());
                    transacoes.add(r);
                    TransacaoDAO.salvar(r);
                    break;
                }
                case 2 -> {
                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();
                    System.out.print("Valor: ");
                    double val = sc.nextDouble();

                    Despesas d = new Despesas(desc, val, LocalDate.now());
                    transacoes.add(d);
                    TransacaoDAO.salvar(d);
                    break;
                }
                case 3 -> {
                    System.out.println("\n--- Transações ---");
                    for (Transacao t : TransacaoDAO.listar()) {
                        System.out.printf("ID: %d |[%s] %s - R$ %.2f (%s)\n",
                               t.getId(), t.getTipo(), t.getDescricao(), t.getValor(), t.getData());
                    }
                    break;
                }

                case 4 -> {
                    double saldo = 0;
                    for (Transacao t : TransacaoDAO.listar()) {
                        if (t.getTipo().equals("Receita")) saldo += t.getValor();
                        else saldo -= t.getValor();
                    }
                    System.out.printf("Saldo atual: R$ %.2f\n", saldo);
                    break;
                }
                case 5 -> {
                    System.out.println("Digite o ID da transação para excluir:");
                    int idExcluir = sc.nextInt();
                    TransacaoDAO.deletar(idExcluir);
                    break;
                }
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida");
            }

        } while (opcao != 0);
    }
}