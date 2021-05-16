package phase2;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class GUI {

	static CardLayout c = new CardLayout();
	static JFrame frame = new JFrame();
	static JPanel mainPanel = new JPanel();
	
	static JPanel insertPanel = new JPanel();
	static JPanel singleInsertPanel = new JPanel();
	static JPanel multiPanel = new JPanel();
	static JPanel loadPanel = new JPanel();
	
	static JPanel deletePanel = new JPanel();
	static JPanel retrievePanel = new JPanel();
	static JPanel maxPanel = new JPanel();
	static JPanel retrieveTable = new JPanel();
	
	static String MAIN = "Main panel";
	static String INSERT = "Insert Data panel";
	static String SINGLEINSERT = "Single Insertion panel";
	static String MULTIROW = "Multi Row Insertion panel";
	static String LOADDATA = "Load Data panel";
	static String DELETE = "Delete panel";
	static String RETRIEVE = "Retrieve All Data panel";
	static String MAX = "Max panel";
	static String TABLE = "Retrieve all Table";
	
	static JPanel cards = new JPanel(c);	
	static Connection conn;
	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nfl", "root", "Poregman215424game");
		// System.out.println("Connected");
		} catch (Exception e) {
			
		}
		
		frame.setLayout(c);
		frame.setSize(500, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		mainPanel.setLayout(null);
		insertPanel.setLayout(null);
		singleInsertPanel.setLayout(null);
		multiPanel.setLayout(null);
		loadPanel.setLayout(null);
		deletePanel.setLayout(null);
		retrievePanel.setLayout(null);
		maxPanel.setLayout(null);
		retrieveTable.setLayout(null);
		
		// MAIN PANEL SETUP
		JLabel openMsg = new JLabel("NFL Database");
		openMsg.setBounds(208, 20, 300, 25);
		mainPanel.add(openMsg);
		
		JButton insertDataBtn = new JButton("Insert Data");
		insertDataBtn.setBounds(140, 60, 100, 25);
		mainPanel.add(insertDataBtn);
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(250, 60, 100, 25);
		mainPanel.add(deleteBtn);
		
		JButton retrieveBtn = new JButton("Retrieve All");
		retrieveBtn.setBounds(140, 110, 100, 25);
		mainPanel.add(retrieveBtn);
		
		JButton maxBtn = new JButton("Max");
		maxBtn.setBounds(250, 110, 100, 25);
		mainPanel.add(maxBtn);
		
		// INSERT PANEL SETUP
		JButton singleInsertionBtn = new JButton("Single Insertion");
		singleInsertionBtn.setBounds(175, 60, 170, 25);
		insertPanel.add(singleInsertionBtn);
		
		JButton multiRowBtn = new JButton("Multiple-Row Insertion");
		multiRowBtn.setBounds(175, 95, 170, 25);
		insertPanel.add(multiRowBtn);
		
		JButton loadDataBtn = new JButton("Load Data");
		loadDataBtn.setBounds(175, 130, 170, 25);
		insertPanel.add(loadDataBtn);
		
		// Home Button Setup
		// Add to panels when panels are changed
		JButton home = new JButton("Home");
		home.setBounds(20, 20, 100, 25);
		home.setVisible(true);
		
		// Delete Panel Setup
		JLabel tablePrompt = new JLabel("Provide the name of the table you wish to delete rows from");
		tablePrompt.setBounds(100, 60, 400, 25);
		deletePanel.add(tablePrompt);
		
		JTextField tableField = new JTextField(20);
		tableField.setBounds(100, 90, 100, 25 );
		deletePanel.add(tableField);
		
		JButton go = new JButton("Go");
		go.setBounds(220, 90, 70, 25);
		deletePanel.add(go);
		
		// Max Panel Setup
		JLabel tablePrompt2 = new JLabel("Provide the name of the table");
		tablePrompt2.setBounds(100, 60, 300, 25);
		
		JTextField tableField2 = new JTextField(20);
		tableField2.setBounds(100, 90, 100, 25 );
		
		JLabel tablePrompt3 = new JLabel("Provide the name of the table");
		tablePrompt3.setBounds(100, 60, 300, 25);
		
		JTextField tableField3 = new JTextField(20);
		tableField3.setBounds(100, 90, 100, 25 );
		
		JLabel columnPrompt = new JLabel("Provide the name of the column");
		columnPrompt.setBounds(100, 120, 300, 25);
		maxPanel.add(columnPrompt);
		
		JTextField columnField = new JTextField(20);
		columnField.setBounds(100, 150, 100, 25 );
		maxPanel.add(columnField);
		
		JButton go2 = new JButton("Go");
		go2.setBounds(100, 180, 70, 25);
		maxPanel.add(go2);
		
		JLabel maxLabel = new JLabel();
		
		// Retrieve Panel Setup
		
		JButton go3 = new JButton("Go");
		go3.setBounds(220, 90, 70, 25);
		retrievePanel.add(go3);
		
		
		// Complete Label
		JLabel complete = new JLabel("Completed");
		complete.setBounds(208, 140, 300, 25);
		deletePanel.add(complete);
		complete.setVisible(false);
		
		// Cards setup
		cards.add(mainPanel, MAIN);
		cards.add(insertPanel, INSERT);
		cards.add(singleInsertPanel, SINGLEINSERT);
		cards.add(multiPanel, MULTIROW);
		cards.add(loadPanel, LOADDATA);
		cards.add(deletePanel, DELETE);
		cards.add(retrievePanel, RETRIEVE);
		cards.add(maxPanel, MAX);
		cards.add(retrieveTable, TABLE);
		
		frame.add(cards);
		frame.setVisible(true);
		home.setVisible(true);
		insertDataBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c1 = (CardLayout) frame.getContentPane().getLayout();
				c1.show(cards, INSERT);	
				insertPanel.add(home);
				frame.repaint();

			}
								
		});
		
		singleInsertionBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c1 = (CardLayout) frame.getContentPane().getLayout();
				c1.show(cards, SINGLEINSERT);
				singleInsertPanel.add(home);
				
				JFileChooser chooser = new JFileChooser();
				File file = null;
				
				int returnVal = chooser.showOpenDialog(mainPanel);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					file = chooser.getSelectedFile();
					
					String pathString = file.getPath();
					pathString = pathString.replace("\\", "/");
					//System.out.println(pathString); TESTING
					Path path = Paths.get(pathString);
					Charset charset = StandardCharsets.UTF_8;
					
					try {
						
						String content = new String(Files.readAllBytes(path), charset);
						content = content.replace(",QB,", ",'QB',");
						content = content.replace(",RB,", ",'RB',");
						content = content.replace(",WR,", ",'WR',");
						Files.write(path, content.getBytes(charset));
						
						BufferedReader br = new BufferedReader(new FileReader(file));
						String st;
						
						long start = System.currentTimeMillis();

						while((st = br.readLine()) != null) {
							String query = "insert into " + file.getName().replaceFirst("[.][^.]+$", "") + " values (" + st + ");";
							System.out.println(query); // For testing
							Statement stmt = conn.createStatement();
							stmt.executeUpdate(query);
							
						}
			
						long end = System.currentTimeMillis();
						long duration = (end - start);
						String temp = "<html>Insertion Completed.<br/>Time to insert: " + duration + " milliseconds<html>";
						JLabel time = new JLabel(temp);
						time.setBounds(180, 20, 200, 100);
						singleInsertPanel.add(time);
						frame.repaint();
						
					} catch (IOException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
				
			}
								
		});
		
		multiRowBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c1 = (CardLayout) frame.getContentPane().getLayout();
				c1.show(cards, MULTIROW);
				multiPanel.add(home);
				
				JFileChooser chooser = new JFileChooser();
				File file = null;
				
				int returnVal = chooser.showOpenDialog(mainPanel);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					file = chooser.getSelectedFile();
					
					String pathString = file.getPath();
					pathString = pathString.replace("\\", "/");
					//System.out.println(pathString); TESTING
					Path path = Paths.get(pathString);
					Charset charset = StandardCharsets.UTF_8;
					
					try {
						
						String content = new String(Files.readAllBytes(path), charset);
						content = content.replace(",QB,", ",'QB',");
						content = content.replace(",RB,", ",'RB',");
						content = content.replace(",WR,", ",'WR',");
						Files.write(path, content.getBytes(charset));
						
						BufferedReader br = new BufferedReader(new FileReader(file));
						String st;
						String query = "insert into " + file.getName().replaceFirst("[.][^.]+$", "") + " values ";
						while((st = br.readLine()) != null) {
							query = query + "(" + st + "),";
							//System.out.println(query); // For testing
							
						}
						query = query.substring(0, query.lastIndexOf(","));
						query = query + ";";
						
						Statement stmt = conn.createStatement();
						long start = System.currentTimeMillis();
						stmt.executeUpdate(query);
						long end = System.currentTimeMillis();
						long duration = (end - start);
						String temp = "<html>Insertion Completed.<br/>Time to insert: " + duration + " milliseconds<html>";
						JLabel time = new JLabel(temp);
						time.setBounds(180, 20, 200, 100);
						multiPanel.add(time);
						frame.repaint();
						
					} catch (IOException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
	
					
				}
			}
								
		});
		
		// Change text file before this. Position must be without ''
		loadDataBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c1 = (CardLayout) frame.getContentPane().getLayout();
				c1.show(cards, LOADDATA);
				loadPanel.add(home);
				
				JFileChooser chooser = new JFileChooser();
				File file = null;
				
				int returnVal = chooser.showOpenDialog(mainPanel);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					file = chooser.getSelectedFile();
					String pathString = file.getPath();
					pathString = pathString.replace("\\", "/");
					//System.out.println(pathString); TESTING
					Path path = Paths.get(pathString);
					Charset charset = StandardCharsets.UTF_8;
					
					try {
						
						String content = new String(Files.readAllBytes(path), charset);
						content = content.replace("'QB'", "QB");
						content = content.replace("'RB'", "RB");
						content = content.replace("'WR'", "WR");
						Files.write(path, content.getBytes(charset));
						
						BufferedReader br = new BufferedReader(new FileReader(file));
						String query = "load data infile '" + pathString + "' into table " + file.getName().replaceFirst("[.][^.]+$", "") + " fields terminated by ',';";
								//'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/" + file.getName() + "' into table " + file.getName().replaceFirst("[.][^.]+$", "") + " fields terminated by ',';";
						
						Statement stmt = conn.createStatement();
						long start = System.currentTimeMillis();
						stmt.executeUpdate(query);
						long end = System.currentTimeMillis();
						long duration = (end - start);
						String temp = "<html>Insertion Completed.<br/>Time to insert: " + duration + " milliseconds<html>";
						JLabel time = new JLabel(temp);
						time.setBounds(180, 20, 200, 100);
						loadPanel.add(time);
						frame.repaint();
						
					} catch (IOException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
	
					
				}
			}
								
		});
		
		deleteBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c1 = (CardLayout) frame.getContentPane().getLayout();
				c1.show(cards, DELETE);
				deletePanel.add(home);
			}
								
		});
		
		retrieveBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c1 = (CardLayout) frame.getContentPane().getLayout();
				c1.show(cards, RETRIEVE);
				retrievePanel.add(home);
				retrievePanel.add(tablePrompt3);
				retrievePanel.add(tableField3);
				
			}
								
		});
		
		maxBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c1 = (CardLayout) frame.getContentPane().getLayout();
				c1.show(cards, MAX);
				maxPanel.add(home);
				maxPanel.add(tablePrompt2);
				maxPanel.add(tableField2);
			}
								
		});
		
		home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c1 = (CardLayout) frame.getContentPane().getLayout();
				c1.show(cards, MAIN);
				complete.setVisible(false);
			}
								
		});
		
		
		go.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Statement stmt;
				try {
					stmt = conn.createStatement();
					String query = "delete from " + tableField.getText() + ";";
					stmt.executeUpdate(query);
					complete.setVisible(true);
					frame.repaint();
					
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				
			}
								
		});
		
		go2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Statement stmt;
				
				try {
					stmt = conn.createStatement();
					String query = "select max(" + columnField.getText() + ") from " + tableField2.getText() + ";";
					ResultSet result = stmt.executeQuery(query);
					// Print results using result set i believe
					result.next();
					String label = "Max: " + result.getInt(1);
					maxLabel.setText(label);
					maxLabel.setBounds(300, 60, 100, 25);
					maxPanel.add(maxLabel);
					frame.repaint();
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			}
								
		});
		
		go3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Statement stmt;
				try {
					stmt = conn.createStatement();
					String query = "select * from " + tableField3.getText() + ";";
					//System.out.println(query); //TEST
					ResultSet result = stmt.executeQuery(query);
					
					JTable table = new JTable(buildTable(result));
					retrieveTable.add(table);
					retrieveTable.add(home);
					
					CardLayout c1 = (CardLayout) frame.getContentPane().getLayout();
					c1.show(cards, TABLE);
					
					JOptionPane.showMessageDialog(null,  new JScrollPane(table));
					
					
					
					frame.repaint();
					
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				
			}
								
		});
		
		
	}

	public static DefaultTableModel buildTable(ResultSet result) throws SQLException{
		
		ResultSetMetaData meta = result.getMetaData();
		
		Vector<String> columns = new Vector<String>();
		int columnNumber = meta.getColumnCount();
		
		for(int column = 1; column <= columnNumber; column++) {
			columns.add(meta.getColumnName(column));
		}
		
		Vector<Vector<Object>> rows = new Vector<Vector<Object>>();
		while(result.next()) {
			Vector<Object> temp = new Vector<Object>();
			for(int index = 1; index <= columnNumber; index++) {
				temp.add(result.getObject(index));
			}
			rows.add(temp);
		}
		return new DefaultTableModel(rows, columns);
	}
	
}
