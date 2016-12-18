package br.superdia.se.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IgSuperDia extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public IgSuperDia() {
		setTitle("Super Dia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 45, 647, 386);
		contentPane.add(tabbedPane);
		
		JPanel produtoPanel = new JPanel();
		tabbedPane.addTab("Produto", null, produtoPanel, null);
		produtoPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(12, 145, 105, 32);
		produtoPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new IgCadastrarProduto();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(IgSuperDia.class.getResource("/br/superdia/se/imagem/addProduct.png")));
		btnNewButton_1.setBounds(12, 23, 98, 84);
		produtoPanel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		setVisible(true);
	}
}
