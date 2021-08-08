package Example;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class NextPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NextPage frame = new NextPage();
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
	public NextPage() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Page2 = new JPanel();
		Page2.setBounds(6, 6, 288, 207);
		contentPane.add(Page2);
		Page2.setLayout(null);
		Page2.setVisible(false); // Page를 안 보이게 하는 장치  
		
		JLabel lblEndPage = new JLabel("End Page");
		lblEndPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndPage.setBounds(6, 6, 276, 161);
		Page2.add(lblEndPage);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(6, 172, 117, 29);
		Page2.add(btnNewButton_2);
		
		JPanel Page1 = new JPanel();
		Page1.setBounds(6, 6, 288, 207);
		contentPane.add(Page1);
		Page1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Start Page");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 276, 195);
		Page1.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("<- Back");
		JButton btnNewButton_1 = new JButton("Next ->");
		
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page2.setVisible(false);
				Page1.setVisible(true);
				btnNewButton.setEnabled(false);
				btnNewButton_1.setEnabled(true);
			}
		});
		btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		btnNewButton.setBounds(6, 225, 145, 47);
		contentPane.add(btnNewButton);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Page2.setVisible(true);
				Page1.setVisible(false);
				btnNewButton.setEnabled(true);
				btnNewButton_1.setEnabled(false);
				
				
			}
		});
		btnNewButton_1.setBounds(154, 225, 145, 47);
		contentPane.add(btnNewButton_1);
	}
}
