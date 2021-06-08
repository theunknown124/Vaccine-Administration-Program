import java.util.LinkedList;
import java.util.Scanner;


public class Administrator {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in); // Scanner class for user input
		Scanner keyboard = new Scanner(System.in); // Scanner class for clinican list
		
		LinkedList <vaccineRecipient> recipList = new LinkedList<>(); //initializing a linkedlist holding VaccineRecipient objects
		
		ClinicianList OceanCounty = new ClinicianList(); //Clinician List
		
		LinkedList<Appointment> appointmentList = new LinkedList<>();
		
		
		//These are the Objects to test 
		Appointment a1 = new Appointment("0010", "12345", "0000", "4PM");
		appointmentList.add(a1);
		
		//Appointment a5 = new Appointment("0013", "12345", "0000", "6PM");
		//appointmentList.add(a5);
		
		Appointment a4 = new Appointment("0014", "12345", "0000", "8PM");
		appointmentList.add(a4);
		
		Appointment a2 = new Appointment("0011", "21345", "0001", "5PM");
		appointmentList.add(a2);
		
		Appointment a3 = new Appointment("0012", "19445", "0002", "6PM");
		appointmentList.add(a3);
		
		vaccineRecipient p1 = new vaccineRecipient("0000", "Warren", "completed", 2);
		recipList.add(p1);
		
		vaccineRecipient p2 = new vaccineRecipient("0001", "Brandon", "not completed", 1);
		recipList.add(p2);
		
		vaccineRecipient p3 = new vaccineRecipient("0002", "Kyle", "not completed", 0);
		recipList.add(p3);
		
		OceanCounty.addFirst("John", "Ocean Medical", 12345, 23 );
		
		OceanCounty.addFirst("Debra", "Ocean Medical", 21345, 13 );
		OceanCounty.addFirst("Jen", "Ocean Medical", 19445, 23 );
		OceanCounty.addFirst("Ben", "Ocean Medical", 16645, 23 );
		
		
		
		//entries already in the list
		int num = 0;
	     int CID = 0;
	     int inv = 0;
	     String name = "" ;
	     String Ins = "";
	     String YN = "Y";
		
		int choice;
		
		
		do {
			choice = VaccineRecipientMenu();
			switch(choice) {
			
			case 1: //Add a new Recipient
					String newID = "";
					String newName = "";
					String newPreVacQues = "";
					int newNumofDoses = 0;
					boolean IDcheck = false;
					boolean addRecipient = false; 
					
					do { 
						System.out.println("Enter a new Recipient ID");
						newID = userInput.next();
						
						for(int a = 0; a < recipList.size(); a++) {
							if(newID.equals(recipList.get(a).getID())) {
								System.out.println("ID number already exists in the list");
								IDcheck = true;
							}
							
						}
						if(!IDcheck) {
							System.out.println("New ID entered:\n");
							
							System.out.println("Enter name:");
							newName = userInput.next();//input name
							
							System.out.println("Did the recipient take the Prevaccination Questionaire? Type Yes or No");
							newPreVacQues = userInput.next(); //Input should either be a yes or a no
							
							System.out.println("How many doses did the recipient take?");
							newNumofDoses = userInput.nextInt(); //input should either be 0 or 1 or 2
							addRecipient = true;
							
							
						}
						
						if(addRecipient) {
							vaccineRecipient temp = new vaccineRecipient(newID, newName, newPreVacQues, newNumofDoses);
							recipList.add(temp);
							break;
						}
					
					}while(IDcheck != true);
					
					break;
					
			////////////////////////////////////////////////////////////////////////////
			case 2: //Remove an Recipient
					String removeRecipient = "";
					boolean removeRecipID = false;
					
					System.out.println("Enter the name of the recipient you want to remove from the list:");
					removeRecipient = userInput.next(); //user input to remove specific recipient
					userInput.nextLine();
					
					int rI = -1; //recipient Index
						
						for (int r = 0; r < recipList.size(); r++) {
							if(removeRecipient.equals(recipList.get(r).getName())) {
								rI = r;
								
								break;
							}
							
		
						}

						if(rI != -1) { //if recipient is found in the list
							System.out.println("Removing " + removeRecipient + " from the list");
							System.out.println("Name: " + recipList.get(rI).getName());
							System.out.println("Vaccination Questionaire: " + recipList.get(rI).getPrevaccinationQuestionaire());
							System.out.println("Number of Doses: " + recipList.get(rI).getNumOfDoses());
							System.out.println("Vaccination Certificate: " + recipList.get(rI).vaccinationCertificate());
							//recipList.remove(recipList.get(rI));
						
							
							
							for (int aptt = 0; aptt < appointmentList.size(); aptt++) {
								//System.out.println("test");
								if (recipList.get(rI).getID().equals(appointmentList.get(aptt).getRID())) {
									
									appointmentList.remove(appointmentList.get(aptt));//Removes the first appointment
									appointmentList.remove(appointmentList.get(aptt));//Removes the second appointment
									//System.out.println("test");// remove all appointments
									
									
								}



							}
							
							
						
							
							recipList.remove(recipList.get(rI));// removes the recipient from the list
				
						}
						else { //if recipient index is still -1
							System.out.println("Recipient not found in list");
						}
						
						
					
					break;
					
					/////////////////////////////////////////////////////
			case 3:	//Checking Prevaccination Questionaire
					System.out.println("Enter name to check the Prevaccination Questionaire status");
					String recipPreVac = userInput.next();
					
					for (int v = 0; v < recipList.size(); v++) {
						if(recipPreVac.equals(recipList.get(v).getName())) {
							System.out.println("ID: " + recipList.get(v).getID());
							System.out.println("Name: " + recipList.get(v).getName());
							System.out.println("Vaccination Questionaire: " + recipList.get(v).getPrevaccinationQuestionaire());
						}
					}
					break;
					
					//////////////////////////////////////////////////////////////
					
			case 4: //Checking number of doses
					System.out.println("Enter name to check the number of Doses:");
					String recipSearch = userInput.next();
					
					for (int s = 0; s < recipList.size(); s++){
						if(recipSearch.equals(recipList.get(s).getName())) {
							System.out.println("ID: " + recipList.get(s).getID());
							System.out.println("Name: " + recipList.get(s).getName());
							System.out.println("Number of Doses: " + recipList.get(s).getNumOfDoses());
							
						}
					}
					break;
					//////////////////////////////////////////////////////////
			case 5: PrintLinkedList(recipList); //Print out Recipient List
					break;
					
					///////////////////////////////////////////////////////////
					
			case 6: //Adding Clinicans to Cin
					System.out.println("-Entry Page-\n"
						+ "Enter Clinician Name");
					name = keyboard.next().toString();
					System.out.println("Enter the Institution");
					Ins = keyboard.next().toString();
					System.out.println("Enter the Clinician ID Number");
					CID = keyboard.nextInt();
					System.out.println("Enter the Clinician's current vaccine stock");
					inv = keyboard.nextInt();
					OceanCounty.addFirst(name, Ins, CID, inv);
					System.out.println("Clinician entered");
					
					break;
					////////////////////////////////////////////
			case 7: //Updating a Clinicans institution
					System.out.println("-Update Institution page-\n"
						+ "Enter name of Clinician whose Institution you want to update:");
					name = keyboard.next().toString();
					System.out.println("Enter Instituion to add");
					Ins = keyboard.next().toString();
					OceanCounty.updateIns(name, Ins);
					System.out.println("-Current List-");
					OceanCounty.getInfo();
					
					System.out.println("");
					
				
					break;
					//////////////////////////////////////////////
			case 8: // Updating Clinicians ID number
					System.out.println("-Update Clinician's ID page-\n"
						+ "Enter name of Clinician whose ID you want to update:");
					name = keyboard.next().toString();
					System.out.println("Enter CID to add");
					CID = keyboard.nextInt();
					OceanCounty.updateCID(name, CID);
					System.out.println("-Current List-");
					OceanCounty.getInfo();
					
					System.out.println("Clinician ID updated");
					
					break;
					//////////////////////////////////////////////
			case 9: //Updating Clinicians vaccine inventory
					System.out.println("-Update Clinician's Vaccine Stock page-\n"
						+ "Enter name of Clinician whose Vaccine Stock you want to update:");
					name = keyboard.next().toString();
					System.out.println("Enter how much you would like their Vaccine Inventory to be");
					inv = keyboard.nextInt();
					OceanCounty.updateInv(name, inv);
					System.out.println("-Current List-");
					OceanCounty.getInfo();
					
					System.out.println("Clinician Vaccine Inventory updated");
					
					break;
					/////////////////////////////////////////////
					
			case 10://Removing a Clinician page
					System.out.println("-Remove Clinician page-\n"
					+ "Enter name of Clinician who you want to remove:");
					name = keyboard.next().toString();
					OceanCounty.removeName(name);
					
					System.out.println("Clinician: " + name + " removed");
					
					break;
					
				///////////////////////////////////////////////
			case 11://Printing out clinician list
					System.out.println("\n");
					OceanCounty.getInfo();
					System.out.println("\n");
					break;
				
					////////////////////////////////////////////
			case 12: //Schedule an appointment
					String searchRID = "";
					String searchCID = "";
					String appTime = "";
					String RIDapp = "";
					String newAPTID = "";
					String newTime = "";
					boolean RIDfound = false;
					boolean CIDfound = false;
					
					System.out.println("To schedule an appointment, please enter Recipient name:");
					searchRID = userInput.nextLine();// user input for recipient in the list
					
					int rIB = -1;
					
					for (int RID = 0; RID < recipList.size(); RID++) {
						if(searchRID.equals(recipList.get(RID).getName())) {
							RIDapp = recipList.get(RID).getID();
							rIB = RID;
							RIDfound = true; //sets RIDfound to true so user can input the clinician ID part of the appointment
						}
						
					}
						
						//if(RIDfound == true) {
						if(rIB != -1) {
							System.out.println("Enter the Clinician to adminstrator the vaccine:");
							searchCID = userInput.next();// user input for clinician in the list
							
							int tempCID = OceanCounty.getCID(searchCID);
							
							
							
							if(tempCID == 0) {// if Clinician name is not found, program will display what is under
								System.out.println("Clinician name not found");
								System.out.println("Going back to the menu");
								//System.out.println("CIDfound status:" + CIDfound); // debug for  boolean CIDfound 
								break;
							}
							
							String CIDstring = String.valueOf(tempCID);
							CIDfound = true;
							//System.out.println("CIDfound status:" + CIDfound);// debug for  boolean CIDfound 
							
							
						}
						if(CIDfound == true) {
							System.out.println("Enter an appointment ID:");
							newAPTID = userInput.next();
							
							System.out.println("Enter a time such as 4PM:");
							newTime = userInput.next();
							
							
							int tempCID = OceanCounty.getCID(searchCID);
							String CIDstring = String.valueOf(tempCID);
							Appointment app = new Appointment(newAPTID, CIDstring, RIDapp, newTime);//creates a new appointment
							appointmentList.add(app);
							System.out.println("Adding appointment"); //system telling the user the appoinment has been added
							break;
						}
						else{
							System.out.println("Recipient not found");
							//break;
						}
						
		
						
						
					//}
					
					
					break;
					/////////////////////////////////////////////
			case 13://Reschedule  Appointment
					String rescheduleAPTID = "";
					String rescheduleTime = "";
					boolean aptExists = false;
					boolean aptChange = false;
					int t = -1; 
					
					System.out.println("Enter the Appointment ID you wish to reschedule:");
					rescheduleAPTID = userInput.next();
					
					for (int aptFind = 0; aptFind < appointmentList.size(); aptFind++) {
						if (rescheduleAPTID.equals(appointmentList.get(aptFind).getApptID())) {
							t = aptFind;
							
							aptExists = true;
						}
						
					}
						
						if(t != -1) {
							System.out.println("Enter a new time such as 2PM");
							rescheduleTime = userInput.next();
							aptChange = true;
							
						}
						if(aptChange == true) {
							appointmentList.get(t).setTime(rescheduleTime);
							break;
						}
						else {
							System.out.println("Appointment not found");
							System.out.println("Going back to menu");
							
						}
						
					
					
					
					break;
					//////////////////////////////////////////
			case 14://Printing out appointments
					PrintAppointmentList(appointmentList);
					break;
					
					
					//////////////////////////////////////////
					
			case 15: System.out.println("System Exiting");
					System.exit(0);
					break;
			
			}
			
		}while (choice != 15);
		
		
	}
	
	//////////////////////////////////////////////////////
	static int VaccineRecipientMenu() {
		
		int ch = 0;
		boolean invalidChoice;// checks if ch is a valid choice
		Scanner keyboard2 = new Scanner(System.in);
		
		do {
			System.out.println("\n--------------------\n");
			System.out.println("1. Add an Recipient");
			System.out.println("2. Remove an Recipient");
			System.out.println("3. Check PrevaccinationQuestionaire status");
			System.out.println("4. Check number of doses of a Recipient");
			System.out.println("5. Print all Recipient current information");
			System.out.println("6. Create a Clinician entry:");
			System.out.println("7. Update a Clinicians institution:");
			System.out.println("8. Update a Clinicians ID number:");
			System.out.println("9. Update a Clinicians vaccine inventory");
			System.out.println("10. Remove a Clinician");
			System.out.println("11. Print List of Clincians");
			System.out.println("12. Schedule Appointment (Add appointment)");
			System.out.println("13. Reschedule Appointment");
			System.out.println("14. Print all Appointments");
			System.out.println("15. System Close");
			
			System.out.println("Choice (1-15):");
			ch = keyboard2.nextInt();
			
			invalidChoice = (ch < 1 || ch > 15);
			
			if (invalidChoice) {
				System.out.println("Invalid choice! please try again! (1-15)");
			}
			
		}while (invalidChoice);
		
		return ch;
	}
	//////////////////////////////////////////////////////////
	static void PrintLinkedList(LinkedList<vaccineRecipient> recipList) {
		
		for (int p = 0; p < recipList.size(); p++) {
			recipList.get(p).printInfo();
		}
	}
	
	/////////////////////////////////////////////////////////
	static void PrintAppointmentList(LinkedList<Appointment> appointmentList) {
		
		for (int Apt = 0; Apt < appointmentList.size(); Apt++) {
			appointmentList.get(Apt).printInfo();
		}
	}
}
