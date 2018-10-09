package br.com.entidade;

import br.com.controle.ESTADO;

public class Caminhao {
	private int idCaminhao;
	private int tipoCaminhao;
	private ESTADO estado;
	private String tipoCarga;
	
	public int getIdCaminhao() {
		return idCaminhao;
	}

	public void setIdCaminhao(int idCaminhao) {
		this.idCaminhao = idCaminhao;
	}

	public int getTipoCaminhao() {
		return tipoCaminhao;
	}

	public void setTipoCaminhao(int i) {
		this.tipoCaminhao = i;
	}

	public ESTADO getEstado() {
		return estado;
	}
	public void setEstado(ESTADO estado) {
		this.estado = estado;
		
	}
	
	public String getTipoCarga() {
		return tipoCarga;
	}

	public void setTipoCarga(String tipoCarga) {
		this.tipoCarga = tipoCarga;
	}
	public Caminhao(Caminhao cam){
		System.out.println("\n\nID: "+cam.getIdCaminhao());
		System.out.println("TIPO DE CAMINH�O: "+cam.getTipoCaminhao());
		System.out.println("ESTADO: "+cam.getEstado());
		System.out.println("TIPO DE CARGA: "+cam.getTipoCarga());
	}

	public Caminhao() {
		// TODO Auto-generated constructor stub
	}
}