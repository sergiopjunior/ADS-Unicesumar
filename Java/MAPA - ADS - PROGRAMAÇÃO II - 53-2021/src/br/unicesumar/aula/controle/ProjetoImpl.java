package br.unicesumar.aula.controle;

import br.unicesumar.aula.exceptions.DadoConsultadoException;
import br.unicesumar.aula.modelo.Projeto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProjetoImpl implements ProjetoDAO {
    //Collection que irá armazenar todos os projetos
    private static Set<Projeto> projetos = new HashSet<>();


    @Override
    public void adicionar(Projeto projeto) {
        projetos.add(projeto);
    }

    @Override
    public List<Projeto> listar() {
        return new ArrayList<>(projetos);
    }

    @Override
    public Projeto consultarPorNome(String nome) throws DadoConsultadoException {
        for(Projeto projeto: projetos){
            if (projeto.getNome().equalsIgnoreCase(nome)){
                return projeto;
            }
        }
        throw new DadoConsultadoException(String.format("Projeto com o nome %s não encontrado.", nome));
    }

    @Override
    public Projeto alterar(String nome, Projeto projeto) throws DadoConsultadoException {
        Projeto projeto_alterar = consultarPorNome(nome);
        projeto_alterar.substituir(projeto);
        return projeto_alterar;
    }

    @Override
    public void excluir(Projeto projeto) throws DadoConsultadoException, UnsupportedOperationException {
        if (projetos.contains(projeto)) {
            projetos.remove(projeto);
        }
        else{
            throw new DadoConsultadoException("Projeto não encontrado.");
        }
    }

    @Override
    public void excluir(String nome) throws DadoConsultadoException, UnsupportedOperationException {
        boolean b = (projetos.removeIf(projeto -> projeto.getNome().equalsIgnoreCase(nome)));
        if (!b)
        {
            throw new DadoConsultadoException(String.format("Projeto com o nome %s não encontrado.", nome));
        }
    }
}