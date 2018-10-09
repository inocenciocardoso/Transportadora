package br.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.controle.ESTADO;
import br.com.entidade.Caminhao;
import br.com.jdbc.Persistencia;

public class CaminhaoDAO {
	Persistencia persistencia = new Persistencia();
	private final String INSERT = "INSERT INTO CAMINHAO (TIPO_CAMINHAO,TIPO_CARGA,ESTADO_CAMINHAO) VALUES(?,?,?);";
	private final String SELECT = "SELECT * FROM CAMINHAO";
	
	public void insert(Caminhao caminhao){
		
		PreparedStatement pstm = null;
		try {
			pstm = persistencia.getConection().prepareStatement(INSERT);
			
//			pstm.setInt(1, caminhao.getIdCaminhao());
			pstm.setInt(1, caminhao.getTipoCaminhao());
			pstm.setString(2, caminhao.getTipoCarga());
			pstm.setObject(3, caminhao.getEstado().name());
//			pstm.setDate(6,(java.sql.Date) caminhao.getEntrada());
	//		pstm.setInt(7, caminhao.getQuantidade());
			pstm.execute();
			
			JOptionPane.showMessageDialog(null,"Caminh�o cadastrado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			persistencia.fecharConexao();
		}	
	}
	
	public ArrayList<Caminhao> getList(){
		ArrayList<Caminhao> camlist = new ArrayList<>();
		PreparedStatement pstm      = null;
		ResultSet rs                = null;
		try {
			pstm = persistencia.getConection().prepareStatement(SELECT);
			rs = pstm.executeQuery();
			while(rs.next()){
				Caminhao cam = new Caminhao();
				cam.setIdCaminhao(rs.getInt("ID"));
				cam.setTipoCaminhao(rs.getInt("TIPO_CAMINHAO"));
				cam.setTipoCarga(rs.getString("TIPO_CARGA"));
				cam.setEstado(ESTADO.valueOf(rs.getString("ESTADO_CAMINHAO")));
				
				camlist.add(cam);
				new Caminhao(cam);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			persistencia.fecharConexao();
		}
		return camlist;
	}
	
	public static void main(String[] args) {
		Caminhao cam = new Caminhao();
		
		cam.setTipoCaminhao(1);
		cam.setTipoCarga("PERECIVEL");
		cam.setEstado(ESTADO.PARADO);
		new CaminhaoDAO().insert(cam);
		new CaminhaoDAO().getList();
	}
}
