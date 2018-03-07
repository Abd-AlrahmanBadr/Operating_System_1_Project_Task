
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class eltask {

	int i = 0;
	String s = null;
	String sa=null;
	ArrayList<String> PID = new ArrayList<String>();
	ArrayList<String> UID = new ArrayList<String>();
	ArrayList<String> PPID = new ArrayList<String>();
	ArrayList<String> C = new ArrayList<String>();
	ArrayList<String> Stime = new ArrayList<String>();
	ArrayList<String> TTY = new ArrayList<String>();
	ArrayList<String> UpTime = new ArrayList<String>();
	ArrayList<String> CMD = new ArrayList<String>();
	
	public void showproccess() throws IOException {
		
		Process p = Runtime.getRuntime().exec("ps -ef");
		BufferedReader stdinput = new BufferedReader(new InputStreamReader(p.getInputStream()));

		while ((s = stdinput.readLine()) != null) {
			Scanner sc = new Scanner(s);
			UID.add(sc.next());
			PID.add(sc.next());
			PPID.add(sc.next());
			C.add(sc.next());
			Stime.add(sc.next());
			TTY.add(sc.next());
			UpTime.add(sc.next());
			CMD.add(sc.next());

			//System.out.print(UID.get(i) + "\t");
			//System.out.print(PID.get(i) + "\t");
			//System.out.print(Stime.get(i) + "\t");
			//System.out.print(UpTime.get(i) + "\t");
			//System.out.print(CMD.get(i) + "\t");
			//System.out.print("\n");
			i++;
		}

	}

	public ArrayList<String> getPID() {
		return this.PID;
	}

	public ArrayList<String> getUID() {
		return UID;
	}

	public ArrayList<String> getStime() {
		return Stime;
	}

	public ArrayList<String> getUpTime() {
		return UpTime;
	}

	public ArrayList<String> getCMD() {
		return CMD;
	}

	public boolean killprocess(String PID) throws IOException {
		String m = "kill " + PID;
		Process f = Runtime.getRuntime().exec(m);
		BufferedReader stdErr = new BufferedReader(new InputStreamReader(f.getErrorStream()));
		if (stdErr == null){
			return false;
		}
		return true;
	}
	@SuppressWarnings("unused")
	public boolean startproccess(String proc) throws IOException{
		String pross = proc;
		Process r = Runtime.getRuntime().exec(pross);
		BufferedReader stdErr = new BufferedReader(new InputStreamReader(r.getErrorStream()));
		if (stdErr == null){
			return false;
		}
		
		return true;
		
	}
	
	public String getprocessID(String procname) throws IOException{
		String thename = "pidof "+procname;
		Process p = Runtime.getRuntime().exec(thename);
		BufferedReader stdinput = new BufferedReader(new InputStreamReader(p.getInputStream()));
		sa = stdinput.readLine();
			
		//Scanner sca = new Scanner(sa);
			
		return sa;
		
	}
}
