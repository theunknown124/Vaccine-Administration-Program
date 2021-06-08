/**
 * 
 */

/**
 * @author Andy Vuong
 *
 */
public class Appointment {
	private String ApptID;
	private String RID;
	private String CID;
	private String Time;
	
	public Appointment(String AptID, String CID, String RID, String Time) {
		super();
		ApptID = AptID;
		this.RID = RID;
		this.CID = CID;
		this.Time = Time;
	}

	public String getApptID() {
		return ApptID;
	}

	public String getRID() {
		return RID;
	}

	public String getCID() {
		return CID;
	}

	public String getTime() {
		return Time;
	}

	public void setApptID(String AptID) {
		ApptID = AptID;
	}
	
	public void setRID(String RID) {
		this.RID = RID;
	}
	
	public void setCID(String CID) {
		this.CID = CID;
	}
	
	public void setTime(String Time) {
		this.Time = Time;
	}

	
	public void printInfo() {
		
		System.out.println("Appointment ID: " + getApptID());
		System.out.println("RID: " + getRID());
		System.out.println("CID: " + getCID());
		System.out.println("Time: " + getTime());
		System.out.println();
	}
	
}
