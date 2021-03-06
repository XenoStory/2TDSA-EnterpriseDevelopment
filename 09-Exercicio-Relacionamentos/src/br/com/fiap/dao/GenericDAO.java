package br.com.fiap.dao;

import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.RegistroNaoEncontradoException;

public interface GenericDAO<Tabela, Chave>
{
	void cadastrar(Tabela tabela);
	
	void atualizar(Tabela tabela);
	
	void excluir(Chave codigo) throws RegistroNaoEncontradoException;
	
	Tabela buscar(Chave codigo);
	
	void commit() throws CommitException;
}
