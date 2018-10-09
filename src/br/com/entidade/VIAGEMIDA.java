package br.com.entidade;

import java.sql.Date;

public class VIAGEMIDA {
	private int idIda;
	private int idCaminhao;
	private double qtdLitro;
	private double custoComb;
	private int tempoIda;
	private String cidadeIda;
	private Date dataIda;

	public int getIdIda() {
		return idIda;
	}

	public void setIdIda(int idIda) {
		this.idIda = idIda;
	}

	public int getIdCaminhao() {
		return idCaminhao;
	}

	public void setIdCaminhao(int idCaminhao) {
		this.idCaminhao = idCaminhao;
	}

	public double getQtdLitro() {
		return qtdLitro;
	}

	public void setQtdLitro(double qtdLitro) {
		this.qtdLitro = qtdLitro;
	}

	public double getCustoComb() {
		return custoComb;
	}

	public void setCustoComb(double custoComb) {
		this.custoComb = custoComb;
	}

	public int getTempoIda() {
		return tempoIda;
	}

	public void setTempoIda(int tempoIda) {
		this.tempoIda = tempoIda;
	}

	public String getCidadeIda() {
		return cidadeIda;
	}

	public void setCidadeIda(String cidadeIda) {
		this.cidadeIda = cidadeIda;
	}

	public Date getData() {
		return dataIda;
	}

	public void setData(Date data) {
		this.dataIda = data;
	}
	public VIAGEMIDA(VIAGEMIDA cam){
		System.out.println("\n\nID: "+cam.getIdIda());
		System.out.println("ID CAMINH�O"+cam.getIdCaminhao());
		System.out.println("QTD LITROS: "+cam.getQtdLitro());
		System.out.println("CUSTO: "+cam.getCustoComb());
		System.out.println("TEMPO IDA: "+cam.getTempoIda());
		System.out.println("CIDADE IDA: "+cam.getCidadeIda());
		System.out.println("DATA IDA: "+cam.getData()+"\n");
	}

	public VIAGEMIDA() {
		// TODO Auto-generated constructor stub
	}
}
