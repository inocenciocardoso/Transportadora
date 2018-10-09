package br.com.entidade;

import java.sql.Date;

public class VIAGEMVOLTA {
	private int idVolta;
	private int idCaminhao;
	private double qtdLitro;
	private double custoComb;
	private int tempoVolta;
	private String cidadeVolta;
	private Date dataVolta;

	public int getIdVolta() {
		return idVolta;
	}

	public void setIdVolta(int idVolta) {
		this.idVolta = idVolta;
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

	public int getTempoVolta() {
		return tempoVolta;
	}

	public void setTempoVolta(int tempoVolta) {
		this.tempoVolta = tempoVolta;
	}

	public String getCidadeVolta() {
		return cidadeVolta;
	}

	public void setCidadeVolta(String cidadeVolta) {
		this.cidadeVolta = cidadeVolta;
	}

	public Date getData() {
		return dataVolta;
	}

	public void setData(Date data) {
		this.dataVolta = data;
	}
	public VIAGEMVOLTA(VIAGEMVOLTA cam) {
		System.out.println("\n\nID: "+cam.getIdVolta());
		System.out.println("ID CAMINH�O"+cam.getIdCaminhao());
		System.out.println("QTD LITROS: "+cam.getQtdLitro());
		System.out.println("CUSTO: "+cam.getCustoComb());
		System.out.println("TEMPO VOLTA: "+cam.getTempoVolta());
		System.out.println("CIDADE VOLTA: "+cam.getCidadeVolta());
		System.out.println("DATA VOLTA: "+cam.getData()+"\n");
	}
	public VIAGEMVOLTA(){	
	}
}
