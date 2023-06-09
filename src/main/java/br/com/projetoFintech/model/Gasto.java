package br.com.projetoFintech.model;

import br.com.projetoFintech.Enums.CategoriaGastoEnum;

//import java.io.Serializable;


public abstract class Gasto{

	/**
	 * 
	 */
	//private static final long serialVersionUID = 7L;
	private String idGasto;
	private Double valorGasto;
	private String descricaoGasto;
	private String dataGasto;
	private String tipoGasto; //[Fixo, Mensal]
	private CategoriaGastoEnum categoriaGasto;
	private Usuario usuario;
	private FormaPagamentoModel formaPgto;
	private String nickFormaPgto;
	
	

	public Gasto() {
		
	}

	public Gasto(String idGasto, Double valorGasto, String descricaoGasto, CategoriaGastoEnum categoriaGasto, Usuario usuario, FormaPagamentoModel formaPgto, String nickFormaPgto) {
		this.idGasto = idGasto;
		this.valorGasto = valorGasto;
		this.descricaoGasto = descricaoGasto;
		this.categoriaGasto = categoriaGasto;
		this.usuario = usuario;
		this.formaPgto = formaPgto;
		this.nickFormaPgto = nickFormaPgto;
	}
	
	public String getDataGasto() {
		return dataGasto;
	}

	public void setDataGasto(String dataGasto) {
		this.dataGasto = dataGasto;
	}

	public String getTipoGasto() {
		return tipoGasto;
	}
	
	public void setTipoGasto(String tipoGasto) {
		this.tipoGasto = tipoGasto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String getCpfUsuario() {
		return usuario.getCpf();
	}	
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public FormaPagamentoModel getFormaPgto() {
		return formaPgto;
	}
	
	public String getIdFormaPgto() {
		return formaPgto.getIdFormaPagamento();
	}

	public void setFormaPgto(FormaPagamentoModel formaPgto) {
		this.formaPgto = formaPgto;
	}

	public String getIdGasto() {
		return idGasto;
	}

	public void setIdGasto(String idGasto) {
		this.idGasto = idGasto;
	}

	public Double getValorGasto() {
		return valorGasto;
	}

	public void setValorGasto(Double valorGasto) {
		this.valorGasto = valorGasto;
	}

	public String getDescricaoGasto() {
		return descricaoGasto;
	}

	public void setDescricaoGasto(String descricaoGasto) {
		this.descricaoGasto = descricaoGasto;
	}

//	public CategoriaGastoEnum getCategoriaGasto() {
//		return categoriaGasto;
//	}

	public String getCategoriaGasto() {
		return categoriaGasto.getDescricaoCategoriaGasto();
	}
	
	public void setCategoriaGasto(CategoriaGastoEnum categoriaGasto) {
		this.categoriaGasto = categoriaGasto;
	}
	
	public String getNickFormaPgto() {
		return nickFormaPgto;
	}
	
	public void setNickFormaPgto(String nickFormaPgto) {
		this.nickFormaPgto = nickFormaPgto;
	}
	
	public void setCategoriaGastoSQL(String categoriaGasto) {
		switch (categoriaGasto) {
		case "Alimentação", "ALIMENTACAO": {			
			this.categoriaGasto = CategoriaGastoEnum.ALIMENTACAO;
			break;
		}
		case "Saúde", "Saude", "SAUDE": {			
			this.categoriaGasto = CategoriaGastoEnum.ALIMENTACAO;
			break;
		}
		case "Lazer", "LAZER": {			
			this.categoriaGasto = CategoriaGastoEnum.ALIMENTACAO;
			break;
		}
		case "Impulso", "IMPULSO": {			
			this.categoriaGasto = CategoriaGastoEnum.ALIMENTACAO;
			break;
		}
		case "Despesa_Fixa", "DESPESA_FIXA", "Despesa Fixa": {			
			this.categoriaGasto = CategoriaGastoEnum.ALIMENTACAO;
			break;
		}
		case "Imprevisto", "IMPREVISTO": {			
			this.categoriaGasto = CategoriaGastoEnum.ALIMENTACAO;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + categoriaGasto);
		}
		
		
	}
	
	@Override
	public String toString() {
		return "idGasto=" + idGasto + ", valorGasto=" + valorGasto + ", descricaoGasto=" + descricaoGasto
				+ ", categoriaGasto=" + categoriaGasto;
	}

}