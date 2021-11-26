package com.mapa_unicesumar.objetos;

public class Produto {
    private int codigo;
    private String nome;
    private double preco_unitario;
    private String unidade;
    private int quantidade;

    public Produto() {
        this.setNome("");
        this.setPrecoUnitario(0);
        this.setUnidade("");
        this.setQuantidadeEmEstoque(0);
    }

    public int getCodigo() {
        return codigo;
    }

    protected void setCodigo(int value) {
        this.codigo = value;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoUnitario() {
        return preco_unitario;
    }

    public void setPrecoUnitario(double preco_unitario) {
        this.preco_unitario = preco_unitario;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public int getQuantidadeEmEstoque() {
        return quantidade;
    }

    public void setQuantidadeEmEstoque(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setDiminuirQuantidade(int quantidade) {
        this.quantidade -= quantidade;
    }

    public void setAdicionarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    @Override
    public String toString() {
        return String.format("""
                        Código: %d
                        Nome: %s
                        Preço Unitário: R$%.4f
                        Unidade: %s
                        Quantidade em Estoque: %d
                        """,
                this.getCodigo(), this.getNome(), this.getPrecoUnitario(),
                this.getUnidade(), this.getQuantidadeEmEstoque());
    }

    public String toStringInLine() {
        return String.format("Código: %d / Nome: %s / Preço Unitário: R$%.4f / " +
                        "Unidade: %s / Quantidade em Estoque: %s",
                this.getCodigo(), this.getNome(), this.getPrecoUnitario(),
                this.getUnidade(), this.getQuantidadeEmEstoque());
    }
}
