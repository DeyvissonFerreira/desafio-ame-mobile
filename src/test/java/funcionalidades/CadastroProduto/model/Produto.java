package funcionalidades.CadastroProduto.model;

import funcionalidades.CadastroProduto.Grupo;

public class Produto {
	
	public String codigo, descricao, unidade, valor, lote;
	public int quantidade;
	public Grupo grupo;
	
	public Produto(String codigo, String descricao, String unidade, int quantidade, String valor, String lote, Grupo grupo) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.unidade = unidade;
		this.quantidade = quantidade;
		this.valor = valor;
		this.lote = lote;
		this.grupo = grupo;
	}
}