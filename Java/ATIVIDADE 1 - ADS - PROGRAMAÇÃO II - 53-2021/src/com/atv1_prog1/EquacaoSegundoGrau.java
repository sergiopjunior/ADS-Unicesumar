package com.atv1_prog1;
import com.atv1_prog1.SemSolucaoRealException;
import java.util.Scanner;

public class EquacaoSegundoGrau {

    public static void main(String[] args) {
        EquacaoSegundoGrau app = new EquacaoSegundoGrau();
        app.tituloMenu();
        app.telaPrincipal();
    }

    private void tituloMenu() {
        System.out.println("    EQUAÇÃO DO 2º GRAU...\n");
    }

    private void telaPrincipal() {
        int opcao = 0;
        do {
            try {
                tituloMenu();
                opcao = menuPadrao();
                switch (opcao) {
                    case 1 -> getCoeficientes();
                    case 0 -> System.out.println("Saindo do Sistema!");
                    default -> opcaoInvalida();
                }
            }
            catch (Exception e) {
                System.out.println(e);
                System.out.println("APERTE QUALQUER LETRA + ENTER PARA CONTINUAR");
                Scanner scanner = new Scanner(System.in);
                scanner.next();
            }
        } while (opcao != 0);
    }

    private int menuPadrao() {
        int opcao;
        Scanner sc = new Scanner(System.in);
        System.out.println("""
				    CÁLCULO DE EQUAÇÃO DO 2º GRAU
								
						   MENU PRINCIPAL
				1 - CALCULAR EQUAÇÃO
				0 - FINALIZAR
				OPÇÃO:\040""");
        opcao = getEscolhaMenu();
        return opcao;
    }

    private void getCoeficientes() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o valor de A: ");
        double a = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Insira o valor de B: ");
        double b = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Insira o valor de C: ");
        double c = scanner.nextDouble();

        String equacao = String.format("%fx² + %fx + %fc = 0",a , b, c);


        calcularEquacao(equacao, a, b, c);
        System.out.println("APERTE QUALQUER LETRA + ENTER PARA CONTINUAR");
        scanner.next();
    }

    private void calcularEquacao(String equacao, double a, double b, double c) throws Exception {
        double b2 = b * b;
        double d = b2 - 4*a*c;
        if (d < 0) {
            System.out.println("Delta: " + d);
            throw new SemSolucaoRealException(equacao);
        }
        double r1 = (-b + Math.sqrt(d)) / (2 * a);
        double r2 = (-b - Math.sqrt(d)) / (2 * a);

        System.out.println("Equação: " + equacao);
        System.out.println("Delta: " + d);
        System.out.println("Raíz 1: " + r1);
        System.out.println("Raíz 2: " + r2);
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
}
