import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;

public class ttttttt extends JFrame {
	
	eltask tk = new eltask();

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ttttttt frame = new ttttttt();
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
	public ttttttt() {
		setTitle("Task Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
				
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 512, 439);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("    Get Process ID");
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(0, 0, 512, 49);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("   Enter Process Name");
		lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(0, 63, 171, 49);
		panel_2.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(158, 74, 176, 31);
		//tk.getprocessID(proName);
		//String proName = textField_1.getText();
		
		
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTheProcessName = new JLabel("   The Process ID is");
		lblTheProcessName.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblTheProcessName.setBounds(0, 138, 171, 49);
		panel_2.add(lblTheProcessName);
		
		JLabel lblStartProcess = new JLabel("    Start Process ");
		lblStartProcess.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblStartProcess.setBounds(0, 222, 512, 49);
		panel_2.add(lblStartProcess);
		
		JLabel lblEnterProcessId = new JLabel("   Enter Process Id");
		lblEnterProcessId.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblEnterProcessId.setBounds(0, 285, 171, 49);
		panel_2.add(lblEnterProcessId);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(158, 296, 176, 31);
		String prooName = textField_2.getText();
		
		
		
		panel_2.add(textField_2);
		
		
		
		JLabel lblTheProcessName_1 = new JLabel("   The State is");
		lblTheProcessName_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblTheProcessName_1.setBounds(0, 359, 171, 49);
		panel_2.add(lblTheProcessName_1);
		
		JLabel label = new JLabel("");
		
		label.setBounds(168, 117, 151, 49);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(168, 339, 171, 39);
		
			panel_2.add(label_1);
			
			JButton btnNewButton_1 = new JButton("Submit");
			btnNewButton_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				    String proName = textField_1.getText();
					String newProId = null;
					try {
						newProId = tk.getprocessID(proName);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					label.setText(newProId);
				}
			});
			btnNewButton_1.setBounds(363, 75, 117, 25);
			panel_2.add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("Submit");
			btnNewButton_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String proId = textField_2.getText();
					try {
						boolean state = tk.startproccess(proId);
						if( state == true )
						{
							label_1.setText("done");
						}else
						{
							label_1.setText("can't be done");
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_2.setBounds(363, 297, 117, 25);
			panel_2.add(btnNewButton_2);
			
			JButton btnNewButton_4 = new JButton("Home");
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnNewButton_4.setBounds(363, 378, 137, 49);
			panel_2.add(btnNewButton_4);
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 512, 439);
		contentPane.add(panel);
		panel.setVisible(false);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   UserId            PID            Stime            UpTime            CMD");
		lblNewLabel.setBounds(0, 0, 512, 43);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		
		JList list = new JList();
		list.setBounds(10, 45, 492, 340);
		panel.add(list);
		
		JButton btnKill = new JButton("Kill");
		btnKill.setBounds(411, 397, 89, 34);
		btnKill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		JLabel label_2 = new JLabel("");
		label_2.setBounds(261, 381, 89, 34);
		panel.add(label_2);
		btnKill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if ( textField.getText() != "" ||  textField.getText() != null  )
				{
					String proId = textField.getText();
					try {
						boolean state2 = tk.killprocess(proId);
						if( state2 == true ) 
						{
							label_2.setText("Done");
						}else
						{
							label_2.setText("Process can't be done");
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		panel.add(btnKill);
		btnKill.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		
		textField = new JTextField();
		textField.setBounds(153, 396, 100, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter pro id to kill ");

		lblNewLabel_1.setBounds(0, 396, 502, 43);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		
		JButton btnNewButton_3 = new JButton("Home");
		btnNewButton_3.setBounds(321, 394, 78, 43);
		panel.add(btnNewButton_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 512, 439);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("                                   Choose an operation ");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(0, 0, 512, 55);
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Show Process");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnNewButton.setBounds(81, 153, 133, 48);
		panel_1.add(btnNewButton);
		
		JButton btnKillProccess = new JButton("kill Process");
		btnKillProccess.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnKillProccess.setBounds(315, 153, 133, 48);
		panel_1.add(btnKillProccess);
		
		JButton btnStartProccess = new JButton("Start Process");
		btnStartProccess.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnStartProccess.setBounds(81, 257, 133, 48);
		panel_1.add(btnStartProccess);
		
		JButton btnGetProccessId = new JButton("Get Process ID");
		btnGetProccessId.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnGetProccessId.setBounds(315, 257, 133, 48);
		panel_1.add(btnGetProccessId);
		String proId = "hi";
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2.setVisible(false);
				panel_1.setVisible(false);
				panel.setVisible(true);	
				try {
					tk.showproccess();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				ArrayList<String> UID    = tk.getUID();
				ArrayList<String> PID    = tk.getPID();
				ArrayList<String> Stime  = tk.getStime();
				ArrayList<String> UpTime = tk.getUpTime();
				ArrayList<String> CMD    = tk.getCMD();
				int y = PID.size();
				String row[] = new String[y];
				// TODO Auto-generated catch block
				System.out.println(y);
				System.out.println(UID.size());
				
				for( int i = 0 ; i < y ; ++i )
				{
					row[i] = (UID.get(i) + "          " +PID.get(i)+ "          " +Stime.get(i)+ "          " +UpTime.get(i)+ "          " +CMD.get(i));
				}
				
				list.setModel(new AbstractListModel() {
					String[] values = row;
					public int getSize() {
						return values.length;
					}
					public Object getElementAt(int index) {
						return values[index];
					}
				});
			}
		});
		btnKillProccess.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2.setVisible(false);
				panel_1.setVisible(false);
				panel.setVisible(true);
				try {
					tk.showproccess();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				ArrayList<String> UID    = tk.getUID();
				ArrayList<String> PID    = tk.getPID();
				ArrayList<String> Stime  = tk.getStime();
				ArrayList<String> UpTime = tk.getUpTime();
				ArrayList<String> CMD    = tk.getCMD();
				int y = PID.size();
				String row[] = new String[y];
				// TODO Auto-generated catch block
				System.out.println(y);
				System.out.println(UID.size());
				
				for( int i = 0 ; i < y ; ++i )
				{
					row[i] = (UID.get(i) + "          " +PID.get(i)+ "          " +Stime.get(i)+ "          " +UpTime.get(i)+ "          " +CMD.get(i));
				}
				
				list.setModel(new AbstractListModel() {
					String[] values = row;
					public int getSize() {
						return values.length;
					}
					public Object getElementAt(int index) {
						return values[index];
					}
				});
			}
		});
		btnStartProccess.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2.setVisible(true);
				panel_1.setVisible(false);
				panel.setVisible(false);
			}
		});
		btnGetProccessId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2.setVisible(true);
				panel_1.setVisible(false);
				panel.setVisible(false);
			}
		});
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setVisible(false);
				panel_2.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setVisible(false);
				panel_2.setVisible(false);
				panel_1.setVisible(true);
			}
		});
	}
}
