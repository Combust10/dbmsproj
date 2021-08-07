package TM;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JTextField;

public class CustomerPanel extends JPanel {
	int total=0;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	/**
	 * Create the panel.
	 */
	public CustomerPanel() {
		
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setPreferredSize(new Dimension(80,80));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("CUSTOMERS");
		lblNewLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/TM/signup.png")).getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH)));
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
		lblNewLabel_1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/TM/unnamed.png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH)));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Display");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(102, 0, 120, 40);
		lblNewLabel_2.setBackground(Color.PINK);
		lblNewLabel_2.setOpaque(true);
		//lblNewLabel_2.setIcon(new ImageIcon(PackagePanel.class.getResource("/TM/Edit_icon_(the_Noun_Project_30184).png")));
		lblNewLabel_2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/TM/Edit_icon_(the_Noun_Project_30184).png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH)));
		panel_1.add(lblNewLabel_2);
		
		JPanel disp = new JPanel();
		disp.setBackground(Color.WHITE);
		add(disp, BorderLayout.CENTER);
		disp.setLayout(new BorderLayout(0, 0));
		disp.setVisible(false);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_2.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Name:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(31, 26, 71, 20);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Phone No:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(31, 56, 105, 20);
		panel_3.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("ID No:");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_2.setBounds(31, 87, 71, 20);
		panel_3.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Address:");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_3.setBounds(31, 117, 71, 20);
		panel_3.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Age:");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_4.setBounds(31, 148, 71, 20);
		panel_3.add(lblNewLabel_3_4);
		
		textField = new JTextField();
		textField.setBounds(153, 26, 171, 19);
		panel_3.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(153, 53, 171, 19);
		panel_3.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(153, 83, 171, 19);
		panel_3.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(153, 115, 171, 19);
		panel_3.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(153, 144, 171, 19);
		panel_3.add(textField_4);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(142, 189, 85, 21);
		panel_3.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Customer No:");
		lblNewLabel_4.setBounds(31, 10, 85, 13);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(151, 10, 45, 13);
		panel_3.add(lblNewLabel_5);
		//DefaultTableModel dtm=(DefaultTableModel)tm;

		JScrollPane jsp=new JScrollPane();
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				add(panel_2,BorderLayout.CENTER);
				panel_2.setVisible(true);
				disp.setVisible(false);
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
				add(disp,BorderLayout.CENTER);
				panel_2.setVisible(false);
				disp.setVisible(true);
				CustomerPanel_1 ip=new CustomerPanel_1();
				jsp.setViewportView(ip);
				disp.add(jsp,BorderLayout.CENTER);
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
