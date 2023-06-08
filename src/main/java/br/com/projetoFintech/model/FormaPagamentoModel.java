package br.com.projetoFintech.model;

import java.io.Serializable;

public class FormaPagamentoModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	private String idFormaPagamento;

	private String apelidoFormaPagamento;
	private String tipoFormaPagmento;
	private String dataVencimentoFatura;
	private String dataAberturaFatura;

	public FormaPagamentoModel() {

	}

	public FormaPagamentoModel(String apelidoFormaPagamento, String tipoFormaPagmento,
			String dataVencimentoFatura, String dataAberturaFatura) {
		this.apelidoFormaPagamento = apelidoFormaPagamento;
		this.tipoFormaPagmento = tipoFormaPagmento;
		this.dataVencimentoFatura = dataVencimentoFatura;
		this.dataAberturaFatura = dataAberturaFatura;
	}

	public String getIdFormaPagamento() {
		return idFormaPagamento;
	}
	
	public void setIdFormaPagamento(String idFormaPagamento) {
		this.idFormaPagamento = idFormaPagamento;
	}
	
	public String getApelidoFormaPagamento() {
		return apelidoFormaPagamento;
	}

	public void setApelidoFormaPagamento(String apelidoFormaPagamento) {
		this.apelidoFormaPagamento = apelidoFormaPagamento;
	}

	public String getTipoFormaPagmento() {
		return tipoFormaPagmento;
	}

	public void setTipoFormaPagmento(String tipoFormaPagmento) {
		this.tipoFormaPagmento = tipoFormaPagmento;
	}

	public String getDataVencimentoFatura() {
		return dataVencimentoFatura;
	}

	public void setDataVencimentoFatura(String dataVencimentoFatura) {
		this.dataVencimentoFatura = dataVencimentoFatura;
	}

	public String getDataAberturaFatura() {
		return dataAberturaFatura;
	}

	public void setDataAberturaFatura(String dataAberturaFatura) {
		this.dataAberturaFatura = dataAberturaFatura;
	}

	@Override
	public String toString() {
		return "FormaPagamentoModel [idFormaPagamento=" + idFormaPagamento + ", apelidoFormaPagamento="
				+ apelidoFormaPagamento + ", tipoFormaPagmento=" + tipoFormaPagmento + ", dataVencimentoFatura="
				+ dataVencimentoFatura + ", dataAberturaFatura=" + dataAberturaFatura + "]";
	}

	

}
