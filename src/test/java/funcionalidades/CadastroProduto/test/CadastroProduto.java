package funcionalidades.CadastroProduto.test;

import java.util.Random;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import funcionalidades.CadastroProduto.help.HelpCadastroProduto;
import funcionalidades.CadastroProduto.model.Produto;
import setup.Capabilities;

public class CadastroProduto extends Capabilities{
	
	private HelpCadastroProduto hp;
	Produto produto;
	String CT;
	
	@BeforeClass
	public void init() {
		hp = new HelpCadastroProduto();
		produto = hp.gerarProduto();
	}
	
	@Test
	public void CEN01_CadastrarProduto() {
		CT = "<b> Cadastrar Produto </b> \n";
		hp.acionarNovo();
		hp.preencherCodigo(produto.codigo);
		hp.preencherDescricao(produto.descricao);
		hp.preencherUnidade(produto.unidade);
		hp.preencherQuantidade(produto.quantidade);
		hp.preencherValorUnitario(produto.valor);
		hp.preencherLote(produto.lote);
		hp.acionarSalvar();
		hp.validarCadastroAlteracaoProduto(CT, produto);
	}

	@Test
	public void CEN02_EditarProduto() {
		CT = "<b> Editar Produto </b> \n";
		produto.codigo = String.valueOf(new Random().nextInt(10));
		hp.acionarEditar();
		hp.preencherCodigo(produto.codigo);
		hp.acionarSalvar();
		hp.validarCadastroAlteracaoProduto(CT, produto);
	}
	
	@Test
	public void CEN03_AdicionarUnidadeEstoque() {
		CT = "<b> Adicionar Unidade Produto </b> \n";
		produto.quantidade += 1;
		hp.acionarEntrada();
		hp.preencherQuantidadeEntrada(1);
		hp.acionarSalvar();
		hp.validarestoqueProduto(CT, produto);
	}
	
	@Test
	public void CEN04_RetirarUnidadeEstoque() {
		CT = "<b> Retirar Unidade Produto </b> \n";
		produto.quantidade -= 1;
		hp.acionarSaida();
		hp.preencherQuantidadeSaida(1);
		hp.acionarSalvar();
		hp.validarestoqueProduto(CT, produto);
	}
}
