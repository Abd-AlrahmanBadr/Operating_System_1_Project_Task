import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class OSProject {

	public static void main(String[] args) {
/*
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ProcessManager PM = new ProcessManager(n);
		ArrayList<Process> P = new ArrayList<Process>();
		P.add(new Process(1, 0, 3, 3));
		P.add(new Process(2, 2, 5, 1));
		PM.SetProcess(P, 8);
		PM.StartProcessSimulation();
		PM.SimulateGanttChart();
		ArrayList<Integer> GC = PM.GetGanttChart();
		for(int i = 0;i < GC.size();i++){
			System.out.print(GC.get(i));
		}
		System.out.println();
		ArrayList<Integer> WT = PM.GetWaitTime();
		for(int i = 0;i < n;i++){
			System.out.println("WT : " + WT.get(i));
		}
		ArrayList<Integer> TT = PM.GetTurnaroundTime();
		for(int i = 0;i < n;i++){
			System.out.println("TT : " + TT.get(i));
		}
		double AVGWT = PM.CalculateAverageWaitingTime();
		System.out.println("AVGWT : " + AVGWT);
		double AVGTT = PM.CalculateAverageTurnaroundTime();
		System.out.println("AVGTT : " + AVGTT);
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		int NoProcess;
		int TotalTime = 0;
		NoProcess = sc.nextInt();
		
		ArrayList<Process> l = new ArrayList<Process>();
		ArrayList<Process> lTemp = new ArrayList<Process>();
		
		for(int i = 0;i < NoProcess;i++){
			System.out.print("P " + (i+1) + " : ");
			int TempAriavalTime = sc.nextInt();
			int TempBrustTime = sc.nextInt();
			TotalTime += TempBrustTime;
			int TempPriority = sc.nextInt();
			l.add(new Process(i+1, TempAriavalTime, TempBrustTime, TempPriority));
			lTemp.add(new Process(i+1, TempAriavalTime, TempBrustTime, TempPriority));
		}
		sc.close();
		
		Collections.sort(l);
		
		ArrayList<Integer> GanttChart = new ArrayList<Integer>();
		ArrayList<Process> ReadyQueue = new ArrayList<Process>();
		for(int i = 0,Counter = 0;i < TotalTime;i++){
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
		for(int i = 0;i < TotalTime;i++){
			System.out.print(GanttChart.get(i));
		}
		System.out.println();
		for(int i = 0;i < TotalTime;i++){
			System.out.print(i%10);
		}
		ArrayList<Integer> End = new ArrayList<Integer>();
		for(int i = 0;i < NoProcess;i++){
			End.add(0);
		}
		for(int i = 0;i < GanttChart.size();i++){
			if(End.get(GanttChart.get(i) - 1) < i)
				End.set(GanttChart.get(i) - 1, i);
		}
		System.out.println();
		int WaitTimeTotal = 0;
		for(int i = 0;i < NoProcess;i++){
			WaitTimeTotal += (End.get(i) - lTemp.get(i).getArraivalTime() - lTemp.get(i).getBrustTime() + 1);
			System.out.println("Wait Time of " + (i + 1) + " : " + (End.get(i) - lTemp.get(i).getArraivalTime() - lTemp.get(i).getBrustTime() + 1));
		}
		System.out.println("Waiting Time Average : " + WaitTimeTotal / NoProcess);
		int TurnaroundTimeTotal = 0;
		for(int i = 0;i < NoProcess;i++){
			TurnaroundTimeTotal += (End.get(i) - lTemp.get(i).getArraivalTime() + 1);
			System.out.println("Turnaround Time of " + (i + 1) + " = " + (End.get(i) - lTemp.get(i).getArraivalTime() + 1));
		}
		System.out.println("Turnaround Average Time " + TurnaroundTimeTotal / NoProcess);
		*/
	}

}
