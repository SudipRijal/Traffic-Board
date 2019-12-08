package trafficBoard;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

public class Dashboard extends JFrame {

	JFrame frame;
	private JPanel contentPane;
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	private JButton btnLoad;

	public Dashboard() {
		connection = databaseConnection.dbConnector();
		frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					frame.dispose();
					
					admin window = new admin();
					window.frame.setVisible(true);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(34, 427, 89, 23);
		contentPane.add(btnNewButton);
		
		 lblNewLabel = new JLabel("LINE ONE");
		 lblNewLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 35));
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBounds(77, 68, 510, 56);
		contentPane.add(lblNewLabel);
		
		 lblNewLabel_1 = new JLabel("LINE TWO");
		 lblNewLabel_1.setBackground(Color.BLACK);
		 lblNewLabel_1.setFont(new Font("OCR A Extended", Font.PLAIN, 35));
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setBounds(77, 160, 510, 56);
		contentPane.add(lblNewLabel_1);
		
		 lblNewLabel_2 = new JLabel("LINE THREE");
		 lblNewLabel_2.setFont(new Font("OCR A Extended", Font.PLAIN, 35));
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setBounds(77, 259, 510, 56);
		contentPane.add(lblNewLabel_2);
		
		btnLoad = new JButton("LOAD");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				
				

		 		

				try {
					
					String query = "select * from display where lineNumber=1 ";
					PreparedStatement pst = connection.prepareStatement(query);
					
					//pst.setString(1, (String)comboBox_1.getSelectedItem());
					ResultSet rs = pst.executeQuery();
					while(rs.next()) {
						
						
						lblNewLabel.setText(rs.getString("Message"));
						
						
						
					}
			
					pst.close();
					
					

					
					String query2 = "select * from display2 where lineNumber=1 ";
					PreparedStatement pst2 = connection.prepareStatement(query2);
					
				//	pst2.setString(1, (String)comboBox_1.getSelectedItem());
					ResultSet rs2 = pst2.executeQuery();
					while(rs2.next()) {
						
						
						lblNewLabel_1.setText(rs2.getString("Message"));
						
						
						
					}
			
					pst2.close();
				

					
					String query3 = "select * from display3 where lineNumber=1 ";
					PreparedStatement pst3 = connection.prepareStatement(query3);
					
				//	pst3.setString(1, (String)comboBox_1.getSelectedItem());
					ResultSet rs3 = pst3.executeQuery();
					while(rs3.next()) {
						
						
						lblNewLabel_2.setText(rs3.getString("Message"));
						
						
						
					}
			
					pst3.close();
				
				}
					
			catch(Exception e1){
				JOptionPane.showMessageDialog(null, e1);
				
			    }
			
		 	
			
				
				
			
			
			}
		});
		btnLoad.setBounds(264, 11, 142, 41);
		contentPane.add(btnLoad);
	}
}
