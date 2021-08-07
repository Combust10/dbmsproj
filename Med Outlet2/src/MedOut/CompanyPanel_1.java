package MedOut;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CompanyPanel_1 extends JPanel {
		/*JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.removeAllItems();
		Connection dbc;
		try {
			dbc = DriverManager.getConnection("jdbc:sqlite::resource:MedOut/Database.db");		
		PreparedStatement prep=dbc.prepareStatement("SELECT * FROM company");
		ResultSet r=prep.executeQuery();
		while(r.next())
		{
			comboBox.addItem(r.getString("compname"));
		}
		dbc.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"SQL Error connecting to database","Error",JOptionPane.ERROR_MESSAGE);		
		}*/
	public CompanyPanel_1() {
		setLayout(new BorderLayout(0,0));
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		add(panel_2,BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 176, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 182, 48, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Company Name:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 2;
		panel_2.add(lblNewLabel_3, gbc_lblNewLabel_3);
		

		JComboBox<String> comboBox = new JComboBox<String>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		panel_2.add(comboBox, gbc_comboBox);
		
		JButton btnNewButton_2 = new JButton("REFRESH");

		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 3;
		gbc_btnNewButton_2.gridy = 2;
		panel_2.add(btnNewButton_2, gbc_btnNewButton_2);
		JLabel lblNewLabel_3_1 = new JLabel("Company Details:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_3_1 = new GridBagConstraints();
		gbc_lblNewLabel_3_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3_1.gridx = 1;
		gbc_lblNewLabel_3_1.gridy = 3;
		panel_2.add(lblNewLabel_3_1, gbc_lblNewLabel_3_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 3;
		panel_2.add(scrollPane, gbc_scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 4;
		panel_2.add(panel, gbc_panel);
		
		JButton btnNewButton = new JButton("UPDATE");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connection con;
				try {
						int result=JOptionPane.showConfirmDialog(null,"Are you sure you want to delete the company details?","Delete",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if(result==JOptionPane.YES_OPTION)
							{
					con = DriverManager.getConnection("jdbc:sqlite::resource:MedOut/Database.db");				
					String str="DELETE FROM company WHERE compname=?";
					PreparedStatement pst=con.prepareStatement(str);
					pst.setString(1,String.valueOf(comboBox.getSelectedItem()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Company deleted!","Success",JOptionPane.INFORMATION_MESSAGE);
					con.close();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnNewButton_1);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection dbc;
				try {
					dbc = DriverManager.getConnection("jdbc:sqlite::resource:MedOut/Database.db");
				
				PreparedStatement prep=dbc.prepareStatement("SELECT * FROM company WHERE compname=?");
				prep.setString(1,String.valueOf(comboBox.getSelectedItem()));
				ResultSet r=prep.executeQuery();
				if(r.next())
				textArea.setText(r.getString("compdets"));
				dbc.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Connection dbc=DriverManager.getConnection("jdbc:sqlite::resource:MedOut/Database.db");
					if(textArea.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null,"Please enter all the required details","Error",JOptionPane.ERROR_MESSAGE);
					}
					else {
						String sql="UPDATE company SET compdets=? WHERE compname=?";
						PreparedStatement pst=dbc.prepareStatement(sql);
						pst.setString(2,String.valueOf(comboBox.getSelectedItem()));
						pst.setString(1,textArea.getText());
						pst.execute();

						JOptionPane.showMessageDialog(null,"Company updated!","Success",JOptionPane.INFORMATION_MESSAGE);
					}
					dbc.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBox.removeAllItems();
				Connection dbc;
				try {
					dbc = DriverManager.getConnection("jdbc:sqlite::resource:MedOut/Database.db");		
				PreparedStatement prep=dbc.prepareStatement("SELECT * FROM company");
				ResultSet r=prep.executeQuery();
				while(r.next())
				{
					comboBox.addItem(r.getString("compname"));
				}
				dbc.close();
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"SQL Error","Error",JOptionPane.ERROR_MESSAGE);		
				}
			}
		});

	}

}
