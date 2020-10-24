package funcionalidades.CadastroProduto.help;

import java.util.Random;

import org.openqa.selenium.support.ui.ExpectedConditions;

import funcionalidades.CadastroProduto.Grupo;
import funcionalidades.CadastroProduto.model.Produto;
import funcionalidades.CadastroProduto.pgo.PgoCadastroProduto;
import setup.Suporte;
import util.GeradorData;

public class HelpCadastroProduto extends Suporte{

	private PgoCadastroProduto pg;
	
	public HelpCadastroProduto() {
		pg = new PgoCadastroProduto();
	}
	
	public Produto gerarProduto() {
		return new Produto(
				String.valueOf(new Random().nextInt(10)), 
				"Novo Produto_".concat(String.valueOf(new Random().nextInt(10))), "1", 1, "1.99", "B45", Grupo.GERAL);
	}

	public void aguardarTelaCadastro() {
		aguardaElemento(ExpectedConditions.visibilityOf(pg.PAGE_TITLE));
	}
	
	public void acionarNovo() {
		aguardaElemento(ExpectedConditions.elementToBeClickable(pg.BTN_NOVO));
		click(pg.BTN_NOVO);
	}
	
	public void preencherCodigo(String valor) {
		aguardarTelaCadastro();
		aguardaElemento(ExpectedConditions.elementToBeClickable(pg.CMP_CODIGO));
		limparCampo(pg.CMP_CODIGO);
		preencheCampo(pg.CMP_CODIGO, valor);
	}
	
	public void preencherDescricao(String valor) {
		aguardaElemento(ExpectedConditions.elementToBeClickable(pg.CMP_DESCRICAO));
		preencheCampo(pg.CMP_DESCRICAO, valor);
	}
	
	public void preencherUnidade(String valor) {
		aguardaElemento(ExpectedConditions.elementToBeClickable(pg.CMP_UNIDADE));
		preencheCampo(pg.CMP_UNIDADE, valor);
	}
	
	public void preencherQuantidade(int valor) {
		aguardaElemento(ExpectedConditions.elementToBeClickable(pg.CMP_QUANTIDADE));
		preencheCampo(pg.CMP_QUANTIDADE, String.valueOf(valor));
	}
	
	public void preencherValorUnitario(String valor) {
		aguardaElemento(ExpectedConditions.elementToBeClickable(pg.CMP_VALOR_UNITARIO));
		preencheCampo(pg.CMP_VALOR_UNITARIO, valor);
	}
	
	public void preencherLote(String valor) {
		aguardaElemento(ExpectedConditions.elementToBeClickable(pg.CMP_LOTE));
		preencheCampo(pg.CMP_LOTE, valor);
	}
	
	public void preencherQuantidadeEntrada(int valor) {
		aguardaElemento(ExpectedConditions.elementToBeClickable(pg.CMP_QNTD_ENTRADA));
		preencheCampo(pg.CMP_QNTD_ENTRADA, String.valueOf(valor));
	}
	
	public void preencherQuantidadeSaida(int valor) {
		aguardaElemento(ExpectedConditions.elementToBeClickable(pg.CMP_QNTD_SAIDA));
		preencheCampo(pg.CMP_QNTD_SAIDA, String.valueOf(valor));
	}
	
	public void acionarSalvar() {
		click(pg.BTN_SALVAR);
	}
	
	public void acionarEditar() {
		click(pg.BTN_EDITAR);
	}
	
	public void acionarEntrada() {
		click(pg.BTN_ENTRADA);
	}
	
	public void acionarSaida() {
		click(pg.BTN_SAIDA);
	}
	
	public void acionarExcluir() {
		click(pg.BTN_EXCLUIR);
	}
	
	public void validarCadastroAlteracaoProduto(String casoTeste, Produto produto) {
		aguardaElemento(ExpectedConditions.visibilityOf(pg.CARD_PRODUTO));
		verificacao(pg.CMP_CODIGO, produto.codigo);
		verificacao(pg.CMP_DESCRICAO, produto.descricao);
		verificacao(pg.CMP_GRUPO, Grupo.GERAL.getValue());
		verificacao(pg.CMP_UNIDADE, produto.unidade);
		verificacao(pg.CMP_QUANTIDADE, String.valueOf(produto.quantidade));
		verificacao(pg.CMP_VALOR_UNITARIO, produto.valor.replace(".", ","));
		verificacao(pg.CMP_LOTE, produto.lote);
		verificacao(pg.CMP_VALIDADE, new GeradorData().gerarDataAleatorio("dd/MM/yyyy"));
		anexaEvidencia(casoTeste);
	}
	
	public void validarestoqueProduto(String casoTeste, Produto produto) {
		aguardaElemento(ExpectedConditions.visibilityOf(pg.CARD_PRODUTO));
		verificacao(pg.CMP_QUANTIDADE, String.valueOf(produto.quantidade).concat(".0"));
		anexaEvidencia(casoTeste);
	}
}
