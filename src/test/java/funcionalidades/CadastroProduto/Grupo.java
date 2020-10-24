package funcionalidades.CadastroProduto;

public enum Grupo {
	
	GERAL("Geral");
	
	private String value;
	
	private Grupo(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
