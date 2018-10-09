package br.com.gui.panel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import br.com.gui.JListCaminhao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPanelBotoes extends javax.swing.JPanel{

	private static final long serialVersionUID = 1L;
	JButton btnInsert;
	
	public JPanelBotoes() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "PAINEL DE BOTOES", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 139)));
		this.setSize(720, 130);
		setLayout(null);
		
		btnInsert = new JButton("CRIAR CAMINHAO");
		btnInsert.setBackground(new Color(192, 192, 192));
		btnInsert.setFont(new Font("Arial", Font.PLAIN, 12));
		btnInsert.setBounds(560, 20, 150, 25);
		btnInsert.setBorder(null);
		//btnInsert.addMouseListener(new EventosAllBotton());
		add(btnInsert);
		
		JButton btnClear = new JButton("LIMPAR OS CAMPOS");
		btnClear.setBackground(new Color(192, 192, 192));
		btnClear.setBorder(null);
		btnClear.setBounds(400, 21, 150, 25);
		add(btnClear);
		
		JButton btnListView = new JButton("VISUALIZAR LISTA DE CADASTRADOS");
		btnListView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JListCaminhao().isVisible();
			}
		});
		btnListView.setBackground(new Color(192, 192, 192));
		btnListView.setBounds(10, 21, 300, 25);
		btnListView.setBorder(null);
		add(btnListView);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBackground(new Color(192, 192, 192));
		btnDelete.setBorder(null);
		btnDelete.setBounds(400, 60, 150, 25);
		add(btnDelete);
		
		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.setBackground(new Color(192, 192, 192));
		btnAtualizar.setBorder(null);
		btnAtualizar.setBounds(560, 60, 150, 25);
		add(btnAtualizar);
		
		this.setVisible(true);
	}
	
	public static void main(String [] args){
		JFrame f = new JFrame();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(740, 90);
		f.getContentPane().add(new JPanelBotoes());
		
		
	}
	
}
