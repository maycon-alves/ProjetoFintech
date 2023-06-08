package br.com.projetoFintech.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetoFintech.connectionManager.ConnectionManagement;
import br.com.projetoFintech.model.Gasto;

public class GastoDAO {
	/*
	 * Esta classe não pode ser inserida sozinha na base de dados, pois tem uma
	 * dependencia direta das classes de gastoFixo e gastoMensal Nesse primeiro
	 * momento, será a implementação da classe GastoDAO será feita em consunto com
	 * as classes que a implementam. Sendo necessario um ajuste futuro.
	 */
	private Connection conexao;

	public GastoDAO() {
		this.conexao = ConnectionManagement.getInstance().getConnection();
		System.out.println("Conectou!");
	}

	public void insert(Gasto gasto) throws SQLException {
		String sql = "INSERT INTO t_gasto (id_gasto, vl_gasto, ds_gasto, dt_gasto, cd_tipogasto, id_categoriagasto, t_user_cd_cpf, t_forma_pgto_id_formapgto) VALUES(SQ_t_gasto.NEXTVAL,?,?,?,?,?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		String sql_gastoMensal = "INSERT INTO t_gasto_mensal (id_gastomensal, dt_datacompra, qt_quantidadeparcelas, ds_modalidadeformapgto, t_gasto_id_gasto, t_gasto_t_user_cd_cpf, t_gasto_id_formapgto) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement stmt_gastoMensal = conexao.prepareStatement(sql_gastoMensal);
		String sql_gastoFixo = "INSERT INTO t_gasto_fixo (id_gastofixo, dt_dialançamento, ds_periodogatofixo, t_gasto_id_gasto, t_gasto_t_user_cd_cpf, t_gasto_id_formapgto) VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt_gastoFixo = conexao.prepareStatement(sql_gastoFixo);
		try {
			String step = "[1]";
			System.out.println("Executando Step:" + step);
			//stmt.setString(1, gasto.getIdGasto());
			stmt.setDouble(1, gasto.getValorGasto());
			stmt.setString(2, gasto.getDescricaoGasto());
			stmt.setString(3, gasto.getDataGasto());
			stmt.setString(4, gasto.getTipoGasto());
			stmt.setString(5, gasto.getCategoriaGasto());
			stmt.setString(6, gasto.getCpfUsuario());
			stmt.setString(7, gasto.getIdFormaPgto());
			stmt.execute();
//			if (gasto instanceof GastoFixoModel) {
//				step = "[2]";
//				System.out.println("Executando Step:" + step);
//				stmt_gastoFixo.setString(1, ((GastoFixoModel) gasto).getIdGastoFixo());
//				stmt_gastoFixo.setString(2, ((GastoFixoModel) gasto).getDiaLancamento());
//				stmt_gastoFixo.setString(3, ((GastoFixoModel) gasto).getPeriodo());
//				stmt_gastoFixo.setString(4, gasto.getIdGasto());
//				stmt_gastoFixo.setString(5, gasto.getCpfUsuario());
//				stmt_gastoFixo.setString(6, gasto.getIdFormaPgto());
//				stmt_gastoFixo.execute();
//				stmt_gastoFixo.close();
//
//			} else {
//				step = "[3]";
//				System.out.println("Executando Step:" + step);
//				stmt_gastoMensal.setString(1, ((GastoMensalModel) gasto).getIdGastoMensal());
//				stmt_gastoMensal.setString(2, ((GastoMensalModel) gasto).getDataCompra());
//				stmt_gastoMensal.setString(3, ((GastoMensalModel) gasto).getQuantidadeParcela());
//				stmt_gastoMensal.setString(4, ((GastoMensalModel) gasto).getModalidade());
//				stmt_gastoMensal.setString(5, gasto.getIdGasto());
//				stmt_gastoMensal.setString(6, gasto.getCpfUsuario());
//				stmt_gastoMensal.setString(7, gasto.getIdFormaPgto());
//				stmt_gastoMensal.execute();
//				stmt_gastoMensal.close();
//			}

			stmt.close();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir os dados na base ...");
			stmt.close();
			stmt_gastoMensal.close();
			stmt_gastoFixo.close();
			throw new RuntimeException(e);
		}

	}

