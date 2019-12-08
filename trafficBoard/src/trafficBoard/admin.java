package trafficBoard;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class admin {

	JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin window = new admin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
//	
//	public void comboxfields() {
//		try {
//			String query = "select * from display ";
//			PreparedStatement pst1= connection.prepareStatement(query);
//			ResultSet rs1 = pst1.executeQuery();
//			while(rs1.next()) {
//				
//				comboBox_1.addItem(rs1.getString("lineNumber"));
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	
	Connection connection = null;
	private JLabel lblNewLabel3;
	private JLabel lblNewLabel2;
	private JButton btnNewButton;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnGoToDashboard;
	public admin() {
		initialize();
		connection = databaseConnection.dbConnector();
		//comboxfields();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(39, 221, 487, 38);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Message 1");
		lblNewLabel.setBounds(39, 45, 444, 38);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel3 = new JLabel("Message 3");
		lblNewLabel3.setBounds(39, 142, 444, 38);
		frame.getContentPane().add(lblNewLabel3);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {



				
				
				String Message = textField.getText();
				String Uppernew = Message.toUpperCase();

				
			
				
				int upperleng = Uppernew.length();
	
				if(upperleng >20) {
					JOptionPane optionPane = new JOptionPane("ErrorMsg", JOptionPane.ERROR_MESSAGE);    
					JDialog dialog = optionPane.createDialog("LENTH OF MESSAGE TOO LONG ");
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true);
					
					
				}
				else if(upperleng<= 20) {
					
					try {
						
						
						
						
						
				String query = "Update display set lineNumber='"+1 +"' , Message='"+Uppernew +"'  ";
				PreparedStatement pst = connection.prepareStatement(query);
				
				
				
				
				pst.execute();
				
				JOptionPane.showMessageDialog(null," Data Updated : ");
				
				pst.close();
							}
				
				catch (Exception e1) {
					e1.printStackTrace();
				
			} 
			
			
			
			}
		
			
			
				
			}
		});
		btnUpdate.setBounds(548, 227, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		lblNewLabel2 = new JLabel("Message 2");
		lblNewLabel2.setBounds(39, 93, 444, 38);
		frame.getContentPane().add(lblNewLabel2);
		
		btnNewButton = new JButton("load the Messages");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				

		 		

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
						
						
						lblNewLabel2.setText(rs2.getString("Message"));
						
						
						
					}
			
					pst2.close();
				

					
					String query3 = "select * from display3 where lineNumber=1 ";
					PreparedStatement pst3 = connection.prepareStatement(query3);
					
				//	pst3.setString(1, (String)comboBox_1.getSelectedItem());
					ResultSet rs3 = pst3.executeQuery();
					while(rs3.next()) {
						
						
						lblNewLabel3.setText(rs3.getString("Message"));
						
						
						
					}
			
					pst3.close();
				
				}
					
			catch(Exception e1){
				JOptionPane.showMessageDialog(null, e1);
				
			    }
			
		 	
			}
		});
		btnNewButton.setBounds(226, 11, 145, 23);
		frame.getContentPane().add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.setBounds(39, 297, 483, 38);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(39, 368, 478, 38);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				
				
				String Message = textField_3.getText();
				String Uppernew = Message.toUpperCase();

				
				int upperleng = Uppernew.length();
	
				if(upperleng >20) {
					JOptionPane optionPane = new JOptionPane("ErrorMsg", JOptionPane.ERROR_MESSAGE);    
					JDialog dialog = optionPane.createDialog("LENTH OF MESSAGE TOO LONG ");
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true);
					
					
				}
				else if(upperleng<= 20) {
					
					try {
						
						
						
				String query = "Update display3 set lineNumber='"+1 +"' , Message='"+Uppernew +"'  ";
				PreparedStatement pst = connection.prepareStatement(query);
				
				
				
				
				pst.execute();
				
				JOptionPane.showMessageDialog(null," Data Updated : ");
				
				pst.close();
							}
				
				catch (Exception e1) {
					e1.printStackTrace();
				
			} 
			
			
			
			}
		
			
			
				
			}
		});
		btnNewButton_2.setBounds(551, 376, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Clear");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				
				try {
					String clearMessage = "NO MESSGAGE TO DISPLAY";
					String query = "Update display set lineNumber='"+1 +"' , Message='"+ clearMessage +"'  ";
					PreparedStatement pst = connection.prepareStatement(query);
					
					
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null," Data Erased : ");
					
					pst.close();
					
			
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			
				
			
			
			}
		});
		btnNewButton_3.setBounds(536, 53, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Clear");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				



				
				try {
					String clearMessage = "NO MESSGAGE TO DISPLAY";
					String query = "Update display2 set lineNumber='"+1 +"' , Message='"+ clearMessage +"'  ";
					PreparedStatement pst = connection.prepareStatement(query);
					
					
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null," Data Erased : ");
					
					pst.close();
					
			
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			
				
			
			
			
			}
		});
		btnNewButton_4.setBounds(536, 101, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("Clear");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				try {
					String clearMessage = "NO MESSGAGE TO DISPLAY";
					String query = "Update display3 set lineNumber='"+1 +"' , Message='"+ clearMessage +"'  ";
					PreparedStatement pst = connection.prepareStatement(query);
					
					
					
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null," Data Erased : ");
					
					pst.close();
					
			
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			
				
			
			
			
			}
		});
		btnNewButton_5.setBounds(536, 150, 89, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		btnGoToDashboard = new JButton("GO TO DASHBOARD");
		btnGoToDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					frame.setVisible(false);
					
					Dashboard frame1 = new Dashboard();
					frame1.setVisible(true);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnGoToDashboard.setBounds(410, 427, 182, 23);
		frame.getContentPane().add(btnGoToDashboard);
		
		JLabel lblMessage = new JLabel("Message 1");
		lblMessage.setBounds(39, 201, 94, 14);
		frame.getContentPane().add(lblMessage);
		
		JLabel lblMessage_1 = new JLabel("Message 2");
		lblMessage_1.setBounds(39, 270, 79, 14);
		frame.getContentPane().add(lblMessage_1);
		
		JLabel lblMessage_2 = new JLabel("Message 3");
		lblMessage_2.setBounds(39, 346, 79, 14);
		frame.getContentPane().add(lblMessage_2);
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				
				
				String Messages = textField_2.getText();
				String Uppernews = Messages.toUpperCase();

				
				int upperlengs = Uppernews.length();
	
				if(upperlengs >20) {
					JOptionPane optionPane = new JOptionPane("ErrorMsg", JOptionPane.ERROR_MESSAGE);    
					JDialog dialog = optionPane.createDialog("LENTH OF MESSAGE TOO LONG ");
					dialog.setAlwaysOnTop(true);
					dialog.setVisible(true);
					
					
				}
				else if(upperlengs<= 20) {
					
					try {
						
						
						
				String query = "Update display2 set lineNumber='"+1 +"' , Message='"+Uppernews +"'  ";
				PreparedStatement pst = connection.prepareStatement(query);
				
				
				
				
				pst.execute();
				
				JOptionPane.showMessageDialog(null," Data Updated : ");
				
				pst.close();
							}
				
				catch (Exception e1) {
					e1.printStackTrace();
				
			} 
			
			
			
			}
		
			
			}
		});
		btnUpdate_1.setBounds(548, 305, 89, 23);
		frame.getContentPane().add(btnUpdate_1);
	}
}
