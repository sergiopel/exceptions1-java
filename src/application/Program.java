package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	// se ocorrer exceção, será propagada no método ParseException (throws ParseException)
	// sempre que ocorrer uma exceção dentro de um método (no caso o 'main', ou vc trata
	// a exceção com try...catch, ou vc propaga a exceção
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		//entra em formato texto em sc.next() e depois é transformado em date
		Date checkIn = sdf.parse(sc.next()); 
		System.out.print("Check-out date (dd/MM/yyyy): ");
		//entra em formato texto em sc.next() e depois é transformado em date
		Date checkOut = sdf.parse(sc.next()); 
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after ckeck-in date");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next()); 
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			} else {
				System.out.println("Reservation: " + reservation);			
			}
			
		}
		
		
		
		sc.close();

	}

}
