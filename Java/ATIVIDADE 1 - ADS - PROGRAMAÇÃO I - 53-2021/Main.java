//package com.company;

class Cliente {
    private final String nome;
    private final short idade;
    private final String cpf;

    Cliente(String nome, short idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public short getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s - Idade: %s - CPF: %s", nome, idade, cpf);
    }
}

abstract class Conta {
    private final long numero;
    private final short agencia;
    private final String tipo_conta;
    private final Cliente cliente;
    private double saldo = 0;


    Conta(long numero, short agencia, String tipo_conta, Cliente cliente) {
        if (numero <= 0 || agencia <= 0) {
            throw new IllegalArgumentException("O número da conta e agência devem ser maior que 0.\n");
        }
        this.numero = numero;
        this.agencia = agencia;
        this.tipo_conta = tipo_conta;
        this.cliente = cliente;
    }

    public long getNumero() {
        return numero;
    }

    public short getAgencia() {
        return agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double valor) {
        this.saldo += valor;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            setSaldo(valor);
            System.out.format("Depósito de R$%.4f efetuado com sucesso.\n", valor);
        }
        else {
            System.out.println("Erro ao efetuar depósito. O valor deve ser maior que R$0,00.\n");
        }
    }

    abstract public void sacar(double valor);

    @Override
    public String toString(){
        return String.format("Nº da conta: %s%nAgência: %s%nTipo de Conta: %s%nCliente: %s%nSaldo: R$%.4f\n", numero, agencia, tipo_conta, cliente, saldo);
    }
}

class ContaCorrente extends Conta {
    ContaCorrente(long numero, short agencia, Cliente cliente) {
        super(numero, agencia, "Corrente", cliente);
    }

    public void sacar(double valor) {
        double taxa_saque = 0.1;
        if (valor <= 0)
        {
            System.out.println("Erro ao efetuar saque. O valor deve ser maior que R$0,00.\n");
        }
        else{
            if ((getSaldo() - (valor + taxa_saque)) >= 0) {
                setSaldo(-(valor+ taxa_saque));
                System.out.format("Saque de R$%.4f efetuado com sucesso. Taxa de saque de R$0,1 descontada.\n", valor);
            }
            else {
                System.out.println("Erro ao efetuar saque. " +
                        "O valor do saque deve ser maior do que o saldo da conta somado à taxa de R$0,1.\n");
            }
        }
    }
}

class ContaPoupanca extends Conta {

    ContaPoupanca(long numero, short agencia, Cliente cliente) {
        super(numero, agencia, "Poupança", cliente);
    }

    public void sacar(double valor) {
        if (valor <= 0)
        {
            System.out.println("Erro ao efetuar saque. O valor deve ser maior que R$0,00.\n");
        }
        else{
            if ((getSaldo() - valor) >= 0) {
                setSaldo(-valor);
                System.out.format("Saque de R$%.4f efetuado com sucesso.\n", valor);
            }
            else {
                System.out.println("Erro ao efetuar saque. " +
                        "O valor do saque deve ser maior do que o saldo da conta.\n");
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Sérgio Melges", (short) 23, "741.274.112-78");
        ContaCorrente contaCorrente = new ContaCorrente(1024512, (short) 747, cliente);
        ContaPoupanca contaPoupanca = new ContaPoupanca(2741642, (short) 747, cliente);

        contaCorrente.depositar(10.20);
        contaCorrente.sacar(10.1);
	    System.out.println("\n"+contaCorrente);

        contaPoupanca.depositar(5);
        contaPoupanca.sacar(4.37);
        System.out.println("\n"+contaPoupanca);
    }
}
