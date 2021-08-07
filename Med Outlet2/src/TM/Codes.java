package TM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Codes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Codes frame = new Codes();
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
	public Codes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Codes.class.getResource("/TM/check.png")));
		setTitle("Alternative admin passwords");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Admin alternate passwords(Please save):");
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JTextArea textArea = new JTextArea();
		contentPane.add(textArea, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setPreferredSize(new Dimension(100,40));
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Generate new");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(null);
				for(int i=1;i<7;i++)
				{
				String str=getAlphaNumericString(8);
				textArea.append(str);
				textArea.append("\n");
				}
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save");
		panel.add(btnNewButton_1);
	}
	static String getAlphaNumericString(int n) 
    { 
  
        // lower limit for LowerCase Letters 
        int lowerLimit = 97; 
  
        // lower limit for LowerCase Letters 
        int upperLimit = 122; 
  
        Random random = new Random(); 
  
        // Create a StringBuffer to store the result 
        StringBuffer r = new StringBuffer(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // take a random value between 97 and 122 
            int nextRandomChar = lowerLimit 
                                 + (int)(random.nextFloat() 
                                         * (upperLimit - lowerLimit + 1)); 
  
            // append a character at the end of bs 
            r.append((char)nextRandomChar); 
        } 
  
        // return the resultant string 
        return r.toString(); 
    } 
}
