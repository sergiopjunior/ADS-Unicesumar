package com.mapa_unicesumar.objetos;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class NoProduto {
    private Produto elemento;
    private NoProduto anterior;
    private NoProduto proximo;

    public Produto getElemento() {
        return elemento;
    }

    public void setElemento(Produto elemento) {
        this.elemento = elemento;
    }

    public NoProduto getAnterior() {
        return anterior;
    }

    public void setAnterior(NoProduto anterior) {
        this.anterior = anterior;
    }

    public NoProduto getProximo() {
        return proximo;
    }

    public void setProximo(NoProduto proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return this.getElemento().toString();
    }
}

public class ProdutosLista {
    private NoProduto primeiro_no;
    private NoProduto ultimo_no;
    private int tamanho = 0;
    private int proximo_codigo;


    public ProdutosLista() {
        this.setTamanho(0);
        this.setProximoCodigo();
    }

    public int getTamanho() {
        return tamanho;
    }

    private void setTamanho(int valor) {
        this.tamanho += valor;
    }

    private int getProximoCodigo() {
        return proximo_codigo;
    }

    private void setProximoCodigo() {
        this.proximo_codigo += 1;
    }

    public void inserirProduto(Produto novo_produto) {
        novo_produto.setCodigo(this.getProximoCodigo());
        NoProduto novo_no = new NoProduto();
        novo_no.setElemento(novo_produto);

        if (this.getTamanho() == 0) {
            this.primeiro_no = novo_no;
        }
        else {
            this.ultimo_no.setProximo(novo_no);
            novo_no.setAnterior(this.ultimo_no);
        }
        this.ultimo_no = novo_no;
        this.setTamanho(1);
        this.setProximoCodigo();
    }

    public void excluirProduto(String produto_nome) {
        NoProduto no_excluir = this.buscarNoPorNome(produto_nome);
        NoProduto no_anterior;
        NoProduto no_proximo;

        if (this.getTamanho() == 1) {
            this.primeiro_no = null;
            this.ultimo_no = null;
        }
        else if (no_excluir.toString().equalsIgnoreCase(this.ultimo_no.toString()))
        {
            no_anterior = this.ultimo_no.getAnterior();
            no_anterior.setProximo(null);
            this.ultimo_no = no_anterior;
        }
        else if (no_excluir.toString().equalsIgnoreCase(this.primeiro_no.toString()))
        {
            no_proximo = this.primeiro_no.getProximo();
            no_proximo.setAnterior(null);
            this.primeiro_no = no_proximo;
        }
        else {
            no_anterior = no_excluir.getAnterior();
            no_proximo = no_excluir.getProximo();

            no_anterior.setProximo(no_proximo);
            no_proximo.setAnterior(no_anterior);
        }

        this.setTamanho(-1);
        System.gc();
    }

    public void atualizarProduto(String produto_nome, Produto produto_alterado) {
        NoProduto no_produto = buscarNoPorNome(produto_nome);

        no_produto.getElemento().setPrecoUnitario(produto_alterado.getPrecoUnitario());
        no_produto.getElemento().setUnidade(produto_alterado.getUnidade());
        no_produto.getElemento().setQuantidadeEmEstoque(produto_alterado.getQuantidadeEmEstoque());
    }

    private void atualizarPrecoProduto(Produto produto, float reajuste) {
        double novo_preco = (produto.getPrecoUnitario() * (reajuste/100)) + produto.getPrecoUnitario();
        produto.setPrecoUnitario(novo_preco);
    }

    public void reajustarPreco(StringBuilder produtos_nomes, float reajuste) {
        NoProduto cabeca = this.primeiro_no;

        while (cabeca != null) {
            Produto produto = cabeca.getElemento();
            if (produtos_nomes.toString().contains(produto.getNome()))
            {
                this.atualizarPrecoProduto(produto, reajuste);
            }

            cabeca = cabeca.getProximo();
        }
    }

    public void reajustarPreco(float reajuste) {
        NoProduto cabeca = this.primeiro_no;

        while (cabeca != null) {
            Produto produto = cabeca.getElemento();
            this.atualizarPrecoProduto(produto, reajuste);

            cabeca = cabeca.getProximo();
        }
    }

    private NoProduto buscarNoPorNome(String produto_nome) {
        NoProduto cabeca = this.primeiro_no;

        while(cabeca != null) {
            if (cabeca.getElemento().getNome().equalsIgnoreCase(produto_nome)) {
                break;
            }
            cabeca = cabeca.getProximo();
        }

        return cabeca;
    }

    public Produto listarProdutoPorNome(String produto_nome) {
        NoProduto no_produto = this.buscarNoPorNome(produto_nome);
        Produto result = null;

        if (no_produto != null) {
            result = no_produto.getElemento();
        }

        return result;
    }

    public void listarProdutos() {
       if (this.getTamanho() > 0) {
           NoProduto cabeca = this.primeiro_no;

           while (cabeca != null) {
               System.out.println(cabeca);
               cabeca = cabeca.getProximo();
           }
       }
       else {
           System.out.println("Não existem produtos cadastrados. Cadastre um produto para gerar um relatório.");
       }
    }
}
