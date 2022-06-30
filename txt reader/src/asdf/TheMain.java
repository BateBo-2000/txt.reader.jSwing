
package asdf;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TheMain extends JFrame {

	 private JPanel contentPane;
	private JTextField loc;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TheMain frame = new TheMain();
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
	public TheMain() {
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// text field for the file location
		loc = new JTextField();
		loc.setForeground(Color.LIGHT_GRAY);
		loc.setBounds(125, 29, 299, 20);
		contentPane.add(loc);
		loc.setColumns(10);
		
		//label instructions
		JLabel lblTextFile = new JLabel("text file's location:");
		lblTextFile.setBounds(10, 32, 135, 14);
		contentPane.add(lblTextFile);
		
		//label name
		JLabel lblNewLabel = new JLabel("TEXT FILE READER");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		lblNewLabel.setBounds(115, 0, 200, 17);
		contentPane.add(lblNewLabel);
		
		// text area
		TextArea ans=new TextArea("");
		ans.setBounds(10,71,414,150);
		contentPane.add(ans);
		
		//copy button
		JButton btnCopy = new JButton("Copy");
		btnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
				
				clipboard.setContents(new StringSelection(ans.getText()), null);
			}
		});
		btnCopy.setForeground(Color.ORANGE);
		btnCopy.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCopy.setBounds(109, 227, 89, 23);
		contentPane.add(btnCopy);
		
		//clear button
		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(Color.ORANGE);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ans.setText("");
				loc.setText("");
			}
		});
		btnClear.setBounds(208, 227, 89, 23);
		contentPane.add(btnClear);
		
		//exit button
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setForeground(Color.ORANGE);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setBounds(335, 227, 89, 23);
		contentPane.add(btnExit);
		
		//read button
		JButton btnRead = new JButton("Read");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ans.setText(txt(loc.getText()));
				
				
				
				
			}
		});
		btnRead.setForeground(Color.ORANGE);
		btnRead.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRead.setBounds(10, 227, 89, 23);
		contentPane.add(btnRead);
		
		//lbl example
		JLabel lblexample = new JLabel("Example: C:\\Users\\PC\\Desktop\\file.txt");
		
		lblexample.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblexample.setBounds(125, 51, 299, 14);
		contentPane.add(lblexample);	
		
	//design
		//orange
		Color color=Color.ORANGE;
		
		//btn background
		contentPane.setBackground(Color.black);
		btnClear.setBackground(Color.black);
		btnExit.setBackground(Color.black);
		btnRead.setBackground(Color.black);
		btnCopy.setBackground(Color.black);
		
		//btn borders
		btnClear.setBorder(BorderFactory.createLineBorder(color,2));
		btnExit.setBorder(BorderFactory.createLineBorder(color,2));
		btnRead.setBorder(BorderFactory.createLineBorder(color,2));
		btnCopy.setBorder(BorderFactory.createLineBorder(color,2));
		
		// lbl foregrounds 
		lblNewLabel.setForeground(color);
		lblTextFile.setForeground(Color.cyan);
		lblexample.setForeground(color);
		
		// location design
		loc.setBackground(Color.DARK_GRAY);
		loc.setBorder(BorderFactory.createLineBorder(color,2));
		loc.setForeground(color);
		loc.isFontSet();
		//text area design
		ans.setForeground(color);
		ans.setBackground(Color.DARK_GRAY);
		ans.setFont(new Font("Tahoma", Font.BOLD, 11));
	
	}
	
	public static String txt(String path) {
		try {
			// test
			//path = "C:\\Users\\PC\\Desktop\\9à 4.txt";
			
			FileReader fr = new FileReader(path);
			BufferedReader br=new BufferedReader(fr);
			String text="";
			String s;
			 while ((s=br.readLine()) != null) {
			     text+=s+"\n";
			  }
			
			br.close();
			return text;
		} catch (Exception e1 ) {
			e1.printStackTrace();
			System.out.println("error reading");
			return "error reading txt";
		}
	}
	
	
	
	
}
