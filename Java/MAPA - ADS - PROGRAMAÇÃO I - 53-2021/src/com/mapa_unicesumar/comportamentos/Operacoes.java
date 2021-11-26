package com.mapa_unicesumar.comportamentos;

import com.mapa_unicesumar.objetos.Produto;
import com.mapa_unicesumar.objetos.ProdutosLista;

import java.util.Scanner;

public final class Operacoes {

    private Operacoes() {}

    public static void cadastrarProduto(ProdutosLista produtosLista) {
        String opcao;
        do {
            System.out.println("CADASTRO DE PRODUTOS");
            Produto novo_produto;

            do {
                novo_produto = setDadosDoProduto();
            } while (!Utilidades.validarDadosProduto(novo_produto, produtosLista, "cadastrar"));

            opcao = Utilidades.confirmaOperacao();
            if (opcao.equalsIgnoreCase("S")) {
                produtosLista.inserirProduto(novo_produto);
                System.out.println("Produto cadastrado com sucesso.");
            }
            opcao = Utilidades.getRepetirOperacao();

        } while (opcao.equalsIgnoreCase("S"));
    }

    public static void alterarProduto(ProdutosLista produtosLista) {
        String escolha;
        boolean is_valid = false;
        do {
            Scanner scanner = new Scanner(System.in);

            System.out.println("ALTERAÇÃO DE PRODUTO");
            System.out.println("Informe o nome do produto a ser alterado: ");
            String produto_nome = scanner.nextLine();

            Produto produto = produtosLista.listarProdutoPorNome(produto_nome);

            if (produto != null) {
                System.out.println("PRODUTO ENCONTRADO\n");
                Produto produto_alterar;

                do {
                    produto_alterar = setDadosDoProduto();
                    is_valid = Utilidades.validarDadosProduto(produto_alterar, produtosLista, "atualizar");

                    if (produto_alterar.getNome().equalsIgnoreCase(produto_nome)) {
                        if (is_valid) {
                            escolha = Utilidades.confirmaOperacao();
                            if (escolha.equalsIgnoreCase("S")) {
                                produtosLista.atualizarProduto(produto_nome, produto_alterar);
                                System.out.println("Produto alterado com sucesso.");
                            }
                        }
                    }
                    else {
                        System.out.println("O nome do produto não pode ser alterado! " +
                                "Para tal deve-se excluí-lo e recadastrá-lo");
                        is_valid = false;
                    }
                } while (!is_valid);
            }
            else {
                Utilidades.mensagemConsultaNaoEncontrada();
            }

            escolha = Utilidades.getRepetirOperacao();

        } while (escolha.equalsIgnoreCase("S"));
    }

