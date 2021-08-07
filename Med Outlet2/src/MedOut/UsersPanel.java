package MedOut;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

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
import java.util.Random;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UsersPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_2;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public UsersPanel() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(80, 80));
		panel.setBackground(Color.PINK);
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblUsers = new JLabel("USERS");
		lblUsers.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/MedOut/multy-user.png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH)));
		lblUsers.setVerticalAlignment(SwingConstants.TOP);
		lblUsers.setForeground(Color.RED);
		lblUsers.setFont(new Font("Arial", Font.BOLD, 30));
		panel.add(lblUsers, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setPreferredSize(new Dimension(500, 40));
		panel_1.setBackground(Color.PINK);
		panel.add(panel_1, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = new JLabel("Add");
		lblNewLabel_1.setOpaque(true);
		
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(Color.PINK);
		lblNewLabel_1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/MedOut/unnamed.png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH)));
		lblNewLabel_1.setBounds(0, 0, 102, 40);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("EDIT");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/MedOut/Edit_icon_(the_Noun_Project_30184).png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH)));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBackground(Color.PINK);
		lblNewLabel_2.setBounds(102, 0, 120, 40);
		panel_1.add(lblNewLabel_2);
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.PINK);
		panel_3.setLayout(new BorderLayout());
		JPanel panel_3_1=new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(Color.WHITE);
		panel_3.add(panel_3_1,BorderLayout.CENTER);
		JComboBox<String> unames=new JComboBox<>();
		unames.setPreferredSize(new Dimension(109,22));
		JLabel userlbl=new JLabel("Select User:");
		userlbl.setBackground(Color.WHITE);
		userlbl.setBounds(29, 45, 73, 14);
		panel_3_1.add(userlbl);
		JButton btn = new JButton("DELETE");
		btn.setBounds(37, 86, 89, 23);
		panel_3_1.add(btn);	
		JTextField adminpass=new JTextField();
		adminpass.setBounds(180, 130, 200, 20);
		panel_3_1.add(adminpass);
		JLabel cadmin=new JLabel("Change admin password:");
		cadmin.setBackground(Color.WHITE);
		cadmin.setBounds(29, 130, 200, 14);
		panel_3_1.add(cadmin);
		add(panel_2,BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JButton btn1 = new JButton("Change");
		btn1.setBounds(37, 170, 100, 23);
		panel_3_1.add(btn1);
		
		JButton btn2 = new JButton("Alternative admin passwords");
		btn2.setBounds(37, 210, 100, 23);
		panel_3_1.add(btn2);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(34, 27, 105, 19);
		panel_2.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(34, 67, 105, 19);
		panel_2.add(lblPassword);
		
		JLabel lblSecurityQuestion = new JLabel("Security Question:");
		lblSecurityQuestion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSecurityQuestion.setBounds(34, 109, 127, 19);
		panel_2.add(lblSecurityQuestion);
		
		JLabel lblAnswer = new JLabel("Answer:");
		lblAnswer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnswer.setBounds(34, 146, 105, 19);
		panel_2.add(lblAnswer);
		
		textField = new JTextField();
		textField.setBounds(178, 28, 145, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(178, 147, 145, 20);
		panel_2.add(textField_2);
		String[] Ques={"1.What primary school did you attend?","2.In what city does your nearest sibling live?","3.What was your childhood nickname?","4.What was your favorite sport in high school?","5.What is your mother's maiden name?"};
		JComboBox<String> comboBox = new JComboBox<>(Ques);
		comboBox.setBounds(178, 109, 285, 22);
		panel_2.add(comboBox);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(178, 68, 145, 20);
		panel_2.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("(Case Sensitive)");
		lblNewLabel_3.setBounds(34, 84, 105, 14);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("(Case Sensitive)");
		lblNewLabel_3_1.setBounds(32, 166, 107, 14);
		panel_2.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("Must be atleast 8 characters long");
		lblNewLabel_4.setBounds(177, 92, 198, 14);
		panel_2.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Create Account");
		btn2.setVisible(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=1;
				lblNewLabel_4.setForeground(Color.BLACK);
				if(passwordField.getText().length()<8)
				{
					flag=0;
					lblNewLabel_4.setForeground(Color.RED);
				}
				if(passwordField.getText().isEmpty()||textField.getText().isEmpty()||textField_2.getText().isEmpty())
				{
					flag=0;
					JOptionPane.showMessageDialog(null,"Please enter all the required details","Error",JOptionPane.ERROR_MESSAGE);
				}

				try {
					Connection con=DriverManager.getConnection("jdbc:sqlite::resource:MedOut/Database.db");
					String query="SELECT username FROM login WHERE username=?";
					PreparedStatement pst=con.prepareStatement(query);
					pst.setString(1,textField.getText());
					ResultSet rs=pst.executeQuery();
					if(rs.next())
					{
							flag=0;
							JOptionPane.showMessageDialog(null,"This user already exists","Error",JOptionPane.WARNING_MESSAGE);
					}
					con.close();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,"SQL Error connecting to database","Error",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				if(flag==1)
				{
					try {
						String password = String.valueOf(passwordField.getPassword());
						Connection con=DriverManager.getConnection("jdbc:sqlite::resource:MedOut/Database.db");
						String query="INSERT INTO login values(?,?,?,?,?);";
						PreparedStatement pst=con.prepareStatement(query);
						pst.setString(2,textField.getText());	
						pst.setString(3,password);
						pst.setString(4,String.valueOf(comboBox.getSelectedItem()));
						pst.setString(5, textField_2.getText());
						pst.execute();
						JOptionPane.showMessageDialog(null,"New User created!","Success",JOptionPane.INFORMATION_MESSAGE);
						con.close();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null,"SQL Error connecting to database","Error",JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
				}

			}
		});
		btnNewButton.setBounds(156, 186, 127, 23);
		panel_2.add(btnNewButton);
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
				try {
					unames.removeAllItems();
					Connection dbc=DriverManager.getConnection("jdbc:sqlite::resource:MedOut/Database.db");
					PreparedStatement prep=dbc.prepareStatement("SELECT * FROM login");
					ResultSet r=prep.executeQuery();
					while(r.next())
					{
						unames.addItem(r.getString("username"));
					}
					unames.setBounds(132, 41, 185, 22);
					panel_3_1.add(unames);
					
					}catch(SQLException ex)
				{
						JOptionPane.showMessageDialog(null,"SQL Error connecting to database","Error",JOptionPane.ERROR_MESSAGE);		
				}
				panel_2.setVisible(false);
				panel_3.setVisible(true);
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
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connection con;
				try {
					if(String.valueOf(unames.getSelectedItem()).equals("admin"))
					{
						JOptionPane.showMessageDialog(null,"Cannot delete admin account","Error",JOptionPane.ERROR_MESSAGE);
					}
					else {
						int result=JOptionPane.showConfirmDialog(null,"Are you sure you want to delete the user?","Delete",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if(result==JOptionPane.YES_OPTION)
							{
					con = DriverManager.getConnection("jdbc:sqlite::resource:MedOut/Database.db");				
					String str="DELETE FROM login WHERE username=?";
					PreparedStatement pst=con.prepareStatement(str);

					pst.setString(1,String.valueOf(unames.getSelectedItem()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"User deleted!","Success",JOptionPane.INFORMATION_MESSAGE);
					con.close();
							}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connection con;
				try {
					if(adminpass.getText().length()<8)
					{
						JOptionPane.showMessageDialog(null,"Password must be atleast 8  characters","Error",JOptionPane.ERROR_MESSAGE);
					}
					else {
						int result=JOptionPane.showConfirmDialog(null,"Are you sure you want to change the password?","Are you sure",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if(result==JOptionPane.YES_OPTION)
							{
					con = DriverManager.getConnection("jdbc:sqlite::resource:MedOut/Database.db");				
					String str="UPDATE login SET password=? WHERE username=?";
					PreparedStatement pst=con.prepareStatement(str);
					pst.setString(1,adminpass.getText());
					pst.setString(2,"admin");
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Password changed!","Success",JOptionPane.INFORMATION_MESSAGE);
							}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Codes.main(null);
			}
		});

	}
	  
	  
}
