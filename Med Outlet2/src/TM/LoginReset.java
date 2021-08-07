package TM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class LoginReset extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginReset frame = new LoginReset();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginReset() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginReset.class.getResource("/TM/check.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 517, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(56, 47, 79, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Security Question:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(56, 83, 128, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Answer:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(56, 123, 79, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New Password:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(56, 154, 104, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm Password:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(56, 188, 128, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Confirm");

		btnNewButton.setBounds(196, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(206, 48, 148, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(193, 88, 298, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(206, 122, 148, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(206, 153, 148, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(206, 187, 148, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setBounds(126, 24, 261, 14);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("Get question");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection dbc;
				try {
					dbc = DriverManager.getConnection("jdbc:sqlite::resource:TM/Database.db");
					String sql="SELECT username FROM login WHERE username=?";
					PreparedStatement pst=dbc.prepareStatement(sql);
					pst.setString(1,textField.getText());
					ResultSet rs=pst.executeQuery();
					if(textField.getText().equals("admin"))
						lblNewLabel_6.setText("Cannot change admin password here");
					else if(!rs.next())
					{
							lblNewLabel_6.setText("User does not exist");
					}
					else {
						lblNewLabel_6.setText("");
				sql="SELECT sq from login WHERE username=?";
				pst=dbc.prepareStatement(sql);
				pst.setString(1, textField.getText());
				rs=pst.executeQuery();
				//if(rs.next())
					lblNewLabel_5.setText(rs.getString("sq"));
					}
					dbc.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(380, 47, 111, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("Change Password");
		lblNewLabel_7.setBounds(198, 3, 122, 14);
		contentPane.add(lblNewLabel_7);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int flag=1;
					Connection dbc=DriverManager.getConnection("jdbc:sqlite::resource:TM/Database.db");


					String sql="SELECT * from login WHERE username=? and ans=?";
					PreparedStatement pst=dbc.prepareStatement(sql);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					ResultSet rs=pst.executeQuery();
					if(!rs.next())
					{
							flag=0;
							lblNewLabel_6.setText("Answer is incorrect");
					}
					if(!(textField_2.getText().equals(textField_3.getText())))
					{
						flag=0;
						lblNewLabel_6.setText("Make sure passwords match");
				    }
					if(textField_2.getText().length()<8)
					{
						flag=0;
						lblNewLabel_6.setText("Password should be atleast 8 characters");
				    }
					if(flag==1)
					{
						sql="UPDATE login SET password=? WHERE username=?";
						pst=dbc.prepareStatement(sql);
						pst.setString(1,textField_2.getText());
						pst.setString(2,textField.getText());
						pst.execute();
						lblNewLabel_6.setText("");
						JOptionPane.showMessageDialog(null,"Password updated!","Success",JOptionPane.INFORMATION_MESSAGE);
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
