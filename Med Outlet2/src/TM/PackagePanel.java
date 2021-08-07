package TM;

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
import javax.swing.JList;
import javax.swing.JComboBox;

public class PackagePanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public PackagePanel() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setPreferredSize(new Dimension(80,80));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("PACKAGES");
		lblNewLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/TM/6639703_preview.png")).getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH)));
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
		//lblNewLabel_2.setIcon(new ImageIcon(InventoryPanel.class.getResource("/MedOut/Edit_icon_(the_Noun_Project_30184).png")));
		lblNewLabel_2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/TM/Edit_icon_(the_Noun_Project_30184).png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH)));
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(new BorderLayout(0,0));
		panel_3.setBackground(Color.PINK);
		add(panel_2,BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Customer no:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 10, 105, 20);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Date:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(10, 40, 105, 20);
		panel_2.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("ID No:");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_2.setBounds(10, 71, 71, 20);
		panel_2.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Package:");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_3.setBounds(10, 101, 71, 20);
		panel_2.add(lblNewLabel_3_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(112, 10, 171, 19);
		panel_2.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(112, 37, 171, 19);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(112, 67, 171, 19);
		panel_2.add(textField_2);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(112, 176, 85, 21);
		panel_2.add(btnNewButton);
		
		String ch[]={"1.Singapore Package","2.Dubai Package","3.Thailand Package","4.US Package"};
		JComboBox<String> comboBox = new JComboBox<String>(ch);
		comboBox.setBounds(112, 103, 171, 21);
		panel_2.add(comboBox);
		
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
				PackagePanel_1 ip=new PackagePanel_1();
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
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name=textField.getText();
				String ph=textField_1.getText();
				String idno=textField_2.getText();
				
				
				if(textField.getText().isEmpty()||textField_1.getText().isEmpty()||textField_2.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Please enter all the required details","Error",JOptionPane.ERROR_MESSAGE);
				}
				else{
				
					try {
						Connection con=DriverManager.getConnection("jdbc:sqlite::resource:TM/Database.db");
						PreparedStatement prep=con.prepareStatement("SELECT * FROM customers where no="+textField.getText());
						ResultSet r=prep.executeQuery();
						if(!r.next())
						{
							JOptionPane.showMessageDialog(null,"Customer does not exist","Error",JOptionPane.ERROR_MESSAGE);
						}
						else
						{
						String query="INSERT INTO Package values(?,?,?,?);";
						PreparedStatement pst=con.prepareStatement(query);
						pst.setString(1,textField.getText());	
						pst.setString(2,textField_1.getText());	
						pst.setString(3,textField_2.getText());
						pst.setString(4,String.valueOf(comboBox.getSelectedItem()));
						pst.execute();
						JOptionPane.showMessageDialog(null,"New Product added!","Success",JOptionPane.INFORMATION_MESSAGE);
						}
						con.close();
						} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null,"SQL Error connecting to database","Error",JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
			}	
				}

				
				
				
				
				
			
		});
	}
}
