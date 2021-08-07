package MedOut;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainMenu extends JFrame {
	
static String name;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String n) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					name=n;
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	static String getname()
	{
		return name;
	}

	 /**
	 * Create the frame.
	 */

	public MainMenu() {
		setTitle("Medical Outlet Management System");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenu.class.getResource("/MedOut/drug_shop-512.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 458);
		Connection dbc;
		
		try {
			dbc = DriverManager.getConnection("jdbc:sqlite::resource:MedOut/Database.db");
			PreparedStatement prep=dbc.prepareStatement("SELECT fs FROM settings");
			ResultSet res=prep.executeQuery();
			while(res.next())
			{
				if(res.getInt("fs")==1)
				{
					setExtendedState(JFrame.MAXIMIZED_BOTH);
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setUndecorated(true);
					setVisible(true);
				}
					
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 2));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(50,120));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setPreferredSize(new Dimension(200,50));
		panel.add(panel_2, BorderLayout.WEST);
		
		JLabel Medlogo = new JLabel("");
		Medlogo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(Medlogo);
		Medlogo.setBounds(0,0,200,200);
		//Medlogo.setIcon(new ImageIcon(MainMenu.class.getResource("/MedOut/drug_shop-512.png")));
		Medlogo.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/MedOut/drug_shop-512.png")).getImage().getScaledInstance(120,120, Image.SCALE_SMOOTH)));
		
		JLabel lblNewLabel_6 = new JLabel("Logged in as:"+name);
		lblNewLabel_6.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(lblNewLabel_6, BorderLayout.EAST);
		JPanel panel1=new JPanel();
		panel1.setBackground(Color.RED);
		panel1.setBorder(null);
		panel1.setPreferredSize(new Dimension(200,50));
		contentPane.add(panel1, BorderLayout.WEST);
		panel1.setLayout(null);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 200, 300);
		panel_1.setBorder(null);
		panel_1.setBackground(Color.RED);
		panel_1.setPreferredSize(new Dimension(200, 300));
		panel1.add(panel_1);
		panel_1.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel SalesOpt = new JPanel();
		SalesOpt.setBackground(Color.RED);
		panel_1.add(SalesOpt);
		SalesOpt.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("SALES");
		lblNewLabel.setForeground(Color.WHITE);
		//lblNewLabel.setIcon(new ImageIcon(MainMenu.class.getResource("/MedOut/cvs-health-payor-solutions-measuring-success-main-image_0.png")));
		lblNewLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/MedOut/cvs-health-payor-solutions-measuring-success-main-image_0.png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH)));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SalesOpt.add(lblNewLabel);
		
		JPanel InventoryOpt = new JPanel();
		InventoryOpt.setBackground(Color.RED);
		panel_1.add(InventoryOpt);
		InventoryOpt.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("INVENTORY");
		//lblNewLabel_1.setIcon(new ImageIcon(MainMenu.class.getResource("/MedOut/6639703_preview.png")));
		lblNewLabel_1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/MedOut/6639703_preview.png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH)));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		InventoryOpt.add(lblNewLabel_1);
		
		JPanel CompanyOpt = new JPanel();
		CompanyOpt.setBackground(Color.RED);
		panel_1.add(CompanyOpt);
		CompanyOpt.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("COMPANIES");
		//lblNewLabel_2.setIcon(new ImageIcon(MainMenu.class.getResource("/MedOut/building-icon-company-building-png-png-256_256.png")));
		lblNewLabel_2.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/MedOut/building-icon-company-building-png-png-256_256.png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH)));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		CompanyOpt.add(lblNewLabel_2);
		
		JPanel UsersOpt = new JPanel();
		UsersOpt.setBackground(Color.RED);
		panel_1.add(UsersOpt);
		UsersOpt.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("USERS");
		//lblNewLabel_3.setIcon(new ImageIcon(MainMenu.class.getResource("/MedOut/multy-user.png")));
		lblNewLabel_3.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/MedOut/multy-user.png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH)));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 20));
		UsersOpt.add(lblNewLabel_3);
		
		JPanel SettingsOpt = new JPanel();
		SettingsOpt.setBackground(Color.RED);
		panel_1.add(SettingsOpt);
		SettingsOpt.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("SETTINGS");
		//lblNewLabel_4.setIcon(new ImageIcon(MainMenu.class.getResource("/MedOut/settings.png")));
		lblNewLabel_4.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/MedOut/settings.png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH)));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
		SettingsOpt.add(lblNewLabel_4);
		
		JPanel Logout = new JPanel();
		Logout.setBackground(Color.RED);
		panel_1.add(Logout);
		Logout.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("LOGOUT");
		//lblNewLabel_5.setIcon(new ImageIcon(MainMenu.class.getResource("/MedOut/25706.png")));
		lblNewLabel_5.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/MedOut/25706.png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH)));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 20));
		Logout.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("Select an option to get started");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_7.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel_7, BorderLayout.CENTER);
		InventoryPanel ip=new InventoryPanel();
		CompanyPanel cp=new CompanyPanel();
		SalesPanel sp=new SalesPanel();
		UsersPanel up=new UsersPanel();
		Settings s=new Settings();
		if(!(name.equals("admin")))
			UsersOpt.disable();
		
		SalesOpt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_7.setVisible(false);
				contentPane.add(sp, BorderLayout.CENTER);
				sp.setVisible(false);
				ip.setVisible(false);
				cp.setVisible(false);
				up.setVisible(false);
				s.setVisible(false);
				sp.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				SalesOpt.setBackground(new Color(220, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				SalesOpt.setBackground(Color.RED);
			}
		});
		InventoryOpt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_7.setVisible(false);
				contentPane.add(ip,BorderLayout.CENTER);
				cp.setVisible(false);
				sp.setVisible(false);
				up.setVisible(false);
				ip.setVisible(false);
				s.setVisible(false);
				ip.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				InventoryOpt.setBackground(new Color(220, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				InventoryOpt.setBackground(Color.RED);
			}
		});
		UsersOpt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!(name.equals("admin")))
					JOptionPane.showMessageDialog(null,"Only admin can access this option","Access Restricted",JOptionPane.INFORMATION_MESSAGE);
				else {
					lblNewLabel_7.setVisible(false);
				contentPane.add(up,BorderLayout.CENTER);
				cp.setVisible(false);
				sp.setVisible(false);
				ip.setVisible(false);
				up.setVisible(false);
				s.setVisible(false);
				up.setVisible(true);
				}}
			@Override
			public void mouseEntered(MouseEvent e) {
				UsersOpt.setBackground(new Color(220, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				UsersOpt.setBackground(Color.RED);
			}
		});
		SettingsOpt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!(name.equals("admin")))
					JOptionPane.showMessageDialog(null,"Only admin can access this option","Access Restricted",JOptionPane.INFORMATION_MESSAGE);
				else {
					lblNewLabel_7.setVisible(false);
				cp.setVisible(false);
				sp.setVisible(false);
				ip.setVisible(false);
				up.setVisible(false);
				s.setVisible(true);
				contentPane.add(s,BorderLayout.CENTER);
			}
				}
			@Override
			public void mouseEntered(MouseEvent e) {
				SettingsOpt.setBackground(new Color(220, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				SettingsOpt.setBackground(Color.RED);
			}
		});
		Logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result=JOptionPane.showConfirmDialog(null,"Are you sure you want to logout?","Logout",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(result==JOptionPane.YES_OPTION)
					{Login.main(null);
					dispose();}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Logout.setBackground(new Color(220, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Logout.setBackground(Color.RED);
			}
		});
		CompanyOpt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_7.setVisible(false);
				contentPane.add(cp,BorderLayout.CENTER);
				ip.setVisible(false);
				up.setVisible(false);
				sp.setVisible(false);
				cp.setVisible(false);
				s.setVisible(false);
				cp.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				CompanyOpt.setBackground(new Color(220, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				CompanyOpt.setBackground(Color.RED);
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_7.setVisible(false);
			}
		});
	}

}
