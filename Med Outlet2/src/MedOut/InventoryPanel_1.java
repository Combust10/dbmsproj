package MedOut;

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

public class InventoryPanel_1 extends JPanel {
	private JTextField txtQuantity;
	private JTextField txtPrice;

	/**
	 * Create the panel.
	 */
	public InventoryPanel_1() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(100,60));
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 168, 78, 90, 0, 0, 0, -26, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Product:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 2;
		panel.add(comboBox, gbc_comboBox);
		
		txtQuantity = new JTextField();

		txtQuantity.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtQuantity.setForeground(Color.LIGHT_GRAY);
		txtQuantity.setText("Quantity");
		GridBagConstraints gbc_txtQuantity = new GridBagConstraints();
		gbc_txtQuantity.insets = new Insets(0, 0, 5, 5);
		gbc_txtQuantity.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtQuantity.gridx = 2;
		gbc_txtQuantity.gridy = 2;
		panel.add(txtQuantity, gbc_txtQuantity);
		txtQuantity.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtPrice.setForeground(Color.LIGHT_GRAY);
		txtPrice.setText("Price");
		GridBagConstraints gbc_txtPrice = new GridBagConstraints();
		gbc_txtPrice.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrice.gridx = 3;
		gbc_txtPrice.gridy = 2;
		panel.add(txtPrice, gbc_txtPrice);
		txtPrice.setColumns(10);
		String columnNames[]= {"Products","Quantity","Price"};
		JTable table = new JTable();
		
		JButton btnNewButton_1 = new JButton("LOAD");

		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 2;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("REMOVE");

		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 5;
		gbc_btnNewButton_2.gridy = 2;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
		
				JButton btnNewButton = new JButton("EDIT");
				
						GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
						gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
						gbc_btnNewButton.gridx = 6;
						gbc_btnNewButton.gridy = 2;
						panel.add(btnNewButton, gbc_btnNewButton);
						btnNewButton.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								try {
									Connection dbc=DriverManager.getConnection("jdbc:sqlite::resource:MedOut/Database.db");
									if(txtQuantity.getText().isEmpty()||txtPrice.getText().isEmpty())
									{
										JOptionPane.showMessageDialog(null,"Please enter all the required details","Error",JOptionPane.ERROR_MESSAGE);
									}
									else {
										String sql="UPDATE stock SET Quantity=?,Price=? WHERE Product=?";
										PreparedStatement pst=dbc.prepareStatement(sql);
										pst.setString(3,String.valueOf(comboBox.getSelectedItem()));
										pst.setInt(1,Integer.valueOf(txtQuantity.getText()));
										pst.setInt(2,Integer.valueOf(txtPrice.getText()));
										pst.execute();

										JOptionPane.showMessageDialog(null,"Product updated!","Success",JOptionPane.INFORMATION_MESSAGE);
									}
									dbc.close();
								} catch (SQLException ex) {
									// TODO Auto-generated catch block
									ex.printStackTrace();
								}
							}
						});
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BorderLayout(0,0));
		panel_1.setBackground(Color.WHITE);
		add(panel_1, BorderLayout.CENTER);
		JScrollPane jsp=new JScrollPane();

	
		txtQuantity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtQuantity.setForeground(Color.BLACK);
				txtQuantity.setText(null);
				txtQuantity.setFont(new Font("Tahoma",Font.PLAIN, 11));
				
			}
		});
		txtPrice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPrice.setForeground(Color.BLACK);
				txtPrice.setText(null);
				txtPrice.setFont(new Font("Tahoma",Font.PLAIN, 11));
				
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					Connection dbc1=DriverManager.getConnection("jdbc:sqlite::resource:MedOut/Database.db");
					PreparedStatement pst=dbc1.prepareStatement("SELECT Product,Quantity,Price FROM stock");
					ResultSet r=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(r));
					table.setBackground(Color.white);
					jsp.setViewportView(table);
					panel_1.add(jsp,BorderLayout.CENTER);
					dbc1.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
				try {
					comboBox.removeAllItems();
					Connection dbc=DriverManager.getConnection("jdbc:sqlite::resource:MedOut/Database.db");
					PreparedStatement prep=dbc.prepareStatement("SELECT * FROM stock");
					ResultSet res=prep.executeQuery();
					while(res.next())
					{
						comboBox.addItem(res.getString("Product"));
					}
					
					}catch(SQLException ex)
				{
						JOptionPane.showMessageDialog(null,"SQL Error connecting to database","Error",JOptionPane.ERROR_MESSAGE);		
				}
				
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				int result=JOptionPane.showConfirmDialog(null,"Are you sure you want to delete the Product?","Delete",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(result==JOptionPane.YES_OPTION)
					{
			Connection con;

				con = DriverManager.getConnection("jdbc:sqlite::resource:MedOut/Database.db");
							
			String str="DELETE FROM stock WHERE Product=?";
			PreparedStatement pst=con.prepareStatement(str);

			pst.setString(1,String.valueOf(comboBox.getSelectedItem()));
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null,"Product deleted!","Success",JOptionPane.INFORMATION_MESSAGE);
					}
			}
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}});
	
	}
}
