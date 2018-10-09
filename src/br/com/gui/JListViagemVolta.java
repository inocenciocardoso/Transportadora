package br.com.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.com.ModelTable.TabelaViagemVolta;
import br.com.dao.ViagemVoltaDAO;

public class JListViagemVolta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painelFundo;
	private JPanel painelBotoes;
	private static JTable tabela;
	private JScrollPane barraRolagem;
	private JButton btInserir;
	private JButton btExcluir;
	private JButton btEditar;
	
	private TabelaViagemVolta modelo;
	static List<br.com.entidade.VIAGEMVOLTA> lista;
	

	public JListViagemVolta() {
		super("TABELA DE CAMINH�ES");
		criaJTable();
		criaJanela();
	}
	
	public void criaJanela() {
		btInserir = new JButton("Inserir");
		btExcluir = new JButton("Excluir");
		btEditar = new JButton("Editar");
		
		painelBotoes = new JPanel();
		barraRolagem = new JScrollPane(tabela);
		painelFundo = new JPanel();
		painelFundo.setLayout(new BorderLayout());
		painelFundo.add(BorderLayout.CENTER, barraRolagem);
		painelBotoes.add(btInserir);
		painelBotoes.add(btEditar);
		painelBotoes.add(btExcluir);
		painelFundo.add(BorderLayout.SOUTH, painelBotoes);
		getContentPane().add(painelFundo);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(543, 375);
		setVisible(true);
		btInserir.addActionListener(new BtInserirListener());
		btEditar.addActionListener(new BtEditarListener());
		btExcluir.addActionListener(new BtExcluirListener());
	}
	private void criaJTable() {
		tabela = new JTable(modelo);
		pesquisar();
	}
	public void pesquisar() {
		ViagemVoltaDAO vv = new ViagemVoltaDAO();
		lista = vv.getList();
		modelo = new TabelaViagemVolta(lista);
		tabela.setModel(modelo);
	}
	private class BtInserirListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
		}
	}

	private class BtEditarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
		}
	}

	private class BtExcluirListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
		}
	}

	public static void main(String[] args) {
		try {
			JListViagemVolta frame = new JListViagemVolta();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
