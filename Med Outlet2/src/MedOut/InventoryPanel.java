package MedOut;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InventoryPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public InventoryPanel() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setPreferredSize(new Dimension(80,80));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("PACKAGES");
		lblNewLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/MedOut/6639703_preview.png")).getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH)));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		panel.add(lblNewLabel,BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(500,40));
		panel_1.setBackground(Color.PINK);
		panel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Add");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 102, 40);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(Color.PINK);
		lblNewLabel_1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/MedOut/unnamed.png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH)));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Display");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(102, 0, 120, 40);
		lblNewLabel_2.setBackground(Color.PINK);
		lblNewLabel_2.setOpaque(true);
		//lblNewLabel_2.setIcon(new ImageIcon(InventoryPanel.class.getResource("/MedOut/Edit_icon_(the_Noun_Project_30184).png")));
		lblNewLabel_2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/MedOut/Edit_icon_(the_Noun_Project_30184).png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH)));
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(new BorderLayout(0,0));
		panel_3.setBackground(Color.PINK);
		add(panel_2,BorderLayout.CENTER);
		panel_2.setLayout(null);
		JScrollPane jsp=new JScrollPane();
		
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				add(panel_2,BorderLayout.CENTER);
				panel_2.setVisible(true);
				panel_3.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setBackground(new Color(220, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setBackground(Color.PINK);
			}
		});
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				add(panel_3,BorderLayout.CENTER);
				panel_2.setVisible(false);
				panel_3.setVisible(true);
				InventoryPanel_1 ip=new InventoryPanel_1();
				jsp.setViewportView(ip);
				panel_3.add(jsp,BorderLayout.CENTER);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2.setBackground(new Color(220, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setBackground(Color.PINK);
			}
		});
	}
}
