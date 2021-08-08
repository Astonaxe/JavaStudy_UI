package Lesson01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;

public class test extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
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
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 17, 353, 183);
		contentPane.add(scrollPane);
		
		
		String header[] = {"학생","번호","성별","주소"};
		String contents[][] = {
				{"백인환","010-2","남","하남"},
				{"홍길동","99099","남","하남"},
				{"홍길동","99099","남","하남"},
				{"홍길동","99099","남","하남"},
		};
		
		
		table = new JTable(contents, header);
		table.setFont(new Font("Damascus", Font.PLAIN, 9));
		table.setForeground(Color.GREEN);
		table.setBackground(Color.BLACK);
		scrollPane.setViewportView(table);
	}
}
