package br.com.entidade;

public class TIPOCAMINHAO {
	private int id;
	private String descricao;
	private double pesoMax;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPesoMax() {
		return pesoMax;
	}
	public void setPesoMax(double pesoMax) {
		this.pesoMax = pesoMax;
	}
	
	public TIPOCAMINHAO(TIPOCAMINHAO tc){
		System.out.println("\n\nID: "+tc.getId());
		System.out.println("DESCRI��O: "+tc.getDescricao());
		System.out.println("PESO SUPORTADO: "+tc.getPesoMax());
	}
	public TIPOCAMINHAO(){
	}
}
