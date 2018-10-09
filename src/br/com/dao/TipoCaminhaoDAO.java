package br.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.entidade.TIPOCAMINHAO;
import br.com.jdbc.Persistencia;

public class TipoCaminhaoDAO {
	
	Persistencia persistencia = new Persistencia();
	private final String INSERT = "INSERT INTO TIPO_CAMINHAO(DESCRICAO,PESO_MAXIMO_SUPORTADO) VALUES (?,?);";
	private final String SELECT = "SELECT * FROM TIPO_CAMINHAO;";
	private final String SELECTTIPO = "SELECT DESCRICAO FROM TIPO_CAMINHAO";
	
	public void insert(TIPOCAMINHAO tipoCaminhao){
		PreparedStatement pstm = null;
		try {
			pstm = persistencia.getConection().prepareStatement(INSERT);
			pstm.setString(1,tipoCaminhao.getDescricao());
			pstm.setDouble(2, tipoCaminhao.getPesoMax());
			pstm.execute();
			
			JOptionPane.showMessageDialog(null,"Tipo de Caminh�o cadastrado!");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	public ArrayList<TIPOCAMINHAO> getList(){
		ArrayList<TIPOCAMINHAO> tipolist = new ArrayList<>();
		PreparedStatement pstm      = null;
		ResultSet rs                = null;
		try {
			pstm = persistencia.getConection().prepareStatement(SELECT);
			rs = pstm.executeQuery();
			while(rs.next()){
				TIPOCAMINHAO cam = new TIPOCAMINHAO();
				cam.setId(rs.getInt("ID"));
				cam.setDescricao(rs.getString("DESCRICAO"));
				cam.setPesoMax(rs.getDouble("PESO_MAXIMO_SUPORTADO"));
				
				tipolist.add(cam);
				new TIPOCAMINHAO(cam);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return tipolist;
	}
	public static void main(String[] args) {
		TIPOCAMINHAO tc = new TIPOCAMINHAO();
		
		tc.setDescricao("TOCO");
		tc.setPesoMax(230);
		new TipoCaminhaoDAO().insert(tc);
		new TipoCaminhaoDAO().getList();
	}
}
