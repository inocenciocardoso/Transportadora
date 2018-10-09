package br.com.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.entidade.VIAGEMVOLTA;
import br.com.jdbc.Persistencia;

public class ViagemVoltaDAO {
	Persistencia persistencia = new Persistencia();
	private String INSERT = "INSERT INTO VIAGEM_VOLTA(ID_CAMINHAO,QTD_COMBUSTIVEL,CUSTO_COMBUSTIVEL,TEMPO_VIAGEM,CIDADE_VOLTA,DATA_VOLTA) VALUES(?,?,?,?,?,?);";
	private final String SELECT = "SELECT * FROM VIAGEM_VOLTA";
	
	public void insert(VIAGEMVOLTA volta){
		
		PreparedStatement pstm = null;
		try {
			pstm = persistencia.getConection().prepareStatement(INSERT);
			
			pstm.setInt(1, volta.getIdCaminhao());
			pstm.setDouble(2, volta.getQtdLitro());
			pstm.setDouble(3, volta.getCustoComb());
			pstm.setInt(4, volta.getTempoVolta());
			pstm.setString(5, volta.getCidadeVolta());
			pstm.setDate(6,(java.sql.Date) volta.getData());
			pstm.execute();
			
			JOptionPane.showMessageDialog(null,"Viagem de volta cadastrada!");
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			persistencia.fecharConexao();
		}	
	}
	
	public ArrayList<VIAGEMVOLTA> getList(){
		ArrayList<VIAGEMVOLTA> camlist = new ArrayList<>();
		PreparedStatement pstm      = null;
		ResultSet rs                = null;
		try {
			pstm = persistencia.getConection().prepareStatement(SELECT);
			rs = pstm.executeQuery();
			while(rs.next()){
				VIAGEMVOLTA cam = new VIAGEMVOLTA();
				cam.setIdVolta(rs.getInt("ID"));
				cam.setIdCaminhao(rs.getInt("ID_CAMINHAO"));
				cam.setQtdLitro((Double) rs.getDouble("QTD_COMBUSTIVEL"));
				cam.setCustoComb(rs.getDouble("CUSTO_COMBUSTIVEL"));
				cam.setTempoVolta(rs.getInt("TEMPO_VIAGEM"));
				cam.setCidadeVolta("CIDADE_VOLTA");
				cam.setData(rs.getDate("DATA_VOLTA"));
				camlist.add(cam);
				new VIAGEMVOLTA(cam);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			persistencia.fecharConexao();
		}
		return camlist;
	}
	
	public static void main(String[] args) {
		VIAGEMVOLTA cam = new VIAGEMVOLTA();
		cam.setIdCaminhao(2);
		cam.setQtdLitro(3.4);
		cam.setCustoComb(45.91);
		cam.setTempoVolta(2);
		cam.setData(Date.valueOf("2017-02-22"));
		new ViagemVoltaDAO().insert(cam);
		new ViagemVoltaDAO().getList();
	} 
}
