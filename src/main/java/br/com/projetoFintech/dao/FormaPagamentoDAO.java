package br.com.projetoFintech.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetoFintech.connectionManager.ConnectionManagement;
import br.com.projetoFintech.model.FormaPagamentoModel;


public class FormaPagamentoDAO {

	private Connection conexao;
	
	public FormaPagamentoDAO() {
		this.conexao = ConnectionManagement.getInstance().getConnection();
		System.out.println("Conectou!");
	}
	
	public void insert(FormaPagamentoModel formaPgto, String user) throws SQLException {
		String sql = "INSERT INTO t_forma_pgto (id_formapgto, nm_nickformapgto, dt_datavencimentofatura, dt_aberturafatura, ds_tipoformapagamento) VALUES (SQ_t_forma_pgto.NEXTVAL,?,?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		//stmt.setString(1, formaPgto.getIdFormaPagamento());
		stmt.setString(1, formaPgto.getApelidoFormaPagamento());
		stmt.setString(2, formaPgto.getDataVencimentoFatura());
		stmt.setString(3, formaPgto.getDataAberturaFatura());
		stmt.setString(4, formaPgto.getTipoFormaPagmento());
		
		stmt.execute();
		stmt.close();
		
		
		String sql2 = "INSERT INTO t_user_fpgto VALUES(?,?)";
		PreparedStatement stmt2 = conexao.prepareStatement(sql);
		stmt2.setString(1, user);
		stmt2.setString(2, getLastVall());
		
		stmt2.execute();
		stmt2.close();
		
		
		
	}
	
	public String getLastVall() throws SQLException {
		System.out.println("entrei");
		String lastIdFormaPgto = null;
		String sql = "SELECT id_formapgto FROM t_forma_pgto WHERE id_formapgto = (SELECT MAX(id_formapgto) FROM t_forma_pgto)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			lastIdFormaPgto = rs.getString("id_formapgto");
			System.out.println(lastIdFormaPgto);			
		}
		stmt.close();
		rs.close();
		return lastIdFormaPgto;
		
	}
	
 	public List<FormaPagamentoModel> getAll() throws SQLException {
		List<FormaPagamentoModel> formasPgto = new ArrayList<FormaPagamentoModel>();
		String sql = "SELECT * FROM t_forma_pgto";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			FormaPagamentoModel formaPgto = new FormaPagamentoModel();
			formaPgto.setIdFormaPagamento(rs.getString("id_formapgto"));
			formaPgto.setApelidoFormaPagamento(rs.getString("nm_nickformapgto"));
			formaPgto.setDataVencimentoFatura(rs.getString("dt_datavencimentofatura"));
			formaPgto.setDataAberturaFatura(rs.getString("dt_aberturafatura"));
			formaPgto.setTipoFormaPagmento(rs.getString("ds_tipoformapagamento"));
			
			formasPgto.add(formaPgto);
		}
		stmt.close();
		rs.close();
		return formasPgto;
	}
	
	public FormaPagamentoModel selectFormaPagamentoById(String id) throws SQLException {
		FormaPagamentoModel formaPgto = null;
		String sql = "SELECT * FROM t_forma_pgto WHERE id_formapgto=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, id);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			formaPgto = new FormaPagamentoModel();
			formaPgto.setIdFormaPagamento(rs.getString("id_formapgto"));
			formaPgto.setApelidoFormaPagamento(rs.getString("nm_nickformapgto"));
			formaPgto.setDataVencimentoFatura(rs.getString("dt_datavencimentofatura"));
			formaPgto.setDataAberturaFatura(rs.getString("dt_aberturafatura"));
			formaPgto.setTipoFormaPagmento(rs.getString("ds_tipoformapagamento"));
		}
		stmt.close();
		rs.close();
		return formaPgto;
	}
	
	public void delete(String id) throws SQLException {
		String sql = "DELETE FROM t_forma_pgto WHERE id_formapgto=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, id);
		stmt.execute();
		stmt.close();
	}
	
	public void update(FormaPagamentoModel formaPgto) throws SQLException {
		String sql = "UPDATE t_forma_pgto SET nm_nickformapgto=?, dt_datavencimentofatura=?, dt_aberturafatura=?, ds_tipoformapagamento=? WHERE id_formapgto=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		
		stmt.setString(1, formaPgto.getApelidoFormaPagamento());
		stmt.setString(2, formaPgto.getDataVencimentoFatura());
		stmt.setString(3, formaPgto.getDataAberturaFatura());
		stmt.setString(4, formaPgto.getTipoFormaPagmento());
		stmt.setString(5, formaPgto.getIdFormaPagamento());
		
		stmt.execute();
		stmt.close();
	}
	
}
