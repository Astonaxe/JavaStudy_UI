package Gugudan;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class GugudanPlay extends JFrame {

	private JPanel contentPane;
	private JTextField dan1;
	private JTextField dan2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GugudanPlay frame = new GugudanPlay();
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
	public GugudanPlay() {
		setResizable(false);
		setTitle("GuGuDan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 221, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 6, 210, 355);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		dan1 = new JTextField();
		dan1.setHorizontalAlignment(SwingConstants.CENTER);
		dan1.setBounds(5, 366, 107, 26);
		contentPane.add(dan1);
		dan1.setColumns(10);
		
		dan2 = new JTextField();
		dan2.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		dan2.setHorizontalAlignment(SwingConstants.CENTER);
		dan2.setColumns(10);
		dan2.setBounds(108, 366, 107, 26);
		contentPane.add(dan2);
		
		JButton btnNewButton = new JButton("Gugudan");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String st1 = dan1.getText(); //JTextField는 String으로 구성되어 있다. 
				String st2 = dan2.getText();
				
				if(st2.equals("")&& st1.equals("")){ // equals 물어보다 
					textArea.append("값을 입력하세요");
					return; // 요류가 안남 
				}else if(st1.equals("")) {
					textArea.append("첫 번째 칸에 단을 입력하세요");
					dan1.requestFocus(); // 커서를 입력 커서에 갔다 놓는 장치 
					return;
					
				}
				else if(st2.equals("")) {
					textArea.append("두 번째 칸에 단을 입력하세요");
					dan2.requestFocus();
					return;
				} // int 로 변환하기 전에 조건문을 이용해서 확인 
				
				
				int dan = Integer.parseInt(st1); // String st1 -> 정수 형으로 변경해주는 
				int num = Integer.parseInt(st2);
				
				textArea.setText("");
				textArea.append("===================\n");
				textArea.append(dan+"단~"+num+"단까지\n");
				textArea.append("===================\n");
				
				
				if(dan>num){
				 textArea.append("첫 번째 칸에 단이 \n두 번째 단 보다 큽니다. ");
				 dan1.requestFocus();
				 return;
				}
				
				for(int i=dan; i<= num; i++){
				
					textArea.append("************( "+i+"단 )************\n");
			
					for(int x = 1; x <= 9; x++){
						textArea.append(i+"X"+x+"="+i*x+"\n");
						
					}
				}
				
				
			}
		});
		
		
		
		
		btnNewButton.setBounds(5, 394, 210, 29);
		contentPane.add(btnNewButton);
		
		JButton btnClean = new JButton("Clean");
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				dan1.setText("");
				dan2.setText("");
			}
		});
		btnClean.setBounds(5, 423, 210, 29);
		contentPane.add(btnClean);
	}
}
