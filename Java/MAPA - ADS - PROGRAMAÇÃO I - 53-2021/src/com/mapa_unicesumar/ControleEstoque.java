package com.mapa_unicesumar;
import com.mapa_unicesumar.comportamentos.Operacoes;
import com.mapa_unicesumar.objetos.ProdutosLista;

import java.util.Scanner;

public class ControleEstoque {
	private final ProdutosLista produtosLista = new ProdutosLista();

	public static void main(String[] args) {
	ControleEstoque app = new ControleEstoque();
	app.tituloMenu();
	app.telaPrincipal();
	}

	private void telaPrincipal() {
		int opcao = 0;
		do {
			opcao = opcaoMenuPadrao();
			this.tituloMenu();
			switch (opcao) {
				case 1 -> menuCadastroProdutos();
				case 2 -> menuMovimentacaoProdutos();
				case 3 -> menuReajustePrecosProdutos();
				case 4 -> menuRelatorioProdutos();
				case 0 -> System.out.println("Saindo do Sistema!");
				default -> opcaoInvalida();
			}
		} while (opcao != 0);
	}

	private int opcaoMenuPadrao() {
		int opcao;
		System.out.println("""
				EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.
					SISTEMA DE CONTROLE DE ESTOQUE
								
						   MENU PRINCIPAL
				1 - CADASTRO DE PRODUTOS
				2 - MOVIMENTAÇÃO
				3 - REAJUSTE DE PREÇOS
				4 - RELATÓRIOS
				0 - FINALIZAR
				OPÇÃO:\040""");
		opcao = getEscolhaMenu();
		return opcao;
	}

	private void menuCadastroProdutos() {
		int opcao;
		do {
			System.out.println("""
					    CADASTRO DE PRODUTOS
								
							    Menu
					1 - INCLUSÃO
					2 - ALTERAÇÃO
					3 - CONSULTA
					4 - EXCLUSÃO
					0 - RETORNAR
					OPÇÃO:\040""");
			opcao = getEscolhaMenu();
			switch (opcao) {
				case 1 -> Operacoes.cadastrarProduto(this.produtosLista);
				case 2 -> Operacoes.alterarProduto(this.produtosLista);
				case 3 -> Operacoes.consultarProduto(this.produtosLista);
				case 4 -> Operacoes.excluirProduto(this.produtosLista);
				case 0 -> System.out.println("Retornando para o Menu Principal...\n");
				default -> opcaoInvalida();
			}
		} while (opcao != 0);
	}

	private void menuMovimentacaoProdutos() {
		int opcao;
		do {
			System.out.println("""
					  MOVIMENTAÇÃO DOS PRODUTOS
								
								Menu:
					1 - ENTRADA
					2 - SAÍDA
					0 - RETORNAR
					OPÇÃO:\040""");
			opcao = getEscolhaMenu();
			switch (opcao) {
				case 1 -> Operacoes.compraProdutos(this.produtosLista);
				case 2 -> Operacoes.saidaProdutos(this.produtosLista);
				case 0 -> System.out.println("Retornando para o Menu Principal...\n");
				default -> opcaoInvalida();
			}
		} while (opcao != 0);
	}

	private void menuReajustePrecosProdutos() {
		int opcao;
		do {
			System.out.println("""
					REAJUSTE DE PREÇOS DE PRODUTOS
								
								Menu:
					1 - REAJUSTE DE UM OU MAIS PRODUTOS
					2 - REAJUSTE DE TODOS OS PRODUTOS
					0 - RETORNAR
					OPÇÃO:\040""");
			opcao = getEscolhaMenu();
			switch (opcao) {
				case 1 -> Operacoes.reajustePrecoProdutos(this.produtosLista);
				case 2 -> Operacoes.reajustePrecoTodosProdutos(this.produtosLista);
				case 0 -> System.out.println("Retornando para o Menu Principal...\n");
				default -> opcaoInvalida();
			}
		} while (opcao != 0);
	}



	private void menuRelatorioProdutos() {
		Operacoes.relatorioDeProdutos(this.produtosLista);
	}

	private int getEscolhaMenu() {
		try {
			Scanner scanner = new Scanner(System.in);
			return Integer.parseInt(scanner.next());
		}
		catch(Exception e) {
			return getEscolhaMenu();
		}
	}

	private void opcaoInvalida() {
		System.out.println("Opção inválida.");
	}

	private void tituloMenu() {
		System.out.println("CONTROLE DE ESTOQUE...\n");
	}
}