    public static void excluirProduto(ProdutosLista produtosLista) {
        String escolha;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("EXCLUSÃO DE PRODUTOS");
            System.out.println("Informe o nome do produto a ser excluído: ");
            String produto_nome = scanner.nextLine();

            Produto produto = produtosLista.listarProdutoPorNome(produto_nome);

            if (produto != null) {
                System.out.println("PRODUTO ENCONTRADO\n");
                escolha = Utilidades.confirmaOperacao();
                if (escolha.equalsIgnoreCase(("S"))) {
                    produtosLista.excluirProduto(produto_nome);
                    System.out.println("PRODUTO DELETADO!\n");
                }
            }
            else {
                Utilidades.mensagemConsultaNaoEncontrada();
            }

            escolha = Utilidades.getRepetirOperacao();

        } while (escolha.equalsIgnoreCase("S"));
    }

    private static Produto setDadosDoProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.println("Informe o preço unitário do produto: ");
        double preco_unitario = scanner.nextDouble();

        System.out.println("Informe a unidade de medida: ");
        scanner = new Scanner(System.in);
        String unidade = scanner.nextLine();

        System.out.println("Informe a quantidade em estoque: ");
        int quantidade = scanner.nextInt();

        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setPrecoUnitario(preco_unitario);
        produto.setUnidade(unidade);
        produto.setQuantidadeEmEstoque(quantidade);

        return produto;
    }

    public static void consultarProduto(ProdutosLista produtosLista) {
        String escolha;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("CONSULTA DE PRODUTOS");
            System.out.println("Informe o nome do produto a ser pesquisado: ");
            String produto_nome = scanner.nextLine();

            Produto produto = produtosLista.listarProdutoPorNome(produto_nome);

            if (produto != null) {
                System.out.println("PRODUTO ENCONTRADO\n");
                System.out.println(produtosLista.listarProdutoPorNome(produto_nome));
            }
            else {
                Utilidades.mensagemConsultaNaoEncontrada();
            }

            escolha = Utilidades.getRepetirOperacao();

        } while (escolha.equalsIgnoreCase("S"));
    }

    public static void compraProdutos(ProdutosLista produtosLista) {
        String escolha;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("ENTRADA DE PRODUTOS");
            System.out.println("Informe o nome do produto a ser pesquisado: ");
            String produto_nome = scanner.nextLine();

            Produto produto = produtosLista.listarProdutoPorNome(produto_nome);

            if (produto != null) {
                System.out.println("PRODUTO ENCONTRADO\n");

                System.out.println("QTDE ATUAL : " + produto.getQuantidadeEmEstoque());
                System.out.println("QTDE ENTRADA : ");
                int quantidadeEntrada = scanner.nextInt();
                System.out.println("QTDE FINAL : " + (produto.getQuantidadeEmEstoque() + quantidadeEntrada));
                escolha = Utilidades.confirmaOperacao();
                if (escolha.equalsIgnoreCase("S")) {
                    produto.setAdicionarQuantidade(quantidadeEntrada);
                    System.out.println("Operação efetuada com sucesso.");
                }
            }
            else {
                Utilidades.mensagemConsultaNaoEncontrada();
            }

            escolha = Utilidades.getRepetirOperacao();

        } while (escolha.equalsIgnoreCase("S"));
    }

    public static void saidaProdutos(ProdutosLista produtosLista) {
        String escolha;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("SAÍDA DE PRODUTOS");
            System.out.println("Informe o nome do produto a ser pesquisado: ");
            String nomeProduto = scanner.nextLine();

            Produto produto = produtosLista.listarProdutoPorNome(nomeProduto);

            if (produto != null) {
                System.out.println("PRODUTO ENCONTRADO\n");

                System.out.println("QTDE ATUAL : " + produto.getQuantidadeEmEstoque());
                System.out.println("QTDE SAÍDA : ");
                int quantidadeSaida = scanner.nextInt();
                System.out.println("QTDE FINAL : " + (produto.getQuantidadeEmEstoque() - quantidadeSaida));
                if (produto.getQuantidadeEmEstoque() < quantidadeSaida) {
                    System.out.println("Quantidade maior que no estoque, saída não é possível");
                }
                else {
                    escolha = Utilidades.confirmaOperacao();
                    if (escolha.equalsIgnoreCase("S")) {
                        produto.setDiminuirQuantidade(quantidadeSaida);
                        System.out.println("Operação efetuada com sucesso.");
                    }
                }
            }
            else {
                Utilidades.mensagemConsultaNaoEncontrada();
            }

            escolha = Utilidades.getRepetirOperacao();

        } while (escolha.equalsIgnoreCase("S"));
    }

    public static void reajustePrecoProdutos(ProdutosLista produtosLista) {
        String escolha;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("REAJUSTE DE PREÇO");
            System.out.println("""
                                Informe os nomes dos produtos a serem pesquisado separados
                                por vírgula + espaço (Ex: Vassoura, Tapete):\040""");
            String nomeProdutos = scanner.nextLine();
            String[] nomes = nomeProdutos.split(", ");

            StringBuilder produtos_encontrados = new StringBuilder("");
            Produto produto;
            for (String n:nomes) {
                produto = produtosLista.listarProdutoPorNome(n);

                if (produto != null) {
                    produtos_encontrados.append(String.format("- %s\n", produto.toStringInLine()));
                }
            }

           if (!produtos_encontrados.isEmpty()) {
                System.out.println("PRODUTOS ENCONTRADOS\n");
                System.out.println(produtos_encontrados);
                System.out.println("Informe o percentual de reajuste: ");
                float reajuste_perc = scanner.nextFloat();

               escolha = Utilidades.confirmaOperacao();
               if (escolha.equalsIgnoreCase("S")) {
                   produtosLista.reajustarPreco(produtos_encontrados, reajuste_perc);
                   System.out.println("Operação efetuada com sucesso.");
               }
            }
           else {
               Utilidades.mensagemConsultasNaoEncontrada();
           }

            escolha = Utilidades.getRepetirOperacao();

        } while (escolha.equalsIgnoreCase("S"));
    }

    public static void reajustePrecoTodosProdutos(ProdutosLista produtosLista) {
        String escolha;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("REAJUSTE DE PREÇO");

            if (produtosLista.getTamanho() > 0) {
                System.out.println("Informe o percentual de reajuste: ");
                float reajuste_perc = scanner.nextFloat();

                escolha = Utilidades.confirmaOperacao();
                if (escolha.equalsIgnoreCase("S")) {
                    produtosLista.reajustarPreco(reajuste_perc);
                    System.out.println("Operação efetuada com sucesso.");
                }
                escolha = Utilidades.getRepetirOperacao();
            }
            else {
                System.out.println("Não existem produtos cadastrados. " +
                        "Cadastre um produto para começar a utilizar o sistema.");
                escolha = "N";
            }

        } while (escolha.equalsIgnoreCase("S"));
    }

    public static void relatorioDeProdutos(ProdutosLista produtosLista) {
        System.out.println("RELATÓRIO\n");
        produtosLista.listarProdutos();

        Scanner scanner = new Scanner(System.in);
        System.out.println("APERTE QUALQUER LETRA + ENTER PARA CONTINUAR");
        scanner.next();
    }
}
