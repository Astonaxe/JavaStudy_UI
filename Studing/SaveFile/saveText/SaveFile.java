package saveText;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SaveFile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaveFile frame = new SaveFile();
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
	public SaveFile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 227, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 215, 214);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("Save as");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fs = new JFileChooser(new File("bih:\\")); 
				fs.setDialogTitle("Save a file"); // 이름 
				fs.setFileFilter(new FileTypeFilter(".text","text File"));
				fs.setFileFilter(new FileTypeFilter(".png","png File"));
				fs.setFileFilter(new FileTypeFilter(".pdf","pdf File"));


				int result = fs.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION){
					String content = textArea.getText();
					File fi = fs.getSelectedFile();
					try {
						FileWriter fw = new FileWriter(fi.getPath());
						fw.write(content);
						fw.flush();
						fw.close();
					}catch(Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
				}
			}
		});
		btnNewButton.setBounds(5, 226, 215, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Open");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fs = new JFileChooser(new File("C:\\"));
				fs.setDialogTitle("Open a File");
				fs.setFileFilter(new FileTypeFilter(".text","Text File"));
				fs.setFileFilter(new FileTypeFilter(".docx","Word File"));
				fs.setFileFilter(new FileTypeFilter(".jpg","JPEG File"));
				int result = fs.showOpenDialog(null);
				if(result == JFileChooser.APPROVE_OPTION){
					try {
						File fi = fs.getSelectedFile();
						BufferedReader br = new BufferedReader(new FileReader(fi.getPath()));
						String line ="";
						String s = "";
						while((line= br.readLine()) != null) {
							s +=line;
						}
						textArea.setText(s);
						if(br != null) {
							br.close();
						}
					}catch(Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}

					
				}
			}
		});
		btnNewButton_1.setBounds(5, 251, 215, 29);
		contentPane.add(btnNewButton_1);
	}
}
