package TM;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PackagePanel_1 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public PackagePanel_1() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setPreferredSize(new Dimension(100, 60));
		panel1.setBackground(Color.WHITE);
		add(panel1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Customer No:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 24, 110, 13);
		panel1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(134, 23, 96, 19);
		panel1.add(textField);
		
		JButton btnNewButton = new JButton("Go");

		btnNewButton.setBounds(253, 22, 85, 21);
		panel1.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel_3 = new JLabel("Name:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(75, 52, 71, 20);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Date:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(75, 82, 105, 20);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("ID No:");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_2.setBounds(75, 113, 71, 20);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Package");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_3.setBounds(75, 143, 71, 20);
		panel.add(lblNewLabel_3_3);
		
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
		String columnNames[]= {"Products","Quantity","Price"};
		JTable table = new JTable();
		JScrollPane jsp=new JScrollPane();
		
		
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				try {
					Connection dbc=DriverManager.getConnection("jdbc:sqlite::resource:TM/Database.db");
					PreparedStatement prep = dbc
							.prepareStatement("SELECT * FROM customers where no=" + textField.getText());
					ResultSet rs = prep.executeQuery();
					if (rs.next()) {
							PreparedStatement prep1 = dbc
								.prepareStatement("SELECT * FROM package where no=" + textField.getText());
							ResultSet r = prep1.executeQuery();
							if (r.next()) {
								textField_2.setText(r.getString("date"));
								textField_3.setText(r.getString("id"));
								textField_4.setText(r.getString("packageno"));
							} else {
								JOptionPane.showMessageDialog(null, "Customer has not bought a package", "Error",
									JOptionPane.ERROR_MESSAGE);
							} 
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Customer does not exist", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					dbc.close();
					}catch(SQLException ex)
				{
						JOptionPane.showMessageDialog(null,"SQL Error connecting to database","Error",JOptionPane.ERROR_MESSAGE);		
				}
				
				
				
				
			}
		});
	
	}
}
