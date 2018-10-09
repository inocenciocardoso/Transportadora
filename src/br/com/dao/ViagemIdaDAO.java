package br.com.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.entidade.VIAGEMIDA;
import br.com.jdbc.Persistencia;

public class ViagemIdaDAO {
	Persistencia persistencia = new Persistencia();
	private String INSERT = "INSERT INTO VIAGEM_IDA(ID_CAMINHAO,QTD_COMBUSTIVEL,CUSTO_COMBUSTIVEL,TEMPO_VIAGEM,CIDADE_IDA,DATA_IDA) VALUES(?,?,?,?,?,?)";
	private final String SELECT = "SELECT * FROM VIAGEM_IDA";
	
	public void insert(VIAGEMIDA ida){
		
		PreparedStatement pstm = null;
		try {
			pstm = persistencia.getConection().prepareStatement(INSERT);
			
			pstm.setInt(1, ida.getIdCaminhao());
			pstm.setDouble(2, ida.getQtdLitro());
			pstm.setDouble(3, ida.getCustoComb());
			pstm.setInt(4, ida.getTempoIda());
			pstm.setString(5, ida.getCidadeIda());
			pstm.setDate(6,(java.sql.Date) ida.getData());
			pstm.execute();
			
			JOptionPane.showMessageDialog(null,"Saida de caminh�o cadastrada!");
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			persistencia.fecharConexao();
		}	
	}
	
	public ArrayList<VIAGEMIDA> getList(){
		ArrayList<VIAGEMIDA> camlist = new ArrayList<>();
		PreparedStatement pstm      = null;
		ResultSet rs                = null;
		try {
			pstm = persistencia.getConection().prepareStatement(SELECT);
			rs = pstm.executeQuery();
			while(rs.next()){
				VIAGEMIDA cam = new VIAGEMIDA();
				cam.setIdIda(rs.getInt("ID"));
				cam.setIdCaminhao(rs.getInt("ID_CAMINHAO"));
				cam.setQtdLitro((Double) rs.getDouble("QTD_COMBUSTIVEL"));
				cam.setCustoComb(rs.getDouble("CUSTO_COMBUSTIVEL"));
				cam.setTempoIda(rs.getInt("TEMPO_VIAGEM"));
				cam.setCidadeIda("CIDADE_IDA");
				cam.setData(rs.getDate("DATA_IDA"));
				camlist.add(cam);
				new VIAGEMIDA(cam);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			persistencia.fecharConexao();
		}
		return camlist;
	}
	
	public static void main(String[] args) {
		VIAGEMIDA cam = new VIAGEMIDA();
		cam.setIdCaminhao(2);
		cam.setQtdLitro(3.4);
		cam.setCustoComb(45.91);
		cam.setTempoIda(1);
		cam.setCidadeIda("HORTOL�NDIA");
		cam.setData(Date.valueOf("2017-02-22"));
		new ViagemIdaDAO().insert(cam);
		new ViagemIdaDAO().getList();
	}
}
