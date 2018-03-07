import java.util.ArrayList;
import java.util.Collections;

public class ProcessManager {
	
	private int NoProcess;
	private int TotalTime;
	private ArrayList<Process> ProcessMainData;
	private ArrayList<Process> ProcessSorted;
	private ArrayList<Integer> GanttChart;
	private ArrayList<Process> ReadyQueue;
	private ArrayList<Integer> End;
	private int TotalWaitingTime;
	private ArrayList<Integer> WaitTime;
	private int TotalTurnaroundTime;
	private ArrayList<Integer> TurnaroundTime;
	
	public ProcessManager(int noProcess){
		this.NoProcess = noProcess;
		this.TotalTime = 0;
		this.ProcessMainData = new ArrayList<Process>();
		this.ProcessSorted = new ArrayList<Process>();
		this.GanttChart = new ArrayList<Integer>();
		this.ReadyQueue = new ArrayList<Process>();
		this.End = new ArrayList<Integer>();
		this.TotalWaitingTime = 0;
		this.WaitTime = new ArrayList<Integer>();
		this.TotalTurnaroundTime = 0;
		this.TurnaroundTime = new ArrayList<Integer>();
		
		for(int i = 0;i < this.NoProcess;i++){
			this.End.add(0);
		}
	}
	
	public void SetProcess(ArrayList<Process> process,int totalTime){
		this.ProcessMainData = process;
		this.ProcessSorted = process;
		Collections.sort(this.ProcessSorted);
		this.TotalTime = totalTime;
	}
	
	public void StartProcessSimulation(){
		for(int i = 0,Counter = 0;i < TotalTime;i++){
			if(Counter < this.NoProcess && this.ProcessSorted.get(Counter).getArraivalTime() <= i){
				this.ReadyQueue.add(this.ProcessSorted.get(Counter));
				Counter++;
			}
			int CurrentWorkingProcessIndex = 0;
			for(int j = 1;j < this.ReadyQueue.size();j++){
				if(this.ReadyQueue.get(j).getPriority() < this.ReadyQueue.get(CurrentWorkingProcessIndex).getPriority()){
					CurrentWorkingProcessIndex = j;
				}else if(	this.ReadyQueue.get(j).getPriority() == this.ReadyQueue.get(CurrentWorkingProcessIndex).getPriority() &&
							this.ReadyQueue.get(j).getArraivalTime() < this.ReadyQueue.get(CurrentWorkingProcessIndex).getArraivalTime()){
					CurrentWorkingProcessIndex = j;
				}
			}
			if(ReadyQueue.size() > 0){
				this.ReadyQueue.get(CurrentWorkingProcessIndex).setBrustTime(this.ReadyQueue.get(CurrentWorkingProcessIndex).getBrustTime()-1);
				this.GanttChart.add(ReadyQueue.get(CurrentWorkingProcessIndex).getID());
				if(this.ReadyQueue.get(CurrentWorkingProcessIndex).getBrustTime() == 0){
					this.ReadyQueue.remove(CurrentWorkingProcessIndex);
				}
			}
		}
	}
	
	public void SimulateGanttChart(){
		for(int i = 0;i < this.GanttChart.size();i++){
			if(this.End.get(this.GanttChart.get(i) - 1) < i)
				this.End.set(this.GanttChart.get(i) - 1, i);
		}
		for(int i = 0;i < NoProcess;i++){
			this.TotalWaitingTime += (this.End.get(i) - this.ProcessMainData.get(i).getArraivalTime() - this.ProcessMainData.get(i).getBrustTime() + 1);
			this.WaitTime.add(this.End.get(i) - this.ProcessMainData.get(i).getArraivalTime() - this.ProcessMainData.get(i).getBrustTime() + 1);
		}
		for(int i = 0;i < NoProcess;i++){
			this.TotalTurnaroundTime += (this.End.get(i) - this.ProcessMainData.get(i).getArraivalTime() + 1);
			this.TurnaroundTime.add(this.End.get(i) - this.ProcessMainData.get(i).getArraivalTime() + 1);
		}
	}
	
	public ArrayList<Integer> GetGanttChart(){
		return this.GanttChart;
	}
	
	public ArrayList<Integer> GetWaitTime(){
		return this.WaitTime;
	}
	
	public ArrayList<Integer> GetTurnaroundTime(){
		return this.TurnaroundTime;
	}
	
	public double CalculateAverageWaitingTime(){
		return this.TotalWaitingTime / this.NoProcess;
	}
	
	public double CalculateAverageTurnaroundTime(){
		return this.TotalTurnaroundTime / this.NoProcess;
	}
	
}
