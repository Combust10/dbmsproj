package MedOut;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.BorderLayout;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SalesPanel_1 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public SalesPanel_1() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		JPanel panel1=new JPanel();
		panel1.setBackground(Color.WHITE);
		panel1.setPreferredSize(new Dimension(100,60));
		add(panel1,BorderLayout.NORTH);
		panel1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer No:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 24, 110, 13);
		panel1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(134, 23, 96, 19);
		panel1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Go");
		btnNewButton.setBounds(253, 22, 85, 21);
		panel1.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Customer No:");
		lblNewLabel_4.setBounds(75, 36, 85, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Name:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(75, 52, 71, 20);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Phone No:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(75, 82, 105, 20);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("ID No:");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_2.setBounds(75, 113, 71, 20);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Address:");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_3.setBounds(75, 143, 71, 20);
		panel.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Age:");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_4.setBounds(75, 174, 71, 20);
		panel.add(lblNewLabel_3_4);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(197, 52, 171, 19);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(197, 79, 171, 19);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(197, 109, 171, 19);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(197, 141, 171, 19);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(197, 170, 171, 19);
		panel.add(textField_5);
		try {
			Connection dbc=DriverManager.getConnection("jdbc:sqlite::resource:MedOut/Database.db");
			PreparedStatement prep=dbc.prepareStatement("SELECT * FROM login");
			ResultSet r=prep.executeQuery();
			while(r.next())
			{
				//unames.addItem(r.getString("username"));
			}
			dbc.close();
			}catch(SQLException ex)
		{
				JOptionPane.showMessageDialog(null,"SQL Error connecting to database","Error",JOptionPane.ERROR_MESSAGE);		
		}
		Connection dbc;
		try {
			dbc = DriverManager.getConnection("jdbc:sqlite::resource:MedOut/Database.db");
		
		PreparedStatement pst=dbc.prepareStatement("SELECT User,Product,Price,Quantity,Date FROM sales");
		ResultSet r=pst.executeQuery();
		dbc.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
