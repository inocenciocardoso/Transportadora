package br.com.aplication;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import br.com.gui.JFrameCadastro;
import br.com.gui.JFrameViagem;

public class Transportadora {
	
	protected JFrame frmTransporte;
		

	public Transportadora() {
		// TODO Auto-generated constructor stub

		this.frmTransporte = new JFrame();
		this.frmTransporte.setTitle("Sistema de Gerenciamento de Cadastro e Custos para Transportes.");
		this.frmTransporte.setSize(800, 500);
		this.frmTransporte.setIconImage(getImage());
		this.frmTransporte.setLocationRelativeTo(null);
		this.frmTransporte.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createMenuComponent();
		this.frmTransporte.setVisible(true);
	}
		
	public Image getImage(){
		URL url  = this.getClass().getResource("../imagem/transporte.png"); 
		Image icone = Toolkit.getDefaultToolkit().getImage(url);
		return icone;
	}
		
	public void createMenuComponent(){
		JMenuBar mnbMenuBar = new JMenuBar();
		mnbMenuBar.setBackground(Color.CYAN);
		this.frmTransporte.setJMenuBar(mnbMenuBar);
		
		JMenu mnNewMenu = new JMenu("Cadastros");
		mnbMenuBar.add(mnNewMenu);
		
		JMenuItem mntmCadastroCaminhao = new JMenuItem("Cadastro Caminhao");
		mntmCadastroCaminhao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			new JFrameCadastro().isVisible();
			}
		});
		mnNewMenu.add(mntmCadastroCaminhao);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastro de Viagens");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JFrameViagem().isVisible();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
	}
}
