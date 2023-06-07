package br.com.projetoFintech.model;

import java.io.Serializable;

import br.com.projetoFintech.Enums.TipoFaturamentoEnum;
import br.com.projetoFintech.Enums.TipoPerfilInvestidorEnum;


public class Usuario extends Pessoa implements Serializable {
	/**
	 * esta classe e um javabean
	 */
	private static final long serialVersionUID = 2L;
	/**
	 * string de conhecimento do usuario utilizada para autenticacao no momento de
	 * login
	 */
	private String senha;
	/**
	 * string personalizavel pelo usuario utilizada para relacionamento com o
	 * usuario
	 */
	private String apelidoUsuario;
	/**
	 * sinaliza a experiencia do usuario com investimentos ENUM:[conservador;
	 * moderado; experiente;]
	 */
	private TipoPerfilInvestidorEnum tipoPerfilInvestidor;
	/**
	 * sinaliza a frequencia do faturamento do usuario
	 * ENUM:[fixoSemanal;fixoMensal;fixoAnual;variavel;misto;]
	 */
	private TipoFaturamentoEnum tipoFaturamento;

	public Usuario() {

	}

	public Usuario(String cpf, String nome, String senha, String apelidoUsuario,
			TipoPerfilInvestidorEnum tipoPerfilInvestidor, TipoFaturamentoEnum tipoFaturamento
			) {
		super(cpf, nome);
		this.senha = senha;
		this.apelidoUsuario = apelidoUsuario;
		this.tipoPerfilInvestidor = tipoPerfilInvestidor;
		this.tipoFaturamento = tipoFaturamento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getApelidoUsuario() {
		return apelidoUsuario;
	}

	public void setApelidoUsuario(String apelidoUsuario) {
		this.apelidoUsuario = apelidoUsuario;
	}

	public String getTipoPerfilInvestidor() {
		return tipoPerfilInvestidor.getDescricaoPerfil();
	}

	public void setTipoPerfilInvestidor(TipoPerfilInvestidorEnum tipoPerfilInvestidor) {
		this.tipoPerfilInvestidor = tipoPerfilInvestidor;
	}

	public String getTipoFaturamento() {
		return tipoFaturamento.getDescricaoFaturamento();
	}

	public void setTipoFaturamento(TipoFaturamentoEnum tipoFaturamento) {
		this.tipoFaturamento = tipoFaturamento;
	}

	public void setTipoFaturamento(String faturamento) {
		switch (faturamento) {
		case "Fixo Semanal", "Fixo_Semanal", "FIXO_SEMANAL": {
			this.tipoFaturamento = TipoFaturamentoEnum.FIXO_SEMANAL;
			break;
		}
		case "Fixo Mensal", "Fixo_Mensal", "FIXO_MENSAL": {
			this.tipoFaturamento = TipoFaturamentoEnum.FIXO_MENSAL;
			break;
		}
		case "Fixo Anual", "Fixo_Anual", "FIXO_ANUAL": {
			this.tipoFaturamento = TipoFaturamentoEnum.FIXO_ANUAL;
			break;
		}
		case "Variavel", "VARIAVEL": {
			this.tipoFaturamento = TipoFaturamentoEnum.VARIAVEL;
			break;
		}
		case "Misto", "MISTO": {
			this.tipoFaturamento = TipoFaturamentoEnum.MISTO;
			break;
		}
		case "Nao Informado", "Nao_Informado", "NAO_INFORMADO": {
			this.tipoFaturamento = TipoFaturamentoEnum.NAO_INFORMADO;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + faturamento);
		}
	}

	@Override
	public String toString() {
		return "Usuario [senha=" + senha + ", apelidoUsuario=" + apelidoUsuario + ", tipoPerfilInvestidor="
				+ tipoPerfilInvestidor + ", tipoFaturamento=" + tipoFaturamento + ", " + super.toString() + "]";
	}

	public void setTipoPerfilInvestidor(String perfil) {

		switch (perfil) {
		case "Conservador", "CONSERVADOR": {

			this.tipoPerfilInvestidor = TipoPerfilInvestidorEnum.CONSERVADOR;
			break;
		}
		case "Moderado", "MODERADO": {

			this.tipoPerfilInvestidor = TipoPerfilInvestidorEnum.MODERADO;
			break;
		}
		case "Experiente", "EXPERIENTE": {

			this.tipoPerfilInvestidor = TipoPerfilInvestidorEnum.EXPERIENTE;
			break;
		}
		case "Nao_Informado", "NAO_INFORMADO": {

			this.tipoPerfilInvestidor = TipoPerfilInvestidorEnum.NAO_INFORMADO;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + tipoPerfilInvestidor);
		}

	}

}
