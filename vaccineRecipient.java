//
/** 
 * 
 * @author Warren
 *
 */
public class vaccineRecipient {
	
	private String ID;
	private String name;
	private String prevaccinationQuestionaire; //1.Completed 2. Not Completed
	private int numOfDoses;
	boolean vaccinationCertificate;
	
	/**
	 * @param iD
	 * @param name
	 * @param prevaccinationQuestionaire
	 * @param numOfDoses
	 */
	public vaccineRecipient(String iD, String name, String prevaccinationQuestionaire, int numOfDoses) {
		super();//These variables are just stand in they should change when creating the Administrator component
		ID = iD;
		this.name = name;
		this.prevaccinationQuestionaire = prevaccinationQuestionaire;
		this.numOfDoses = numOfDoses;
	}

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the prevaccinationQuestionaire
	 */
	public String getPrevaccinationQuestionaire() {
		return prevaccinationQuestionaire;
	}

	/**
	 * @return the numOfDoses
	 */
	public int getNumOfDoses() {
		return numOfDoses;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @param prevaccinationQuestionaire the prevaccinationQuestionaire to set
	 */
	public void setPrevaccinationQuestionaire(String prevaccinationQuestionaire) {
		this.prevaccinationQuestionaire = prevaccinationQuestionaire;
	}

	public boolean vaccinationCertificate() {
		 
		if (numOfDoses == 2) { //if number of doses is two then return true
			System.out.println("Recipient has received the required amount of doses");
			return true;
		}
		else {
			System.out.println("Recipient has not received the required amout of doses");
		return false;
		}
	}
	
	public void printInfo() {
		
		System.out.println("ID: " + getID());
		System.out.println("Name: " + getName());
		System.out.println("Vaccination Questionaire: " + getPrevaccinationQuestionaire());
		System.out.println("Number of Doses: " + getNumOfDoses());
		System.out.println("Vaccination Certificate: " + vaccinationCertificate());
		System.out.println();
	}
	
	
	
	
	
	

}
