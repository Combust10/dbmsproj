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

public class SalesPanel_1 extends JPanel {
	private JTable table;

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
		
		JLabel lblNewLabel = new JLabel("User:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 24, 45, 13);
		panel1.add(lblNewLabel);
		
		JComboBox unames = new JComboBox();
		unames.setBounds(52, 22, 110, 21);
		try {
			unames.removeAllItems();
			unames.addItem("All");
			Connection dbc=DriverManager.getConnection("jdbc:sqlite::resource:MedOut/Database.db");
			PreparedStatement prep=dbc.prepareStatement("SELECT * FROM login");
			ResultSet r=prep.executeQuery();
			while(r.next())
			{
				unames.addItem(r.getString("username"));
			}
			dbc.close();
			}catch(SQLException ex)
		{
				JOptionPane.showMessageDialog(null,"SQL Error connecting to database","Error",JOptionPane.ERROR_MESSAGE);		
		}
		panel1.add(unames);
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		Connection dbc;
		try {
			dbc = DriverManager.getConnection("jdbc:sqlite::resource:MedOut/Database.db");
		
		PreparedStatement pst=dbc.prepareStatement("SELECT User,Product,Price,Quantity,Date FROM sales");
		ResultSet r=pst.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(r));
		dbc.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scrollPane.setViewportView(table);
		unames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
						
					Connection dbc = DriverManager.getConnection("jdbc:sqlite::resource:MedOut/Database.db");
					if(String.valueOf(unames.getSelectedItem()).equals("All"))
					{
						PreparedStatement pst=dbc.prepareStatement("SELECT User,Product,Price,Quantity,Date FROM sales");
						ResultSet r=pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(r));
						
					}else
					{
					PreparedStatement pst=dbc.prepareStatement("SELECT User,Product,Price,Quantity,Date FROM sales WHERE User=?");
					pst.setString(1, String.valueOf(unames.getSelectedItem()));
					ResultSet r=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(r));
					}				
					dbc.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
