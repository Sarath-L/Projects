package ticketBooking;

import java.util.*;

public class BusUI {
	static Scanner sc = new Scanner(System.in);
	static boolean b=true;
	static BusDAO busdao = new BusDAO();
	static int userOpt=0;

	public static void main(String[] args) {

		try {	
			
			do {
				busdao.displayBusInfo();
				Thread.sleep(2000);
				System.out.println("Enter Your Choice\n1--> Book Ticket\n2--> Exit");
				int userOpt =sc.nextInt();				
				switch (userOpt) {
				case 1: {
					Booking booking = new Booking();
					if(booking.isAvailable()) {
						BookingDAO bookingdao = new BookingDAO();
						bookingdao.addBooking(booking);
						System.out.println("Your booking is confirmed");
					}
					else
						System.out.println("Sorry. Bus is full. Try another bus");
					break;}
				case 2: {
					System.out.println("*****Thanks for using our App*****");
					b=false;
					break;}
				
				default:
					System.out.println("Select a correct input");
				}	
			} while (b);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	//	booking();
	}
	
	public static void booking() {
		try {	
				busdao.displayBusInfo();
				Thread.sleep(2000);
				System.out.println("Enter Your Choice\n1--> Book\n2--> Exit");				
				userOpt =sc.nextInt();
				while (b) {
					if (userOpt==1) {
						Booking booking = new Booking();
						if(booking.isAvailable()) {
							BookingDAO bookingdao = new BookingDAO();
							bookingdao.addBooking(booking);
							System.out.println("Your booking is confirmed");
						}
						else
							System.out.println("Sorry. Bus is full. Try another bus or date.");
					}else if (userOpt==2) {
						System.out.println("*****Thanks for using our App*****");
					}else {
						System.out.println("Select a correct input");
					}	
				booking();
				}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
