
public class Process implements Comparable<Process>{
	
	private int ArraivalTime;
	private int BrustTime;
	private int Priority;
	private int ID;	
	
	public Process(int iD,int arrivalTime, int brustTime, int priority){
		this.ID = iD;
		this.ArraivalTime = arrivalTime;
		this.BrustTime = brustTime;
		this.Priority = priority;
	}

	public int getArraivalTime() {
		return ArraivalTime;
	}

	public int getBrustTime() {
		return BrustTime;
	}

	public void setBrustTime(int brustTime) {
		BrustTime = brustTime;
	}

	public int getPriority() {
		return Priority;
	}

	public int getID() {
		return ID;
	}
	
	public int compareTo(Process x){
		int Temp = x.getArraivalTime();
		return this.ArraivalTime - Temp;
	}
	
}
