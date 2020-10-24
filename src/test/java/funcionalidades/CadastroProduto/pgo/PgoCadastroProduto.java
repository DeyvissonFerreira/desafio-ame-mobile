package funcionalidades.CadastroProduto.pgo;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import setup.Capabilities;

public class PgoCadastroProduto {
	
	public PgoCadastroProduto() {
		PageFactory.initElements(new AppiumFieldDecorator(Capabilities.getDriver()), this);
	}
	
	/**
	 * Lista de Botões
	 */
	
	@AndroidFindBy(id = "br.com.pztec.estoque:id/Button1")
	public MobileElement BTN_NOVO;

	@AndroidFindBy(id = "br.com.pztec.estoque:id/Button3")
	public MobileElement BTN_MENU;
	
	@AndroidFindBy(id = "android:id/search_button")
	public MobileElement BTN_PESQUISAR;

	@AndroidFindBy(id = "br.com.pztec.estoque:id/editar")
	public MobileElement BTN_EDITAR;
	
	@AndroidFindBy(id = "br.com.pztec.estoque:id/deletar")
	public MobileElement BTN_EXCLUIR;
	
	@AndroidFindAll({@AndroidBy(id = "br.com.pztec.estoque:id/btn_gravar_assunto"),
		@AndroidBy(id = "br.com.pztec.estoque:id/btn_salvar")})
	public MobileElement BTN_SALVAR;

	@AndroidFindBy(id = "br.com.pztec.estoque:id/entrada")
	public MobileElement BTN_ENTRADA;
	
	@AndroidFindBy(id = "br.com.pztec.estoque:id/saida")
	public MobileElement BTN_SAIDA;
	
	
	/**
	 * Lista de Campos
	 */

	@AndroidFindBy(id = "br.com.pztec.estoque:id/txt_codigo")
	public MobileElement CMP_CODIGO;

	@AndroidFindBy(id = "br.com.pztec.estoque:id/txt_descricao")
	public MobileElement CMP_DESCRICAO;
	
	@AndroidFindBy(id = "br.com.pztec.estoque:id/txt_unidade")
	public MobileElement CMP_UNIDADE;
	
	@AndroidFindBy(id = "br.com.pztec.estoque:id/txt_quantidade")
	public MobileElement CMP_QUANTIDADE;
	
	@AndroidFindBy(id = "br.com.pztec.estoque:id/txt_valunit")
	public MobileElement CMP_VALOR_UNITARIO;
	
	@AndroidFindBy(id = "br.com.pztec.estoque:id/txt_lote")
	public MobileElement CMP_LOTE;

	@AndroidFindBy(id = "br.com.pztec.estoque:id/txt_descateg")
	public MobileElement CMP_GRUPO;

	@AndroidFindBy(id = "br.com.pztec.estoque:id/txt_validade")
	public MobileElement CMP_VALIDADE;

	@AndroidFindBy(id = "br.com.pztec.estoque:id/txt_qtdentrada")
	public MobileElement CMP_QNTD_ENTRADA;
	
	@AndroidFindBy(id = "br.com.pztec.estoque:id/txt_qtdsaida")
	public MobileElement CMP_QNTD_SAIDA;

	/**
	 * Lista de Componentes
	 */

	@AndroidFindBy(id = "br.com.pztec.estoque:id/linha_parte1")
	public MobileElement CARD_PRODUTO;

	@AndroidFindBy(id = "br.com.pztec.estoque:id/textView3")
	public MobileElement PAGE_TITLE;
}