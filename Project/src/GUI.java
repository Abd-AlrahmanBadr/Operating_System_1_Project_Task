import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class GUI extends JFrame {
	
	private JPanel contentPane;
	private JTextField NoProcessField;
	private ArrayList<JLabel> ProcessIDS = new ArrayList<JLabel>();
	private ArrayList<JTextField> ProcessArrivalTime = new ArrayList<JTextField>();
	private ArrayList<JTextField> ProcessBrustTime = new ArrayList<JTextField>();
	private ArrayList<JTextField> ProcessPriority = new ArrayList<JTextField>();
	private ArrayList<JPanel> ProcessPanel = new ArrayList<JPanel>(); 
	private final JButton btnAddData = new JButton("Add Process Data");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 447, 700);
		setBounds(100, 100, 357, 179);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel ResultPanel = new JPanel();
		ResultPanel.setBounds(10, 11, 411, 639);
		contentPane.add(ResultPanel);
		ResultPanel.setLayout(null);
		ResultPanel.setVisible(false);
		
		JList list = new JList();
		list.setBounds(10, 113, 391, 377);
		ResultPanel.add(list);
		
		JLabel lblAverageWaitingTime = new JLabel("Average Waiting Time : ");
		lblAverageWaitingTime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAverageWaitingTime.setBounds(10, 501, 163, 23);
		ResultPanel.add(lblAverageWaitingTime);
		
		JLabel lblAverageWaitingTimeResult = new JLabel("");
		lblAverageWaitingTimeResult.setBounds(183, 501, 157, 23);
		ResultPanel.add(lblAverageWaitingTimeResult);
		
		JLabel lblAverageWaitingTimeResultResult = new JLabel("");
		lblAverageWaitingTimeResultResult.setBounds(183, 535, 157, 23);
		ResultPanel.add(lblAverageWaitingTimeResultResult);
		
		JLabel lblAverageTurnaroundTime = new JLabel("Average Turnaround Time : ");
		lblAverageTurnaroundTime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAverageTurnaroundTime.setBounds(10, 535, 163, 23);
		ResultPanel.add(lblAverageTurnaroundTime);
		
		JLabel lblAverageResponseTimeResult = new JLabel("");
		lblAverageResponseTimeResult.setBounds(183, 569, 157, 23);
		ResultPanel.add(lblAverageResponseTimeResult);
		
		JLabel lblAverageResponseTime = new JLabel("Average Response Time : ");
		lblAverageResponseTime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAverageResponseTime.setBounds(10, 569, 163, 23);
		ResultPanel.add(lblAverageResponseTime);
		
		JButton btnRestart = new JButton("Restart");
		btnRestart.setBounds(161, 605, 89, 23);
		ResultPanel.add(btnRestart);
		
		JLabel lblProcessIDResult = new JLabel("Process ID");
		lblProcessIDResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblProcessIDResult.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProcessIDResult.setBounds(10, 72, 62, 30);
		ResultPanel.add(lblProcessIDResult);
		
		JLabel lblProcessWaitingTime = new JLabel("Waiting Time");
		lblProcessWaitingTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblProcessWaitingTime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProcessWaitingTime.setBounds(82, 72, 83, 30);
		ResultPanel.add(lblProcessWaitingTime);
		
		JLabel lblProcessTurnaroundTime = new JLabel("Turnaround Time");
		lblProcessTurnaroundTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblProcessTurnaroundTime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProcessTurnaroundTime.setBounds(175, 72, 101, 30);
		ResultPanel.add(lblProcessTurnaroundTime);
		
		JLabel lblResponseTime = new JLabel("Response Time");
		lblResponseTime.setBounds(286, 72, 89, 30);
		ResultPanel.add(lblResponseTime);
		lblResponseTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblResponseTime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblGanttChart = new JLabel("");
		lblGanttChart.setBounds(10, 29, 330, 23);
		ResultPanel.add(lblGanttChart);
		
		JPanel ProcessDataPanel = new JPanel();
		ProcessDataPanel.setBounds(10, 11, 350, 639);
		contentPane.add(ProcessDataPanel);
		ProcessDataPanel.setLayout(null);
		ProcessDataPanel.setVisible(false);
		
		JLabel lblProcessID = new JLabel("Process ID");
		lblProcessID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProcessID.setHorizontalAlignment(SwingConstants.CENTER);
		lblProcessID.setBounds(10, 11, 70, 30);
		ProcessDataPanel.add(lblProcessID);
		
		JLabel lblProcessArrivalTime = new JLabel("Arrival Time");
		lblProcessArrivalTime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProcessArrivalTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblProcessArrivalTime.setBounds(90, 11, 70, 30);
		ProcessDataPanel.add(lblProcessArrivalTime);
		
		JLabel lblProcessBrustTime = new JLabel("Brust Time");
		lblProcessBrustTime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProcessBrustTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblProcessBrustTime.setBounds(170, 11, 70, 30);
		ProcessDataPanel.add(lblProcessBrustTime);
		
		JLabel lblPriority = new JLabel("Priority");
		lblPriority.setHorizontalAlignment(SwingConstants.CENTER);
		lblPriority.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPriority.setBounds(250, 11, 70, 30);
		ProcessDataPanel.add(lblPriority);
		btnAddData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(ValidateProcessInput()){
					ResultPanel.setVisible(true);
					ProcessDataPanel.setVisible(false);
					setBounds(100, 100, 447, 700);
					////////////////////////////////////////////////
					int NoProcess;
					int TotalTime = 0;
					NoProcess = Integer.parseInt(NoProcessField.getText());
					
					ArrayList<Process> l = new ArrayList<Process>();
					ArrayList<Process> lTemp = new ArrayList<Process>();
					int minStart = 10000000;
					for(int i = 0;i < NoProcess;i++){
						int TempAriavalTime = Integer.parseInt(ProcessArrivalTime.get(i).getText());
						if(minStart > Integer.parseInt(ProcessArrivalTime.get(i).getText())){
							minStart = Integer.parseInt(ProcessArrivalTime.get(i).getText());
						}
						int TempBrustTime = Integer.parseInt(ProcessBrustTime.get(i).getText());
						TotalTime += Integer.parseInt(ProcessBrustTime.get(i).getText());
						int TempPriority = Integer.parseInt(ProcessPriority.get(i).getText());
						l.add(new Process(i+1, TempAriavalTime, TempBrustTime, TempPriority));
						lTemp.add(new Process(i+1, TempAriavalTime, TempBrustTime, TempPriority));
					}
					
					Collections.sort(l);
					
					ArrayList<Integer> GanttChart = new ArrayList<Integer>();
					ArrayList<Process> ReadyQueue = new ArrayList<Process>();
					for(int i = minStart,Counter = 0;i < TotalTime + minStart;i++){
						if(Counter < NoProcess && l.get(Counter).getArraivalTime() <= i){
							ReadyQueue.add(l.get(Counter));
							Counter++;
						}
						int CurrentWorkingProcessIndex = 0;
						for(int j = 1;j < ReadyQueue.size();j++){
							if(ReadyQueue.get(j).getPriority() < ReadyQueue.get(CurrentWorkingProcessIndex).getPriority()){
								CurrentWorkingProcessIndex = j;
							}else if(	ReadyQueue.get(j).getPriority() == ReadyQueue.get(CurrentWorkingProcessIndex).getPriority() &&
										ReadyQueue.get(j).getArraivalTime() < ReadyQueue.get(CurrentWorkingProcessIndex).getArraivalTime()){
								CurrentWorkingProcessIndex = j;
							}
						}
						ReadyQueue.get(CurrentWorkingProcessIndex).setBrustTime(ReadyQueue.get(CurrentWorkingProcessIndex).getBrustTime()-1);
						GanttChart.add(ReadyQueue.get(CurrentWorkingProcessIndex).getID());
						if(ReadyQueue.get(CurrentWorkingProcessIndex).getBrustTime() == 0){
							ReadyQueue.remove(CurrentWorkingProcessIndex);
						}
					}
					String GC = "";
					int Second = 0;
					for(int i = 0;i < TotalTime;){
						int CurrentProcess = GanttChart.get(i);
						GC += Integer.toString(i);
						while(i < TotalTime && GanttChart.get(i) == CurrentProcess) i++;
						GC += ("--P" + Integer.toString(GanttChart.get(i-1)) + "--");
					}
					GC += TotalTime;
					lblGanttChart.setText(GC);
					
					ArrayList<Integer> End = new ArrayList<Integer>();
					for(int i = 0;i < NoProcess;i++){
						End.add(0);
					}
					for(int i = 0;i < GanttChart.size();i++){
						if(End.get(GanttChart.get(i) - 1) < i)
							End.set(GanttChart.get(i) - 1, i);
					}
					ArrayList<Integer> Start = new ArrayList<Integer>();
					for(int i = 0;i < NoProcess;i++){
						Start.add((int) 1e9);
					}
					for(int i = 0;i < GanttChart.size();i++){
						if(Start.get(GanttChart.get(i) - 1) > i)
							Start.set(GanttChart.get(i) - 1, i);
					}
					ArrayList<Integer> ResponseTime = new ArrayList<Integer>();
					int TotalResponseTime = 0;
					for(int i = 0;i < NoProcess;i++){
						TotalResponseTime += (End.get(i) - Start.get(i) + 1);
						ResponseTime.add(End.get(i) - Start.get(i) + 1);
					}
					double AVGRT = (double)TotalResponseTime / (double)NoProcess;
					int WaitTimeTotal = 0;
					ArrayList<Integer> WaitTime = new ArrayList<Integer>();
					for(int i = 0;i < NoProcess;i++){
						WaitTimeTotal += (End.get(i) - lTemp.get(i).getArraivalTime() - lTemp.get(i).getBrustTime() + 1);
						WaitTime.add(End.get(i) - lTemp.get(i).getArraivalTime() - lTemp.get(i).getBrustTime() + 1);
					}
					double AVGWT = (double)WaitTimeTotal / (double)NoProcess;
					int TurnaroundTimeTotal = 0;
					ArrayList<Integer> TurnaroundTime = new ArrayList<Integer>();
					for(int i = 0;i < NoProcess;i++){
						TurnaroundTimeTotal += (End.get(i) - lTemp.get(i).getArraivalTime() + 1);
						TurnaroundTime.add((End.get(i) - lTemp.get(i).getArraivalTime() + 1));
					}
					double AVGTT = (double)TurnaroundTimeTotal / (double)NoProcess;
					
					String[] V = new String[NoProcess];
					for(int i = 0;i < NoProcess;i++){
						V[i] = "Process" + (i+1) + "                   " + WaitTime.get(i) + "                        " + TurnaroundTime.get(i) + "                        " + ResponseTime.get(i); 
					}
					list.setModel(new AbstractListModel() {
						String[] values = V;
						public int getSize() {
							return values.length;
						}
						public Object getElementAt(int index) {
							return values[index];
						}
					});
					lblAverageWaitingTimeResult.setText(Double.toString(AVGWT));
					lblAverageWaitingTimeResultResult.setText(Double.toString(AVGTT));
					lblAverageResponseTimeResult.setText(Double.toString(AVGRT));
				}
			}
		});
		btnAddData.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddData.setBounds(95, 597, 160, 31);
		ProcessDataPanel.add(btnAddData);
				
		JPanel NoProcessPanel = new JPanel();
		NoProcessPanel.setBounds(10, 11, 321, 118);
		contentPane.add(NoProcessPanel);
		NoProcessPanel.setLayout(null);
		
		JLabel lblNoProcess = new JLabel("No Process");
		lblNoProcess.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNoProcess.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoProcess.setBounds(10, 11, 88, 38);
		NoProcessPanel.add(lblNoProcess);
		
		NoProcessField = new JTextField();
		NoProcessField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		NoProcessField.setBounds(108, 12, 200, 38);
		NoProcessPanel.add(NoProcessField);
		NoProcessField.setColumns(10);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
					if(NoProcessField.getText() != "" && Integer.parseInt(NoProcessField.getText()) > 0){
						setBounds(100, 100, 400, 700);
						ProcessDataPanel.setVisible(true);
						NoProcessPanel.setVisible(false);
						int NO = Integer.parseInt(NoProcessField.getText());

						Panel ProcessBigPanel = new Panel();
						ProcessBigPanel.setLayout(new FlowLayout());
						ProcessBigPanel.setPreferredSize(new Dimension(310, 600));
						
						for(int i = 0;i < NO;i++){
							ProcessIDS.add(new JLabel("Process" + (i+1)));
							ProcessArrivalTime.add(new JTextField());
							ProcessBrustTime.add(new JTextField());
							ProcessPriority.add(new JTextField());
							ProcessIDS.get(i).setPreferredSize(new Dimension(70, 30));
							ProcessArrivalTime.get(i).setPreferredSize(new Dimension(74, 30));
							ProcessBrustTime.get(i).setPreferredSize(new Dimension(74, 30));
							ProcessPriority.get(i).setPreferredSize(new Dimension(74, 30));
							ProcessPanel.add(new JPanel());
							ProcessPanel.get(i).setPreferredSize(new Dimension(320, 35));
							ProcessPanel.get(i).add(ProcessIDS.get(i));
							ProcessPanel.get(i).add(ProcessArrivalTime.get(i));
							ProcessPanel.get(i).add(ProcessBrustTime.get(i));
							ProcessPanel.get(i).add(ProcessPriority.get(i));
							ProcessBigPanel.add(ProcessPanel.get(i));
						}
						
						JScrollPane ProcessBigScrollPanel = new JScrollPane(ProcessBigPanel);
						ProcessBigScrollPanel.setBounds(10, 47, 330, 540);
						ProcessDataPanel.add(ProcessBigScrollPanel);
					}
				}catch(NumberFormatException ex){
					
				}
				
			}
		});
		
		btnRestart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ResultPanel.setVisible(false);
				NoProcessPanel.setVisible(true);
				NoProcessField.setText("");
				setBounds(100, 100, 357, 179);
			}
		});
		
		btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnContinue.setBounds(108, 80, 104, 27);
		NoProcessPanel.add(btnContinue);
	}
	
	public boolean ValidateProcessInput(){
		boolean flag = true;
		int n = Integer.parseInt(NoProcessField.getText());
		for(int i = 0;i < n && flag;i++){
			try{
				if(ProcessArrivalTime.get(i).getText() != "" && Integer.parseInt(ProcessArrivalTime.get(i).getText()) >= 0){}
			}catch(NumberFormatException ex){
				flag = false;
			}
		}
		for(int i = 0;i < n && flag;i++){
			try{
				if(ProcessBrustTime.get(i).getText() != "" && Integer.parseInt(ProcessBrustTime.get(i).getText()) >= 0){}
			}catch(NumberFormatException ex){
				flag = false;
			}
		}
		for(int i = 0;i < n && flag;i++){
			try{
				if(ProcessPriority.get(i).getText() != "" && Integer.parseInt(ProcessPriority.get(i).getText()) >= 0){}				
			}catch(NumberFormatException ex){
				flag = false;
			}
		}
		return flag;
	}
}
