package TM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Settings extends JPanel {

	/**
	 * Create the panel.
	 */
	public void clearDatabase(String TABLE_NAME) {  
		   Connection dbc;
		try {
			dbc = DriverManager.getConnection("jdbc:sqlite::resource:TM/Database.db");
		
		   String clearDBQuery = "DELETE FROM "+TABLE_NAME;  
		   PreparedStatement prep=dbc.prepareStatement(clearDBQuery);
		   prep.execute();
		   dbc.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"SQL Error connecting to database","Error",JOptionPane.ERROR_MESSAGE);	
			e.printStackTrace();
		}
		   }  
	public Settings() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setPreferredSize(new Dimension(80,80));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("SETTINGS");
		lblNewLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/TM/settings.png")).getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH)));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		panel.add(lblNewLabel,BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Fullscreen on launch");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setBounds(10, 20, 189, 21);
		panel_1.add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("Apply");

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(137, 145, 119, 53);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Reset Database:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(10, 63, 128, 13);
		panel_1.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Reset");

		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(148, 62, 85, 21);
		panel_1.add(btnNewButton_1);
		Connection dbc;
		try {
			dbc = DriverManager.getConnection("jdbc:sqlite::resource:TM/Database.db");
		
		PreparedStatement prep=dbc.prepareStatement("SELECT fs,name,line1,line2 FROM settings");
		ResultSet res=prep.executeQuery();
		while(res.next())
		{
			if(res.getInt("fs")==1)
			chckbxNewCheckBox.setSelected(true);
			else
			chckbxNewCheckBox.setSelected(false);
			
			//textField.setText(res.getString("name"));
			//textField_1.setText(res.getString("line1"));
			//textField_2.setText(res.getString("line2"));
		}
		dbc.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection dbc;
				try {
				dbc = DriverManager.getConnection("jdbc:sqlite::resource:TM/Database.db");
				PreparedStatement prep=dbc.prepareStatement("UPDATE settings SET fs=?");
				if(chckbxNewCheckBox.isSelected())
				{prep.setInt(1, 1);
				}				
				else
				prep.setInt(1, 0);
				prep.execute();
				// prep=dbc.prepareStatement("UPDATE settings SET name=?");
				// prep.setString(1, textField.getText());
				// prep.execute();
				 //prep=dbc.prepareStatement("UPDATE settings SET line1=?");
				 //prep.setString(1, textField_1.getText());
				 //prep.execute();
				 //prep=dbc.prepareStatement("UPDATE settings SET line2=?");
				// prep.setString(1, textField_2.getText());
				 prep.execute();
				 dbc.close();
				 JOptionPane.showMessageDialog(null,"Settings applied!","Success",JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result=JOptionPane.showConfirmDialog(null,"Are you sure you want to reset the database clearing all stored information?","Delete",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(result==JOptionPane.YES_OPTION)
					{
						clearDatabase("login");
						clearDatabase("customers");
						clearDatabase("package");
						clearDatabase("company");
						clearDatabase("settings");
						try {
							SQLite.initialise();		
							JOptionPane.showMessageDialog(null,"Database cleared!","Success",JOptionPane.INFORMATION_MESSAGE);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
			}
		});
	}
}
