package com.mapa_unicesumar.comportamentos;

import com.mapa_unicesumar.objetos.Produto;
import com.mapa_unicesumar.objetos.ProdutosLista;

import java.util.Scanner;

public final class Utilidades {

    private Utilidades() {}

    public static void mensagemConsultaNaoEncontrada() {
            System.out.println("Produto não encontrado");
    }

    public static void mensagemConsultasNaoEncontrada() {
            System.out.println("Nenhum produto encontrado.");
    }

    public static String getRepetirOperacao() {
        Scanner scanner = new Scanner(System.in);
        String escolha;
        System.out.println("REPETIR OPERAÇÃO ( S/N ) ? ");
        escolha = scanner.next();
        return escolha;
    }

    public static String confirmaOperacao() {
        Scanner scanner = new Scanner(System.in);
        String escolha;
        System.out.println("CONFIRMA OPERAÇÃO ( S/N ) ?");
        escolha = scanner.next();
        return escolha;
    }

    public static boolean validarDadosProduto(Produto produto, ProdutosLista produtosLista, String operacao) {
        short erros = 0;
        String mensagemDeErro = "Os seguintes critérios de validação não foram atendidos:\n";

        String nome = produto.getNome();
        double preco = produto.getPrecoUnitario();
        int qtde = produto.getQuantidadeEmEstoque();

        if (!operacao.equalsIgnoreCase("atualizar")) {
            if (produtosLista.listarProdutoPorNome(nome) != null) {
                mensagemDeErro += String.format("- Produto com nome \"%s\" já cadastrado\n", nome);
                erros += 1;
            }
        }
        if (preco <= 0) {
            mensagemDeErro += "- O preço do produto deve ser maior que zero\n";
            erros += 1;
        }
        if (qtde < 0) {
            mensagemDeErro += "- A quantidade em estoque deve ser maior ou igual a zero\n";
            erros += 1;
        }

        if (erros > 0)
        {
            System.out.println(mensagemDeErro);
            return false;
        }

        return true;
    }
}
