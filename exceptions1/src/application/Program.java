package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try { // tentou realizar o bloco completo atrav�s do 'try'
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next()); /*
													 * instanciou uma vari�vel data e aplicou a m�scara de formata��o
													 * sdf ao que foi lindo como string
													 */
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		} catch (ParseException e) { /*
										 * capturou uma exce��o parse (na convers�o de String para Date e apresentou a
										 * mensagem
										 */
			System.out.println("Invalid date format");
		} catch (DomainException e) { /*
										 * capturou a exce��o e apresentou a mensagem de erro atrav�s do m�dotod
										 * getMessage
										 */
			System.out.println("Error in reservation: " + e.getMessage());
		} catch (RuntimeException e) { /* RuntimeException � uma classe de exce��es gen�ricas */
			System.out.println("Unexpected error");
		}

		sc.close();
	}
}
