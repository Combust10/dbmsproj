package MedOut;

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

public class SalesPanel extends JPanel {
	private JTable table;
	int total=0;
	/**
	 * Create the panel.
	 */
	public SalesPanel() {
		
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setPreferredSize(new Dimension(80,80));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("SALES");
		lblNewLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/MedOut/cvs-health-payor-solutions-measuring-success-main-image_0.png")).getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH)));
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
		panel_3.setPreferredSize(new Dimension(100,60));
		panel_2.add(panel_3, BorderLayout.NORTH);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{83, 74, 0, 50, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{14, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setPreferredSize(new Dimension(100,60));
		panel_2.add(panel_4, BorderLayout.SOUTH);
		
		JButton btnNewButton_3 = new JButton("Log Sale");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Date date = new Date();
					Connection dbc=DriverManager.getConnection("jdbc:sqlite::resource:MedOut/Database.db");
					int count= table.getModel().getRowCount(); 
					for(int i=0;i<count;i++)
					{
					String sql="INSERT INTO sales values(?,?,?,?,?,?);";
					PreparedStatement pst=dbc.prepareStatement(sql);
					pst.setString(1,"");
					pst.setString(2,MainMenu.getname());
					pst.setString(3,(String) table.getModel().getValueAt(i, 0));
					pst.setString(4,(String) table.getModel().getValueAt(i, 2));
					pst.setString(5,(String) table.getModel().getValueAt(i, 1));
					pst.setString(6,date.toString());
					pst.execute();
					}
					JOptionPane.showMessageDialog(null,"Sale logged!","Success",JOptionPane.INFORMATION_MESSAGE);
					dbc.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		//panel_4.add(btnNewButton_3,BorderLayout.CENTER);
		
		JButton btnNewButton_4 = new JButton("Generate Bill");

		//panel_4.add(btnNewButton_4,BorderLayout.CENTER);
		
		JLabel lblNewLabel_3 = new JLabel("Product:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 1;
		panel_3.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JComboBox<String> comboBox = new JComboBox<String>();
	
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		panel_3.add(comboBox, gbc_comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Quantity:");
		lblNewLabel_4.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 1;
		panel_3.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 3;
		gbc_comboBox_1.gridy = 1;
		panel_3.add(comboBox_1, gbc_comboBox_1);
		
		JButton btnNewButton = new JButton("Add");

		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 1;
		panel_3.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");

		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 5;
		gbc_btnNewButton_1.gridy = 1;
		panel_3.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Refresh");

		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.gridx = 6;
		gbc_btnNewButton_2.gridy = 1;
		panel_3.add(btnNewButton_2, gbc_btnNewButton_2);
		JPanel but=new JPanel();
		but.setBackground(Color.WHITE);
		but.add(btnNewButton_3);
		but.add(btnNewButton_4);
		panel_4.add(but,BorderLayout.CENTER);
		
		JLabel lblNewLabel_5 = new JLabel("Total:");
		but.add(lblNewLabel_5);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		JScrollPane js=new JScrollPane();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Products", "Quantity", "Price"
			}
		));
		js.setViewportView(table);
		TableModel tm=table.getModel();
		DefaultTableModel dtm=(DefaultTableModel)tm;
		panel_2.add(js, BorderLayout.CENTER);

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
				SalesPanel_1 ip=new SalesPanel_1();
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

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					comboBox.removeAllItems();
					Connection dbc=DriverManager.getConnection("jdbc:sqlite::resource:MedOut/Database.db");
					PreparedStatement prep=dbc.prepareStatement("SELECT * FROM stock");
					ResultSet res=prep.executeQuery();
					while(res.next())
					{
						comboBox.addItem(res.getString("Product"));
					}
					dbc.close();
					}catch(SQLException ex)
				{
						JOptionPane.showMessageDialog(null,"SQL Error connecting to database","Error",JOptionPane.ERROR_MESSAGE);		
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection dbc=DriverManager.getConnection("jdbc:sqlite::resource:MedOut/Database.db");
					String sql="SELECT Price FROM stock WHERE Product=?";
					PreparedStatement pst=dbc.prepareStatement(sql);
					pst.setString(1,String.valueOf(comboBox.getSelectedItem()));
					ResultSet rs=pst.executeQuery();					
				
					try {
					String s[]={String.valueOf(comboBox.getSelectedItem()),String.valueOf(comboBox_1.getSelectedItem()),String.valueOf(rs.getInt("Price")*Integer.valueOf(String.valueOf(comboBox_1.getSelectedItem())))};
					dtm.addRow(s);
					PreparedStatement prep=dbc.prepareStatement("SELECT Quantity FROM stock where Product=?");
					prep.setString(1,String.valueOf(comboBox.getSelectedItem()) );				
					ResultSet res=prep.executeQuery();
					int a=0;
					if(res.next())
					a=res.getInt("Quantity");
					sql="UPDATE stock SET quantity=? WHERE Product=?";
					pst=dbc.prepareStatement(sql);
					pst.setInt(1,(a-Integer.valueOf(String.valueOf(comboBox_1.getSelectedItem()))));
					pst.setString(2,String.valueOf(comboBox.getSelectedItem()));
					pst.execute();
					total=0;
					for(int i = 0; i < table.getRowCount(); i++){
				        int Amount = Integer.parseInt(table.getValueAt(i, 2)+"");
				        total = Amount+total;			        
				    }
					lblNewLabel_5.setText("Total:"+total);
					dbc.close();
					}
					catch(Exception e)
					{JOptionPane.showMessageDialog(null,"Cannot add empty products","Error",JOptionPane.ERROR_MESSAGE);
					dbc.close();}
					dbc=DriverManager.getConnection("jdbc:sqlite::resource:MedOut/Database.db");
					comboBox.removeAllItems();
					PreparedStatement prep=dbc.prepareStatement("SELECT * FROM stock");
					ResultSet res=prep.executeQuery();
					while(res.next())
					{
						comboBox.addItem(res.getString("Product"));
					}
					dbc.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dtm.setRowCount(0);
				lblNewLabel_5.setText("Total:");
			}
		});
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox_1.removeAllItems();
				Connection dbc;
				try {
					dbc = DriverManager.getConnection("jdbc:sqlite::resource:MedOut/Database.db");
			
				PreparedStatement prep=dbc.prepareStatement("SELECT Quantity FROM stock where Product=?");
				prep.setString(1,String.valueOf(comboBox.getSelectedItem()) );				
				ResultSet res=prep.executeQuery();
				int a=0;
				if(res.next())
				a=res.getInt("Quantity");
				for(int i=1;i<=a;i++)
				{
					comboBox_1.addItem(String.valueOf(i));
				}
				dbc.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Bill.main(table,total);
			}
		});
	}
}
