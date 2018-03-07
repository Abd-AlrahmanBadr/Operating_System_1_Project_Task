import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class maimpPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					maimpPage frame = new maimpPage();
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
	public maimpPage() {
		setTitle("Task Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 512, 439);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("                                   Choose an operation ");
		lblNewLabel.setBounds(0, 0, 512, 30);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		
		JButton btnNewButton = new JButton("Start Proccess");
		btnNewButton.setBounds(85, 117, 124, 41);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		JButton btnKillProcess = new JButton("Kill Proccess");
		btnKillProcess.setBounds(297, 219, 124, 41);
		panel.add(btnKillProcess);
		btnKillProcess.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		JButton btnShowProccess = new JButton("Show Proccess");
		btnShowProccess.setBounds(297, 117, 124, 41);
		panel.add(btnShowProccess);
		btnShowProccess.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		JButton btnGetProccessId = new JButton("Get Proccess ID");
		btnGetProccessId.setBounds(85, 218, 124, 41);
		panel.add(btnGetProccessId);
		btnGetProccessId.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
	}

}
