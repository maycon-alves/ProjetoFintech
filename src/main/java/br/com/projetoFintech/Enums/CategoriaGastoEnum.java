package br.com.projetoFintech.Enums;

/**
 * classe responsavel por armazenar os possiveis valores para o atributo
 * categoriaGasto
 * 
 * @author Equipe RocketMoney | Maycon Alves
 *
 */
public enum CategoriaGastoEnum {
	ALIMENTACAO("Alimentação"), SAUDE("Saude"), LAZER("Lazer"), IMPULSO("Impulso"), DESPESA_FIXA("Despesa_Fixa"),
	IMPREVISTO("Imprevisto");

	private String descricaoCategoriaGasto;

	/**
	 * Metodo responsavel por inserir a descricao de um determinado valor do Enum
	 * 
	 * @param descricaoFaturamento
	 */
	CategoriaGastoEnum(String descricaoCategoriaGasto) {
		this.descricaoCategoriaGasto = descricaoCategoriaGasto;
	}

	/**
	 * Metodo responsavel por retornar a descricao de um Enum a partir da sua chave
	 * 
	 * @return string
	 */
	public String getDescricaoCategoriaGasto() {
		return descricaoCategoriaGasto;
	}
}