	public List<Gasto> getAll() throws SQLException {
		List<Gasto> gastos = new ArrayList<Gasto>();
		String sql = "SELECT * FROM t_gasto";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Gasto gasto = new Gasto() {
			};
			gasto.setIdGasto(rs.getString("id_gasto"));
			gasto.setValorGasto(rs.getDouble("vl_gasto"));
			gasto.setDescricaoGasto(rs.getString("ds_gasto"));
			gasto.setCategoriaGastoSQL(rs.getString("id_categoriagasto"));
			gastos.add(gasto);
		}
		stmt.close();
		rs.close();
		return gastos;
	}
	
	public List<Gasto> getAllbyId(String id) throws SQLException {
		List<Gasto> gastos = new ArrayList<Gasto>();
		System.out.println("entramos no get all");
		//String sql = "SELECT * FROM t_gasto WHERE t_user_cd_cpf = ?";
		String sql = "SELECT t_gasto.id_gasto, t_gasto.vl_gasto, t_gasto.ds_gasto, t_gasto.dt_gasto, t_gasto.id_categoriagasto, t_gasto.cd_tipogasto, t_gasto.t_forma_pgto_id_formapgto, t_forma_pgto.id_formapgto, t_forma_pgto.nm_nickformapgto  FROM t_gasto JOIN t_forma_pgto ON t_gasto.t_forma_pgto_id_formapgto = t_forma_pgto.id_formapgto WHERE t_gasto.t_user_cd_cpf = ?";		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, id);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			System.out.println("entramos no while");
			Gasto gasto = new Gasto() {
			};
			gasto.setIdGasto(rs.getString("id_gasto"));
			gasto.setValorGasto(rs.getDouble("vl_gasto"));
			gasto.setDescricaoGasto(rs.getString("ds_gasto"));
			gasto.setCategoriaGastoSQL(rs.getString("id_categoriagasto"));
			gasto.setTipoGasto(rs.getString("cd_tipogasto"));
			gasto.setDataGasto(rs.getString("dt_gasto"));
			gasto.setNickFormaPgto(rs.getString("nm_nickformapgto"));
			gastos.add(gasto);
			System.out.println("olha o gasto" + gasto);
		}
		stmt.close();
		rs.close();
		System.out.println(gastos);
		return gastos;
	}

	public Gasto selectGastoById(String id) throws SQLException {
		Gasto gasto = null;
		String sql = "SELECT * FROM t_gasto WHERE id_gasto=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, id);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			gasto = new Gasto() {
			};
			gasto.setIdGasto(rs.getString("id_gasto"));
			gasto.setValorGasto(rs.getDouble("vl_gasto"));
			gasto.setDescricaoGasto(rs.getString("ds_gasto"));
			gasto.setDataGasto(rs.getString("dt_gasto"));
			gasto.setTipoGasto(rs.getString("cd_tipogasto"));
			gasto.setCategoriaGastoSQL(rs.getString("id_categoriagasto"));
		}
		stmt.close();
		rs.close();
		return gasto;
	}

	public void delete(Gasto gasto) throws SQLException {
		String step = "[1]";
		System.out.println("Executando Step:" + step);

		String sql = "DELETE FROM t_gasto WHERE id_gasto=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);

		stmt.setString(1, gasto.getIdGasto());

		step = "[2]";
		System.out.println("Executando Step:" + step);
		String sql_gastoMensal = "DELETE FROM t_gasto_mensal WHERE t_gasto_id_gasto=?";
		PreparedStatement stmt_gastoMensal = conexao.prepareStatement(sql_gastoMensal);
		stmt_gastoMensal.setString(1, gasto.getIdGasto());
		stmt_gastoMensal.execute();
		stmt_gastoMensal.close();

		String sql_gastoFixo = "DELETE FROM t_gasto_fixo WHERE t_gasto_id_gasto=?";
		PreparedStatement stmt_gastoFixo = conexao.prepareStatement(sql_gastoFixo);
		stmt_gastoFixo.setString(1, gasto.getIdGasto());
		stmt_gastoFixo.execute();

		stmt.execute();
		stmt.close();
	}

	public void Update(Gasto gasto) throws SQLException {
		String sql = "UPDATE t_gasto SET vl_gasto=?, ds_gasto=?, dt_gasto=?, cd_tipogasto=?, id_categoriagasto=?, t_user_cd_cpf=?, t_forma_pgto_id_formapgto=? WHERE id_gasto=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		String sql_gastoMensal = "UPDATE t_gasto_mensal SET dt_datacompra=?, qt_quantidadeparcelas=?, ds_modalidadeformapgto=?, t_gasto_id_gasto=?, t_gasto_t_user_cd_cpf=?, t_gasto_id_formapgto=? WHERE id_gastomensal=?";
		PreparedStatement stmt_gastoMensal = conexao.prepareStatement(sql_gastoMensal);
		String sql_gastoFixo = "UPDATE t_gasto_fixo SET dt_dialançamento=?, ds_periodogatofixo=?, t_gasto_id_gasto=?, t_gasto_t_user_cd_cpf=?, t_gasto_id_formapgto=? WHERE id_gastofixo=?";
		PreparedStatement stmt_gastoFixo = conexao.prepareStatement(sql_gastoFixo);
		try {
			String step = "[1]";
			System.out.println("Executando Step:" + step);
			stmt.setDouble(1, gasto.getValorGasto());
			stmt.setString(2, gasto.getDescricaoGasto());
			stmt.setString(3, gasto.getDataGasto());
			stmt.setString(4, gasto.getTipoGasto());
			stmt.setString(5, gasto.getCategoriaGasto());
			stmt.setString(6, gasto.getCpfUsuario());
			stmt.setString(7, gasto.getIdFormaPgto());
			stmt.setString(8, gasto.getIdGasto());
			stmt.execute();
//			if (gasto instanceof GastoFixoModel) {
//				step = "[2]";
//				System.out.println("Executando Step:" + step);
//				stmt_gastoFixo.setString(1, ((GastoFixoModel) gasto).getDiaLancamento());
//				stmt_gastoFixo.setString(2, ((GastoFixoModel) gasto).getPeriodo());
//				stmt_gastoFixo.setString(3, gasto.getIdGasto());
//				stmt_gastoFixo.setString(4, gasto.getCpfUsuario());
//				stmt_gastoFixo.setString(5, gasto.getIdFormaPgto());
//				stmt_gastoFixo.setString(6, ((GastoFixoModel) gasto).getIdGastoFixo());
//				stmt_gastoFixo.execute();
//				stmt_gastoFixo.close();
//
//			} else {
//				step = "[3]";
//				System.out.println("Executando Step:" + step);
//				stmt_gastoMensal.setString(1, ((GastoMensalModel) gasto).getDataCompra());
//				stmt_gastoMensal.setString(2, ((GastoMensalModel) gasto).getQuantidadeParcela());
//				stmt_gastoMensal.setString(3, ((GastoMensalModel) gasto).getModalidade());
//				stmt_gastoMensal.setString(4, gasto.getIdGasto());
//				stmt_gastoMensal.setString(5, gasto.getCpfUsuario());
//				stmt_gastoMensal.setString(6, gasto.getIdFormaPgto());
//				stmt_gastoMensal.setString(7, ((GastoMensalModel) gasto).getIdGastoMensal());
//				stmt_gastoMensal.execute();
//				stmt_gastoMensal.close();
//			}

			stmt.close();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir os dados na base ...");
			stmt.close();
			stmt_gastoMensal.close();
			stmt_gastoFixo.close();
			throw new RuntimeException(e);
		}
	}

}