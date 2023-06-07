package br.com.projetoFintech.Enums;

public enum TipoFaturamentoEnum {
	FIXO_SEMANAL("Fixo_Semanal"), FIXO_MENSAL("Fixo_Mensal"), FIXO_ANUAL("Fixo_Anual"), VARIAVEL("Variavel"),
	MISTO("Misto"), NAO_INFORMADO("Nao_Informado");

	private String descricaoFaturamento;

	/**
	 * Metodo responsavel por inserir a descricao de um determinado valor do Enum
	 * 
	 * @param descricaoFaturamento
	 */
	private TipoFaturamentoEnum(String descricaoFaturamento) {
		this.descricaoFaturamento = descricaoFaturamento;
	}

	/**
	 * Metodo responsavel por retornar a descricao de um Enum a partir da sua chave
	 * 
	 * @return string
	 */
	public String getDescricaoFaturamento() {
		return descricaoFaturamento;
	}
}